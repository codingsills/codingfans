/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.test.cache.infinispan.functional;

/**
 * Functional entity read-only tests.
 *
 * @author Galder Zamarreño
 * @since 3.5
 */
public class BasicReadOnlyTestCase extends AbstractFunctionalTestCase {

   @Override
	public String getCacheConcurrencyStrategy() {
		return "read-only";
	}

}