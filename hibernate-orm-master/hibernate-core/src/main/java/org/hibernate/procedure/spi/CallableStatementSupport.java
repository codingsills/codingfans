/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.procedure.spi;

import java.sql.CallableStatement;
import java.util.List;

import org.hibernate.engine.spi.SessionImplementor;

/**
 * @author Steve Ebersole
 */
public interface CallableStatementSupport {
	public String renderCallableStatement(
			String name,
			ParameterStrategy parameterStrategy,
			List<ParameterRegistrationImplementor<?>> parameterRegistrations,
			SessionImplementor session);

	public void registerParameters(
			String procedureName,
			CallableStatement statement,
			ParameterStrategy parameterStrategy,
			List<ParameterRegistrationImplementor<?>> parameterRegistrations,
			SessionImplementor session);
}
