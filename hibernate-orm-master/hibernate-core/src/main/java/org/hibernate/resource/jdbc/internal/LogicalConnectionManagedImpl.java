/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.resource.jdbc.internal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import org.hibernate.ConnectionAcquisitionMode;
import org.hibernate.ConnectionReleaseMode;
import org.hibernate.ResourceClosedException;
import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.resource.jdbc.ResourceRegistry;
import org.hibernate.resource.jdbc.spi.JdbcObserver;
import org.hibernate.resource.jdbc.spi.JdbcSessionContext;
import org.hibernate.resource.jdbc.spi.LogicalConnectionImplementor;

/**
 * Represents a LogicalConnection where we manage obtaining and releasing the Connection as needed.
 *
 * @author Steve Ebersole
 */
public class LogicalConnectionManagedImpl extends AbstractLogicalConnectionImplementor {
	private static final Logger log = Logger.getLogger( LogicalConnectionManagedImpl.class );

	private final transient JdbcConnectionAccess jdbcConnectionAccess;
	private final transient JdbcObserver observer;
	private final transient SqlExceptionHelper sqlExceptionHelper;
	private final transient ConnectionReleaseMode connectionReleaseMode;

	private transient Connection physicalConnection;
	private boolean closed;

	public LogicalConnectionManagedImpl(
			JdbcConnectionAccess jdbcConnectionAccess,
			JdbcSessionContext jdbcSessionContext) {
		this( jdbcConnectionAccess, jdbcSessionContext, new ResourceRegistryStandardImpl() );
	}

	public LogicalConnectionManagedImpl(
			JdbcConnectionAccess jdbcConnectionAccess,
			JdbcSessionContext jdbcSessionContext,
			ResourceRegistry resourceRegistry) {
		this.jdbcConnectionAccess = jdbcConnectionAccess;
		this.observer = jdbcSessionContext.getObserver();

		this.sqlExceptionHelper = jdbcSessionContext.getServiceRegistry()
				.getService( JdbcServices.class )
				.getSqlExceptionHelper();
		this.connectionReleaseMode = jdbcSessionContext.getConnectionReleaseMode();
		this.resourceRegistry = resourceRegistry;

		if ( jdbcSessionContext.getConnectionAcquisitionMode() == ConnectionAcquisitionMode.IMMEDIATELY ) {
			if ( jdbcSessionContext.getConnectionReleaseMode() != ConnectionReleaseMode.ON_CLOSE ) {
				throw new IllegalStateException(
						"Illegal combination of ConnectionAcquisitionMode#IMMEDIATELY with !ConnectionReleaseMode.ON_CLOSE"
				);
			}
			acquireConnectionIfNeeded();
		}
	}

	private LogicalConnectionManagedImpl(
			JdbcConnectionAccess jdbcConnectionAccess,
			JdbcSessionContext jdbcSessionContext,
			boolean closed) {
		this( jdbcConnectionAccess, jdbcSessionContext, new ResourceRegistryStandardImpl() );
		this.closed = closed;
	}


	private Connection acquireConnectionIfNeeded() {
		if ( physicalConnection == null ) {
			// todo : is this the right place for these observer calls?
			observer.jdbcConnectionAcquisitionStart();
			try {
				physicalConnection = jdbcConnectionAccess.obtainConnection();
			}
			catch (SQLException e) {
				throw sqlExceptionHelper.convert( e, "Unable to acquire JDBC Connection" );
			}
			finally {
				observer.jdbcConnectionAcquisitionEnd( physicalConnection );
			}
		}
		return physicalConnection;
	}

	@Override
	public boolean isOpen() {
		return !closed;
	}

	@Override
	public boolean isPhysicallyConnected() {
		return physicalConnection != null;
	}

	@Override
	public Connection getPhysicalConnection() {
		errorIfClosed();
		return acquireConnectionIfNeeded();
	}

	@Override
	public void afterStatement() {
		super.afterStatement();

		if ( connectionReleaseMode == ConnectionReleaseMode.AFTER_STATEMENT ) {
			if ( getResourceRegistry().hasRegisteredResources() ) {
				log.debug( "Skipping aggressive release of JDBC Connection after-statement due to held resources" );
			}
			else {
				log.debug( "Initiating JDBC connection release from afterStatement" );
				releaseConnection();
			}
		}
	}

	@Override
	public void afterTransaction() {
		super.afterTransaction();

		if ( connectionReleaseMode != ConnectionReleaseMode.ON_CLOSE ) {
			// NOTE : we check for !ON_CLOSE here (rather than AFTER_TRANSACTION) to also catch AFTER_STATEMENT cases
			// that were circumvented due to held resources
			log.debug( "Initiating JDBC connection release from afterTransaction" );
			releaseConnection();
		}
	}

	@Override
	public Connection manualDisconnect() {
		if ( closed ) {
			throw new ResourceClosedException( "Logical connection is closed" );
		}
		final Connection c = physicalConnection;
		releaseConnection();
		return c;
	}

	@Override
	public void manualReconnect(Connection suppliedConnection) {
		if ( closed ) {
			throw new ResourceClosedException( "Logical connection is closed" );
		}

		throw new IllegalStateException( "Cannot manually reconnect unless Connection was originally supplied by user" );
	}

	private void releaseConnection() {
		if ( physicalConnection == null ) {
			return;
		}

		// todo : is this the right place for these observer calls?
		observer.jdbcConnectionReleaseStart();
		try {
			if ( !physicalConnection.isClosed() ) {
				sqlExceptionHelper.logAndClearWarnings( physicalConnection );
			}
			jdbcConnectionAccess.releaseConnection( physicalConnection );
		}
		catch (SQLException e) {
			throw sqlExceptionHelper.convert( e, "Unable to release JDBC Connection" );
		}
		finally {
			observer.jdbcConnectionReleaseEnd();
			physicalConnection = null;
			getResourceRegistry().releaseResources();
		}
	}

	@Override
	public LogicalConnectionImplementor makeShareableCopy() {
		errorIfClosed();

		// todo : implement
		return null;
	}

	@Override
	public void serialize(ObjectOutputStream oos) throws IOException {
		oos.writeBoolean( closed );
	}

	public static LogicalConnectionManagedImpl deserialize(
			ObjectInputStream ois,
			JdbcConnectionAccess jdbcConnectionAccess,
			JdbcSessionContext jdbcSessionContext) throws IOException, ClassNotFoundException {
		final boolean isClosed = ois.readBoolean();
		return new LogicalConnectionManagedImpl( jdbcConnectionAccess, jdbcSessionContext, isClosed );
	}

	@Override
	public Connection close() {
		if ( closed ) {
			return null;
		}

		getResourceRegistry().releaseResources();

		log.trace( "Closing logical connection" );
		try {
			releaseConnection();
		}
		finally {
			// no matter what
			closed = true;
			log.trace( "Logical connection closed" );
		}
		return null;
	}


	// PhysicalJdbcTransaction impl ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	@Override
	protected Connection getConnectionForTransactionManagement() {
		return getPhysicalConnection();
	}

	boolean initiallyAutoCommit;

	@Override
	public void begin() {
		initiallyAutoCommit = determineInitialAutoCommitMode( getConnectionForTransactionManagement() );
		super.begin();
	}

	@Override
	protected void afterCompletion() {
		afterTransaction();

		resetConnection( initiallyAutoCommit );
		initiallyAutoCommit = false;
	}
}
