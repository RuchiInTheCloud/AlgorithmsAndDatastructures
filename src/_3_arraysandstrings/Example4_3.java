package _3_arraysandstrings;

// Given a string check if it is a permutation of a palindrome
// --> ignore non-letter characters, case insensitive
// Example: IP: Tact Coa, OP: true "taco cat", "atco cta"
// Brute force: count characters, even count for all but maximum one
// Brute force complexity: Time = O(n), Space = O(1)
// Optimize: BCR
// Walk Through: The 26 characters can be saved in a 32 bit integer
// Loop through the characters
// For every letter character, map to integer, toggle the bit at this index to indicate even or odd count
// In the end check whether maximum one bit is up.
// Implement: ---
// Test: Check whether you provided return values
public class Example4_3 {
    public static boolean isPermutationOfPalindrome(String str) {
        int bitVector = createBitVector(str);
        return bitVector == 0 || checkExactlyOneBitSet(bitVector);
    }
    public static int createBitVector(String str) {
        int bitVector = 0;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int val = getCharNumber(c);
            if (val != -1) {
                int mask = 1 << val;
                if ((bitVector & mask) == 0) {
                    bitVector |= mask;
                } else {
                    bitVector &= ~mask;
                }
            }
        }
        return bitVector;
    }
    public static int getCharNumber(char c) {
        int a = 'a';
        int z = 'z';
        int A = 'A';
        int Z = 'Z';
        if (c >= a && c <= z) {
            return c - a;
        }
        if (c >= A && c <= Z) {
            return c - A;
        }
        return -1;
    }
    public static boolean checkExactlyOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }
    public static void main(String[] args) {
        System.out.println(
                "Is 'abb a' a permutation of a palindrome " + (isPermutationOfPalindrome("abb a") ? "yes" : "no"));
    }
}
