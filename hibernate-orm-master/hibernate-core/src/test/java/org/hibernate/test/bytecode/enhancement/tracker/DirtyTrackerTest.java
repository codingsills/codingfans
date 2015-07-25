/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.test.bytecode.enhancement.tracker;

import org.hibernate.bytecode.enhance.internal.tracker.SimpleDirtyTracker;
import org.hibernate.bytecode.enhance.internal.tracker.SortedDirtyTracker;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author <a href="mailto:stale.pedersen@jboss.org">Ståle W. Pedersen</a>
 */
public class DirtyTrackerTest {

    @Test
    public void testSimpleTracker() {
        SimpleDirtyTracker tracker = new SimpleDirtyTracker();
        assertTrue(tracker.isEmpty());
        assertTrue(tracker.get().length == 0);

        tracker.add("foo");
        assertFalse(tracker.isEmpty());
        assertArrayEquals(tracker.get(), new String[]{"foo"});

        tracker.clear();
        assertTrue(tracker.isEmpty());
        assertTrue(tracker.get().length == 0);

        tracker.add("foo");
        tracker.add("bar");
        tracker.add("another.bar");
        tracker.add("foo");
        tracker.add("another.foo");
        tracker.add("another.bar");
        assertTrue(tracker.get().length == 4);

    }

    @Test
    public void testSortedTracker() {
        SortedDirtyTracker tracker = new SortedDirtyTracker();
        assertTrue(tracker.isEmpty());
        assertTrue(tracker.get().length == 0);

        tracker.add("foo");
        assertFalse(tracker.isEmpty());
        assertArrayEquals(tracker.get(), new String[]{"foo"});

        tracker.clear();
        assertTrue(tracker.isEmpty());
        assertTrue(tracker.get().length == 0);

        tracker.add("foo");
        tracker.add("bar");
        tracker.add("another.bar");
        tracker.add("foo");
        tracker.add("another.foo");
        tracker.add("another.bar");
        assertTrue(tracker.get().length == 4);

        // we the algorithm for this implementation relies on the fact that the array is kept sorted, so let's check it really is
        assertTrue(isSorted(tracker.get()));
    }

    private boolean isSorted(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

}


