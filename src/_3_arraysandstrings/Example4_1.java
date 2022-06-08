package _3_arraysandstrings;

// Given a string check if it is a permutation of a palindrome
// --> ignore non-letter characters, case insensitive
// Example: IP: Tact Coa, OP: true "taco cat", "atco cta"
// Brute force: count characters, even count for all but maximum one
// Brute force complexity: Time = O(n), Space = O(1)
// Optimize: BCR
// Walk Through: ---
// Implement: ---
// Test: ---

public class Example4_1 {

    static boolean isPermutationOfPalindrome(String phrase) {
        int[] table = buildCharFrequency(phrase);
        return checkMaxOneOdd(table);
    }

    static int[] buildCharFrequency(String phrase) {
        int[] charCount = new int['z' - 'a' + 1];
        for (int i = 0; i < phrase.length(); i++) {
            char c = phrase.charAt(i);
            int val = getCharacterNumber(c);
            if (val != -1) {
                charCount[val]++;
            }
        }
        return charCount;
    }

    static int getCharacterNumber(char c) {
        int A = 'A';
        int Z = 'Z';
        int a = 'a';
        int z = 'z';
        int val = c;
        if (val >= a && val <= z) {
            return val - a;
        }
        if (val >= A && val <= Z) {
            return val - A;
        }
        return -1;
    }

    static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int i : table) {
            if (table[i] % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(
                "Is 'abb a' a permutation of a palindrome " + (isPermutationOfPalindrome("abb a") ? "yes" : "no"));
    }
}
