package _14_java;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

//Difference between treemap, hashmap, linkedhashmap
//
//Hashmap: Insertion and retrieval O(1)
// - When iterating through keys , ordering of keys is arbitrary
// - Implemented by array of linkedlists
//Treemap: Insertion and retrieval O(log n)
// - Keys are ordered if you want to iterate in sorted order you can. Key type must implement isComparable interface
// - Implemented by a Red black tree
// - E.g. Names to Person objects: Print people alphabetically by name OR Given name, output next 10 people
//LinkedHashmap: Insertion and retrieval O(1)
// - Keys are ordered by their insertion order
// - Implemented by doubly linked buckets
// - E.g. Cache, delete the oldest item
public class Example5_1 {
    private static void insertAndPrint(AbstractMap<Integer, String> map) {
        int[] array = {1, -1, 0};
        for (int x : array) {
            map.put(x, Integer.toString(x));
        }
        for (int k : map.keySet()) {
            System.out.print(k + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        AbstractMap<Integer, String> map;
        map = new HashMap<>();
        insertAndPrint(map);
        map = new TreeMap<>();
        insertAndPrint(map);
        map = new LinkedHashMap<>();
        insertAndPrint(map);
    }
}
