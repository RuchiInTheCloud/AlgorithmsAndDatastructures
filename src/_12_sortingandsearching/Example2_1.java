package _12_sortingandsearching;

import java.util.Arrays;
import java.util.Comparator;

//Group anagrams
public class Example2_1 {
    private static class AnagramComparator implements Comparator<String> {
        private String sortChars(String string) {
            char[] content = string.toCharArray();
            Arrays.sort(content);
            return new String(content);
        }

        @Override
        public int compare(String string1, String string2) {
            return sortChars(string1).compareTo(sortChars(string2));
        }
    }
    public static void main(String[] args) {
        String[] strings = {"abba","abcd", "baba"};
        Arrays.sort(strings, new AnagramComparator());
        System.out.println(Arrays.toString(strings));
    }
}
