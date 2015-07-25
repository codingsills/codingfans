/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.engine.query.spi;

import org.hibernate.engine.query.spi.sql.NativeSQLQuerySpecification;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.service.Service;

/**
 * Service contract for dealing with native queries.
 *
 * @author Steve Ebersole
 * @author Gunnar Morling
 */
public interface NativeQueryInterpreter extends Service {
	/**
	 * Returns a meta-data object with information about the named and ordinal
	 * parameters contained in the given native query.
	 *
	 * @param nativeQuery the native query to analyze.
	 *
	 * @return a meta-data object describing the parameters of the given query.
	 *         Must not be {@code null}.
	 */
	ParameterMetadata getParameterMetadata(String nativeQuery);

	/**
	 * Creates a new query plan for the specified native query.
	 *
	 * @param specification Describes the query to create a plan for
	 * @param sessionFactory The current session factory
	 *
	 * @return A query plan for the specified native query.
	 */
	NativeSQLQueryPlan createQueryPlan(NativeSQLQuerySpecification specification, SessionFactoryImplementor sessionFactory);
}
