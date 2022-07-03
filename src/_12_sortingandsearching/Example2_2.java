package _12_sortingandsearching;

import _3_arraysandstrings.datastructures.ArrayList;
import _3_arraysandstrings.datastructures.HashTable;
import _4_linkedlists.datastructures.LinkedList;

import java.util.Arrays;
import java.util.Iterator;

public class Example2_2 {
    private static String sortChars(String string) {
        char[] content = string.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    private static void sort(String[] strings) {
        HashTable<String, ArrayList<String>> mapList = new HashTable<>();
        for (String string : strings) {
            String sortedString = sortChars(string);
            ArrayList<String> list = mapList.get(sortedString);
            if (list == null) {
                list = new ArrayList<>();
                mapList.put(sortedString, list);
            }
            list.add(string);
        }

        int currentIndex = 0;
        for (String key : mapList.keySet()) {
            ArrayList<String> list = mapList.get(key);
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                strings[currentIndex] = iterator.next();
                currentIndex += 1;
            }
        }
    }

    public static void main(String[] args) {
        String[] strings = {"abba", "abcd", "baba", "burp"};
        sort(strings);
        System.out.println(Arrays.toString(strings));
    }
}
