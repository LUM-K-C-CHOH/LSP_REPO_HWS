
/**
 * Author: Lum Kelly Chelsie Choh
 */
package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;

/**
 * IntegerSet represents a mathematical set of integers.
 * It does not allow duplicate values and supports common set operations.
 */
public class IntegerSet {

    private ArrayList<Integer> set = new ArrayList<>();

    /**
     * Clears all elements from the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in the set.
     * @return size of the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Checks if two sets are equal (contain the same elements regardless of order).
     * @param b another IntegerSet
     * @return true if both sets are equal, false otherwise
     */
    public boolean equals(IntegerSet b) {
        ArrayList<Integer> aList = new ArrayList<>(this.set);
        ArrayList<Integer> bList = new ArrayList<>(b.set);

        Collections.sort(aList);
        Collections.sort(bList);

        return aList.equals(bList);
    }

    /**
     * Checks if the set contains a given value.
     * @param value integer to check
     * @return true if present, false otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest value in the set.
     * @return largest integer
     * @throws RuntimeException if the set is empty
     */
    public int largest() {
        if (set.isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.max(set);
    }

    /**
     * Returns the smallest value in the set.
     * @return smallest integer
     * @throws RuntimeException if the set is empty
     */
    public int smallest() {
        if (set.isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.min(set);
    }

    /**
     * Adds an item to the set if it is not already present.
     * @param item integer to add
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set if it exists.
     * @param item integer to remove
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Returns a new set that is the union of this set and another set.
     * @param intSetb another IntegerSet
     * @return new IntegerSet containing all unique elements from both sets
     */
    public IntegerSet union(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        result.set.addAll(this.set);

        for (int val : intSetb.set) {
            if (!result.set.contains(val)) {
                result.set.add(val);
            }
        }
        return result;
    }

    /**
     * Returns a new set containing elements common to both sets.
     * @param intSetb another IntegerSet
     * @return new IntegerSet with common elements
     */
    public IntegerSet intersect(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int val : this.set) {
            if (intSetb.set.contains(val)) {
                result.add(val);
            }
        }
        return result;
    }

    /**
     * Returns a new set containing elements in this set but not in another set.
     * @param intSetb another IntegerSet
     * @return new IntegerSet representing the difference
     */
    public IntegerSet diff(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int val : this.set) {
            if (!intSetb.set.contains(val)) {
                result.add(val);
            }
        }
        return result;
    }

    /**
     * Returns a new set containing elements in another set but not in this set.
     * @param intSetb another IntegerSet
     * @return new IntegerSet representing the complement
     */
    public IntegerSet complement(IntegerSet intSetb) {
        return intSetb.diff(this);
    }

    /**
     * Checks if the set is empty.
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set in ascending order.
     * Format: [1, 2, 3]
     * @return formatted string of set elements
     */
    @Override
    public String toString() {
        ArrayList<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);
        return sorted.toString();
    }
}