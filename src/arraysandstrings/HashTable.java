package arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.*;

// Generic, so data type like integer or string does not matter
// From Java version 8, once the number of items in a hash bucket
// grows beyond a certain threshold, that bucket will switch from
// using a linked list of entries to a balanced tree. In the case
// of high hash collisions, this will improve worst-case performance
// from O(n) to O(log n)
// * the initial capacity is simply the capacity at the time the
// hash table is created.
// The load factors a measure of how full the hash table is allowed
// to get before its capacity is automatically increased. The hash
// table is rehashed so that the hash table has approximately twice
// the number of buckets

public class HashTable<K, V> {
    Entry<K, V>[] buckets;
    private static final int INITIAL_CAPACITY = 16;
    private int size = 0;

    public HashTable() {
        this(INITIAL_CAPACITY);
    }

    public HashTable(int capacity) {
        buckets = new Entry[capacity];
    }

    public void put(K key, V value) {
        int idx = computeHashCode(key);

        Entry<K, V> entry = new Entry<>(key, value);
        Entry<K, V> existing = buckets[idx];
        if (existing == null) {
            buckets[idx] = entry;
        } else {
            while (existing.next != null) {
                if (existing.key.equals(key)) {
                    existing.value = value;
                }
                existing = existing.next;
            }

            if (existing.key.equals(key)) {
                existing.value = value;
            } else {
                existing.next = entry;
            }
        }

        size++;
    }

    public V get(K key) {
        int idx = computeHashCode(key);
        Entry<K, V> bucket = buckets[idx];

        while (bucket != null) {
            if (bucket.key.equals(key)) {
                return bucket.value;
            }
            bucket = bucket.next;
        }

        return null;
    }

    private int computeHashCode(K key) {
        return (key.hashCode() & 0xfffffff) % buckets.length;
    }

    public int size() {
        return size;
    }

    public class Entry<A, B> {
        A key;
        B value;
        Entry<A, B> next;

        public Entry(A key, B value) {
            this.key = key;
            this.value = value;
        }
    }
}

