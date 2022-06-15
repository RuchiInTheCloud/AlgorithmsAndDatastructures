package _9_objectorienteddesign.example12_1;

import _3_arraysandstrings.datastructures.ArrayList;

public class Hasher<K, V> {
    private static class LinkedListNode<K, V> {
        public LinkedListNode<K, V> next;
        public LinkedListNode<K, V> prev;
        public K key;
        public V value;

        public LinkedListNode(K k, V v) {
            key = k;
            value = v;
        }
        public String printForward() {
            String data = "(" + key + "," + value + ")";
            if (next != null) {
                return data + "->" + next.printForward();
            } else {
                return data;
            }
        }
    }
    private ArrayList<LinkedListNode<K, V>> arr;

    public Hasher(int capacity) {
        arr = new ArrayList<>(capacity);
    }

    public V put(K key, V value) {
        LinkedListNode<K, V> node = getNodeForKey(key);
        if (node != null) {
            V oldValue = node.value;
            node.value = value; // just update the value.
            return oldValue;
        }

        node = new LinkedListNode<>(key, value);
        int index = getIndexForKey(key);
        if (arr.get(index) != null) {
            node.next = arr.get(index);
            node.next.prev = node;
        }
        arr.set(index, node);
        return null;
    }

    public V remove(K key) {
        LinkedListNode<K, V> node = getNodeForKey(key);
        if (node == null) {
            return null;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            /* Removing head - update. */
            int hashKey = getIndexForKey(key);
            arr.set(hashKey, node.next);
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        return node.value;
    }

    public V get(K key) {
        if (key == null) return null;
        LinkedListNode<K, V> node = getNodeForKey(key);
        return node == null ? null : node.value;
    }

    private LinkedListNode<K, V> getNodeForKey(K key) {
        int index = getIndexForKey(key);
        LinkedListNode<K, V> current = arr.get(index);
        while (current != null) {
            if (current.key == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    private int getIndexForKey(K key) {
        return Math.abs(key.hashCode() % arr.capacity());
    }

    public void printTable() {
        for (int i = 0; i < arr.size(); i++) {
            String s = arr.get(i) == null ? "" : arr.get(i).printForward();
            System.out.println(i + ": " + s);
        }
    }
}
