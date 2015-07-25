/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.envers.internal.entities.mapper.id;

import org.hibernate.Query;
import org.hibernate.internal.util.compare.EqualsHelper;

/**
 * @author Adam Warski (adam at warski dot org)
 */
public class QueryParameterData {
	private String flatEntityPropertyName;
	private Object value;

	public QueryParameterData(String flatEntityPropertyName, Object value) {
		this.flatEntityPropertyName = flatEntityPropertyName;
		this.value = value;
	}

	public String getProperty(String prefix) {
		if ( prefix != null ) {
			return prefix + "." + flatEntityPropertyName;
		}
		else {
			return flatEntityPropertyName;
		}
	}

	public Object getValue() {
		return value;
	}

	public void setParameterValue(Query query) {
		query.setParameter( flatEntityPropertyName, value );
	}

	public String getQueryParameterName() {
		return flatEntityPropertyName;
	}

	@Override
	public boolean equals(Object o) {
		if ( this == o ) {
			return true;
		}
		if ( !(o instanceof QueryParameterData) ) {
			return false;
		}

		final QueryParameterData that = (QueryParameterData) o;
		return EqualsHelper.equals( flatEntityPropertyName, that.flatEntityPropertyName );
	}

	@Override
	public int hashCode() {
		return (flatEntityPropertyName != null ? flatEntityPropertyName.hashCode() : 0);
	}
}
