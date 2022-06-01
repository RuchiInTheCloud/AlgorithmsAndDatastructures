package arraysandstrings;

// Given two strings, check if one is a permutation of other
// Case sensitive? Yes. Whitespace significant? Yes.
// Assumption: ASCII character set
// Examples:
// 1: Strings of unequal length --> "abc", "abc d" : false
// 2: "abc", "ABC" : false
// 3: "abc", "abd" : false
// 4: "abc", "cba" : true
// Brute force: create an integer array of length 128
// If strings of unequal length return false
// Count character occurrences
// Deduct character occurrences, if counter negative return false
// return true
// Complexity: Time = O(n), Space = O(1)
// Optimize:
// Walk Through: ---
// Implement: ---
// Test: ---

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
