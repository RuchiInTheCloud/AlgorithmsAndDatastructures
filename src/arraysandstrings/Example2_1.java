package arraysandstrings;

import java.util.Arrays;

// Given two strings, check if one is a permutation of other
// Case sensitive? Yes. Whitespace significant? Yes.
// Example 1: "abc", "abc d" : false
// Example 2: "abc", "ABC" : false
// Example 3: "abc", "abd" : false
// Example 3: "abc", "cba" : true
// Sort both strings, then compare each charachter: O(nlogn + n) = O(nlogn)
// Space complexity: O(n)
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
