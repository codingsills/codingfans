/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.cache.spi;

import java.io.Serializable;
import java.util.Properties;
import java.util.Set;

import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.cache.CacheException;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.internal.CoreMessageLogger;

import org.jboss.logging.Logger;

/**
 * Tracks the timestamps of the most recent updates to particular tables. It is
 * important that the cache timeout of the underlying cache implementation be set
 * to a higher value than the timeouts of any of the query caches. In fact, we
 * recommend that the the underlying cache not be configured for expiry at all.
 * Note, in particular, that an LRU cache expiry policy is never appropriate.
 *
 * @author Gavin King
 * @author Mikheil Kapanadze
 */
public class UpdateTimestampsCache {
	private static final CoreMessageLogger LOG = Logger.getMessageLogger( CoreMessageLogger.class, UpdateTimestampsCache.class.getName() );
	private static final boolean DEBUG_ENABLED = LOG.isDebugEnabled();
	/**
	 * The region name of the update-timestamps cache.
	 */
	public static final String REGION_NAME = UpdateTimestampsCache.class.getName();


	private final SessionFactoryImplementor factory;
	private final TimestampsRegion region;

	/**
	 * Constructs an UpdateTimestampsCache.
	 *
	 * @param settings The SessionFactory settings
	 * @param props Any properties
	 * @param factory The SessionFactory
	 */
	public UpdateTimestampsCache(SessionFactoryOptions settings, Properties props, final SessionFactoryImplementor factory) {
		this.factory = factory;
		final String prefix = settings.getCacheRegionPrefix();
		final String regionName = prefix == null ? REGION_NAME : prefix + '.' + REGION_NAME;

		LOG.startingUpdateTimestampsCache( regionName );

		this.region = settings.getServiceRegistry().getService( RegionFactory.class ).buildTimestampsRegion( regionName, props );
	}

	/**
	 * Constructs an UpdateTimestampsCache.
	 *
	 * @param settings The SessionFactory settings
	 * @param props Any properties
	 */
	@SuppressWarnings({"UnusedDeclaration"})
	public UpdateTimestampsCache(SessionFactoryOptions settings, Properties props) {
		this( settings, props, null );
	}

	/**
	 * Perform pre-invalidation.
	 *
	 *
	 * @param spaces The spaces to pre-invalidate
	 *
	 * @param session
	 * @throws CacheException Indicated problem delegating to underlying region.
	 */
	public void preInvalidate(Serializable[] spaces, SessionImplementor session) throws CacheException {
		final boolean stats = factory != null && factory.getStatistics().isStatisticsEnabled();

		final Long ts = region.nextTimestamp() + region.getTimeout();

		for ( Serializable space : spaces ) {
			if ( DEBUG_ENABLED ) {
				LOG.debugf( "Pre-invalidating space [%s], timestamp: %s", space, ts );
			}

			try {
				session.getEventListenerManager().cachePutStart();

				//put() has nowait semantics, is this really appropriate?
				//note that it needs to be async replication, never local or sync
				region.put( space, ts );
			}
			finally {
				session.getEventListenerManager().cachePutEnd();
			}

			if ( stats ) {
				factory.getStatisticsImplementor().updateTimestampsCachePut();
			}
		}
	}

	/**
	 * Perform invalidation.
	 *
	 *
	 * @param spaces The spaces to pre-invalidate
	 *
	 * @param session
	 * @throws CacheException Indicated problem delegating to underlying region.
	 */
	public void invalidate(Serializable[] spaces, SessionImplementor session) throws CacheException {
		final boolean stats = factory != null && factory.getStatistics().isStatisticsEnabled();

		final Long ts = region.nextTimestamp();

		for (Serializable space : spaces) {
			if ( DEBUG_ENABLED ) {
				LOG.debugf( "Invalidating space [%s], timestamp: %s", space, ts );
			}

			try {
				session.getEventListenerManager().cachePutStart();

				//put() has nowait semantics, is this really appropriate?
				//note that it needs to be async replication, never local or sync
				region.put( space, ts );
			}
			finally {
				session.getEventListenerManager().cachePutEnd();
			}

			if ( stats ) {
				factory.getStatisticsImplementor().updateTimestampsCachePut();
			}
		}
	}

	/**
	 * Perform an up-to-date check for the given set of query spaces.
	 *
	 *
	 * @param spaces The spaces to check
	 * @param timestamp The timestamp against which to check.
	 *
	 * @param session
	 * @return Whether all those spaces are up-to-date
	 *
	 * @throws CacheException Indicated problem delegating to underlying region.
	 */
	public boolean isUpToDate(Set<Serializable> spaces, Long timestamp, SessionImplementor session) throws CacheException {
		final boolean stats = factory != null && factory.getStatistics().isStatisticsEnabled();

		for ( Serializable space : spaces ) {
			final Long lastUpdate = getLastUpdateTimestampForSpace( space, session );
			if ( lastUpdate == null ) {
				if ( stats ) {
					factory.getStatisticsImplementor().updateTimestampsCacheMiss();
				}
				//the last update timestamp was lost from the cache
				//(or there were no updates since startup!)
				//updateTimestamps.put( space, new Long( updateTimestamps.nextTimestamp() ) );
				//result = false; // safer
			}
			else {
				if ( DEBUG_ENABLED ) {
					LOG.debugf(
							"[%s] last update timestamp: %s",
							space,
							lastUpdate + ", result set timestamp: " + timestamp
					);
				}
				if ( stats ) {
					factory.getStatisticsImplementor().updateTimestampsCacheHit();
				}
				if ( lastUpdate >= timestamp ) {
					return false;
				}
			}
		}
		return true;
	}

	private Long getLastUpdateTimestampForSpace(Serializable space, SessionImplementor session) {
		Long ts = null;
		try {
			session.getEventListenerManager().cacheGetStart();
			ts = (Long) region.get( space );
		}
		finally {
			session.getEventListenerManager().cacheGetEnd( ts != null );
		}
		return ts;
	}

	/**
	 * Clear the update-timestamps data.
	 *
	 * @throws CacheException Indicates problem delegating call to underlying region.
	 */
	public void clear() throws CacheException {
		region.evictAll();
	}

	/**
	 * Destroys the cache.
	 *
	 * @throws CacheException Indicates problem delegating call to underlying region.
	 */
	public void destroy() {
		try {
			region.destroy();
		}
		catch (Exception e) {
			LOG.unableToDestroyUpdateTimestampsCache( region.getName(), e.getMessage() );
		}
	}

	/**
	 * Get the underlying cache region where data is stored..
	 *
	 * @return The underlying region.
	 */
	public TimestampsRegion getRegion() {
		return region;
	}

	@Override
	public String toString() {
		return "UpdateTimestampsCache";
	}

}
