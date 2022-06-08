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
public class Example4_2 {
    static boolean isPermutationOfPalindrome(String str) {
        int[] charCount = new int['z' - 'a' + 1];
        int oddCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int val = getCharacterNumber(c);
            if (val != -1) {
                charCount[val]++;

                if (charCount[val] % 2 == 1) {
                    oddCount++;
                } else {
                    oddCount--;
                }
            }
        }
        return oddCount <= 1;
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

    public static void main(String[] args) {
        System.out.println(
                "Is 'abb a' a permutation of a palindrome " + (isPermutationOfPalindrome("abb a") ? "yes" : "no"));
    }
}
