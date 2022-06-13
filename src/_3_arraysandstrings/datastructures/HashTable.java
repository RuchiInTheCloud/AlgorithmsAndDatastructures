package _3_arraysandstrings.datastructures;

// Generic, so data type like integer or string does not matter
// From Java version 8, once the number of items in a hash bucket
// grows beyond a certain threshold, that bucket will switch from
// using a linked list of entries to a balanced tree. In the case
// of high hash collisions, this will improve worst-case performance
// from O(n) to O(log n)
// The initial capacity is simply the capacity at the time the hash
// table is created.
// The load factors a measure of how full the hash table is allowed
// to get before its capacity is automatically increased. The hash
// table is rehashed so that the hash table has approximately twice
// the number of buckets

public class HashTable<K, V> {
    private static final int INITIAL_CAPACITY = 4;
    private static final double LOAD_FACTOR = 0.7;

    Entry<K, V>[] buckets;
    private int size = 0;

    public HashTable() {
        this(INITIAL_CAPACITY);
    }

    public HashTable(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        buckets = new Entry[capacity];
    }

    public void put(K key, V value) {
        if (LOAD_FACTOR * buckets.length < size) {
            doubleBucketsArray();
        }

        int idx = computeHashCode(key);
        Entry<K, V> entry = new Entry<>(key, value);
        Entry<K, V> bucket = buckets[idx];

        if (bucket == null) {
            buckets[idx] = entry;
        } else {
            while (bucket.next != null) {
                if (bucket.key.equals(entry.key)) {
                    bucket.value = entry.value;
                    return;
                }
                bucket = bucket.next;
            }

            if (bucket.key.equals(entry.key)) {
                bucket.value = entry.value;
            } else {
                bucket.next = entry;
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

    public boolean containsKey(K key) {
        int idx = computeHashCode(key);
        Entry<K, V> bucket = buckets[idx];

        while (bucket != null) {
            if (bucket.key.equals(key)) {
                return true;
            }
            bucket = bucket.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return buckets.length;
    }

    private void doubleBucketsArray() {
        Entry<K, V>[] tempBuckets = buckets;
        buckets = new Entry[tempBuckets.length * 2];
        size = 0;
        for (Entry<K, V> bucket : tempBuckets) {
            while (bucket != null) {
                put(bucket.key, bucket.value);
                bucket = bucket.next;
            }
        }
    }

    private int computeHashCode(K key) {
        return (key.hashCode() & 0xfffffff) % buckets.length;
    }

    public V getOrElse(K key, V otherValue) {
        V value = get(key);
        return value == null ? otherValue : value;
    }

    public void remove(K key) {
        int idx = computeHashCode(key);
        Entry<K, V> bucket = buckets[idx];

        if (bucket == null) {
            return;
        }

        while (bucket.next != null) {
            if (bucket.next.key == key) {
                bucket.next = bucket.next.next;
                size--;
            } else {
                bucket = bucket.next;
            }
        }

        if (buckets[idx].key == key) {
            buckets[idx] = buckets[idx].next;
        }
    }

    public K getKey(V value) {
        for (int i = 0; i < buckets.length; i++) {
            Entry<K, V> bucket = buckets[i];
            while (bucket != null) {
                if (bucket.value == value) {
                    return bucket.key;
                }
                bucket = bucket.next;
            }
        }
        return null;
    }

    public static class Entry<A, B> {
        A key;
        B value;
        Entry<A, B> next;

        public Entry(A key, B value) {
            this.key = key;
            this.value = value;
        }
    }
}

