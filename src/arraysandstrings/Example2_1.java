package arraysandstrings;

import java.util.Arrays;

// Given two strings, check if one is a permutation of other
// Case sensitive? Yes. Whitespace significant? Yes.
// Assumption: ASCII character set
// Examples:
// 1: Strings of unequal length --> "abc", "abc d" : false
// 2: "abc", "ABC" : false
// 3: "abc", "abd" : false
// 4: "abc", "cba" : true
// Brute force: Sort both strings, then compare each character
// Brute force complexity: 1) Time -- O(nlogn + n) = O(nlogn) 2) Space O(1)
// Space complexity: O(n)
// Optimize: Bottleneck: sort
// Walk Through:
// Implement: ---
// Test: ---

public class Example2_1 {
    static String sort(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    static boolean isPermutationOfOther(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        return sort(str1).equals(sort(str2));
    }

    public static void main(String[] args) {
        System.out.println(
                "Is ABCDEF permutation of FDBECA?: " + (isPermutationOfOther("ABCDEF", "FDBECA") ? "yes" : "no"));
        System.out.println("Is ABBA permutation of abba?: " + (isPermutationOfOther("ABBA", "abba") ? "yes" : "no"));
    }
}
