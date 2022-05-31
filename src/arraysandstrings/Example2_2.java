package arraysandstrings;

// Given two strings, check if one is a permutation of other
// Case sensitive? Yes. Whitespace significant? Yes.

// ASCII charachter set
// Example 1: "abc", "abc d" : false
// Example 2: "abc", "ABC" : false
// Example 3: "abc", "abd" : false
// Example 4: "abc", "cba" : true

// Brute force: sort, compare: time complexity O(nlogn), space complexity O(n)

// Bottleneck: sort

// Pseudo code:
// Create 128 integer length counter
// Count character occurrences
// Deduct character occurrences, if counter negative return false
// return true
// Time complexity: O(n), Space complexity: O(1)

public class Example2_2 {
    static boolean isPermutationOfOther(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] letters = new int[128];
        int c;

        for (int i = 0; i < str1.length(); i++) {
            c = str1.charAt(i);
            letters[c]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            c = str2.charAt(i);
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(
                "Is ABCDEF permutation of FDBECA?: " + (isPermutationOfOther("ABCDEF", "FDBECA") ? "yes" : "no"));
        System.out.println("Is ABBA permutation of abba?: " + (isPermutationOfOther("ABBA", "abba") ? "yes" : "no"));
    }
}
