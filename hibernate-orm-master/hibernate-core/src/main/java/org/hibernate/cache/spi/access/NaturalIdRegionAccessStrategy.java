/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.cache.spi.access;

import org.hibernate.cache.CacheException;
import org.hibernate.cache.spi.NaturalIdRegion;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.persister.entity.EntityPersister;

/**
 * Contract for managing transactional and concurrent access to cached naturalId
 * data.  The expected call sequences related to various operations are:<ul>
 *     <li><b>INSERTS</b> : {@link #insert} -> {@link #afterInsert}</li>
 *     <li><b>UPDATES</b> : {@link #lockItem} -> {@link #remove} -> {@link #update} -> {@link #afterUpdate}</li>
 *     <li><b>DELETES</b> : {@link #lockItem} -> {@link #remove} -> {@link #unlockItem}</li>
 *     <li><b>LOADS</b> : {@link @putFromLoad}</li>
 * </ul>
 * Note the special case of <b>UPDATES</b> above.  Because the cache key itself has changed here we need to remove the
 * old entry as well as
 * <p/>
 * There is another usage pattern that is used to invalidate entries
 * after performing "bulk" HQL/SQL operations:
 * {@link #lockRegion} -> {@link #removeAll} -> {@link #unlockRegion}
 * <p/>
 * IMPORTANT : NaturalIds are not versioned so {@code null} will always be passed to the version parameter to:<ul>
 *     <li>{@link #putFromLoad(Object, Object, long, Object)}</li>
 *     <li>{@link #putFromLoad(Object, Object, long, Object, boolean)}</li>
 *     <li>{@link #lockItem(Object, Object)}</li>
 * </ul>
 *
 * @author Gavin King
 * @author Steve Ebersole
 * @author Eric Dalquist
 */
public interface NaturalIdRegionAccessStrategy extends RegionAccessStrategy {

	/**
	 * To create instances of NaturalIdCacheKey for this region, Hibernate will invoke this method
	 * exclusively so that generated implementations can generate optimised keys.
	 * @param naturalIdValues the sequence of values which unequivocally identifies a cached element on this region
	 * @param persister the persister of the element being cached
	 * @param session
	 * @return a key which can be used to identify this an element unequivocally on this same region
	 */
	public Object generateCacheKey(Object[] naturalIdValues, EntityPersister persister, SessionImplementor session);

	/**
	 * Performs reverse operation to {@link #generateCacheKey(Object[], EntityPersister, SessionImplementor)}, returning
	 * the original naturalIdValues.
	 * @param cacheKey key returned from {@link #generateCacheKey(Object[], EntityPersister, SessionImplementor)}
	 * @return the sequence of values which unequivocally identifies a cached element on this region
	 */
	public Object[] getNaturalIdValues(Object cacheKey);

	/**
	 * Get the wrapped naturalId cache region
	 *
	 * @return The underlying region
	 */
	public NaturalIdRegion getRegion();

	/**
	 * Called after an item has been inserted (before the transaction completes),
	 * instead of calling evict().
	 * This method is used by "synchronous" concurrency strategies.
	 *
	 * @param key The item key
	 * @param value The item
	 * @return Were the contents of the cache actual changed by this operation?
	 * @throws CacheException Propagated from underlying {@link org.hibernate.cache.spi.Region}
	 */
	public boolean insert(Object key, Object value) throws CacheException;

	/**
	 * Called after an item has been inserted (after the transaction completes),
	 * instead of calling release().
	 * This method is used by "asynchronous" concurrency strategies.
	 *
	 * @param key The item key
	 * @param value The item
	 * @return Were the contents of the cache actual changed by this operation?
	 * @throws CacheException Propagated from underlying {@link org.hibernate.cache.spi.Region}
	 */
	public boolean afterInsert(Object key, Object value) throws CacheException;

	/**
	 * Called after an item has been updated (before the transaction completes),
	 * instead of calling evict(). This method is used by "synchronous" concurrency
	 * strategies.
	 *
	 * @param key The item key
	 * @param value The item
	 * @return Were the contents of the cache actual changed by this operation?
	 * @throws CacheException Propagated from underlying {@link org.hibernate.cache.spi.Region}
	 */
	public boolean update(Object key, Object value) throws CacheException;

	/**
	 * Called after an item has been updated (after the transaction completes),
	 * instead of calling release().  This method is used by "asynchronous"
	 * concurrency strategies.
	 *
	 * @param key The item key
	 * @param value The item
	 * @param lock The lock previously obtained from {@link #lockItem}
	 * @return Were the contents of the cache actual changed by this operation?
	 * @throws CacheException Propogated from underlying {@link org.hibernate.cache.spi.Region}
	 */
	public boolean afterUpdate(Object key, Object value, SoftLock lock) throws CacheException;
}
