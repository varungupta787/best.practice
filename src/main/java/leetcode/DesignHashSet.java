package leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*  705. Design HashSet */

/*  https://leetcode.com/problems/design-hashset/   */

/*
*
* Design a HashSet without using any built-in hash table libraries.

To be specific, your design should include these functions:

add(value): Insert a value into the HashSet.
contains(value) : Return whether the value exists in the HashSet or not.
remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.

Example:

MyHashSet hashSet = new MyHashSet();
hashSet.add(1);
hashSet.add(2);
hashSet.contains(1);    // returns true
hashSet.contains(3);    // returns false (not found)
hashSet.add(2);
hashSet.contains(2);    // returns true
hashSet.remove(2);
hashSet.contains(2);    // returns false (already removed)

Note:

All values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashSet library.
*
* */

public class DesignHashSet {
    /**
     * Initialize your data structure here.
     */
    private List<Integer>[] bucket;
    private int capacity;
    private double loadFactor;
    private int count;

    public DesignHashSet() {
        capacity = 1000;
        loadFactor = 0.75;
        count = 0;
        bucket = new LinkedList[capacity];
    }

    public void add(int key) {
        if (contains(key)) {
            return;
        }
        if (capacity * loadFactor == count) {
            capacity *= 2;
            count = 0;
            List<Integer>[] oldBucket = bucket;
            bucket = new LinkedList[capacity];
            for (int i = 0; i < oldBucket.length; i++) {
                List<Integer> list = oldBucket[i];
                if(list != null) {
                    for (int val : list) {
                        add(val);
                    }
                }
            }
        }

        int hash = getHash(key);
        if (bucket[hash] == null) {
            bucket[hash] = new LinkedList<>();
        }
        bucket[hash].add(key);
        count++;
    }

    public void remove(int key) {
        if (contains(key)) {
            int hash = getHash(key);
            List<Integer> list = bucket[hash];
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == key) {
                    it.remove();
                    count--;
                    break;
                }
            }
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int hash = getHash(key);
        if (bucket[hash] != null) {
            List<Integer> list = bucket[hash];
            for (int val : list) {
                if (val == key) {
                    return true;
                }
            }
        }
        return false;
    }

    private int getHash(int key) {
        return (key % capacity);
    }
}

/*
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
