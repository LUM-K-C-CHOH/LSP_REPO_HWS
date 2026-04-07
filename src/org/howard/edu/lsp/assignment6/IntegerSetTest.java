package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class IntegerSetTest {

    @Test
    public void testAdd() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(1);
        assertEquals(1, set.length());
    }

    @Test
    public void testRemove() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.remove(2);
        assertEquals(1, set.length());
    }

    @Test
    public void testEquals() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2);
        b.add(2); b.add(1);
        assertTrue(a.equals(b));
    }

    @Test
    public void testContains() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        assertFalse(set.contains(2));
    }

    @Test
    public void testUnion() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1);
        IntegerSet result = a.union(b);
        assertEquals(1, result.length());
    }

    @Test
    public void testIntersect() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1);
        b.add(2);
        assertTrue(a.intersect(b).isEmpty());
    }

    @Test
    public void testDiff() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1);
        b.add(1);
        assertTrue(a.diff(b).isEmpty());
    }

    @Test
    public void testComplement() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        b.add(2);
        assertEquals(1, a.complement(b).length());
    }

    @Test
    public void testIsEmpty() {
        IntegerSet set = new IntegerSet();
        assertTrue(set.isEmpty());
        set.add(1);
        assertFalse(set.isEmpty());
    }

    @Test
    public void testToString() {
        IntegerSet set = new IntegerSet();
        assertEquals("[]", set.toString());
    }

    @Test
    public void testLargest() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        assertEquals(5, set.largest());
        IntegerSet empty = new IntegerSet();
        assertThrows(RuntimeException.class, empty::largest);
    }

    @Test
    public void testSmallest() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        assertEquals(5, set.smallest());
        IntegerSet empty = new IntegerSet();
        assertThrows(RuntimeException.class, empty::smallest);
    }

    @Test
    public void testClear() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.clear();
        assertTrue(set.isEmpty());
    }

    @Test
    public void testLength() {
        IntegerSet set = new IntegerSet();
        assertEquals(0, set.length());
        set.add(1);
        assertEquals(1, set.length());
    }
}