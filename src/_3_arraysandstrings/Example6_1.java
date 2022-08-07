package _3_arraysandstrings;

// Compression: aabcccccaaa --> a2b1c5a3
// If the compressed string is not smaller, return the original string
// String has only upper and lower case letters
// Example:
// 1. aabcccccaaa --> a2b1c5a3
// 2. abb --> abb
// Bruteforce:
// Traverse through the string, keep track of the consecutive character sequence with a counter,
// If there is a break in the consecutive character sequence, "change" the "compressed string" with the repeating character and its count
// Complexity: O(n + k^2), k is the number of character sequences
// Optimize: Use String builder
// Walk through
// Implement
// Test: Use ? operator
public class Example6_1 {
    public static String compress(String str) {
        String compressedStr = "";
        int consecutiveCharacterCount = 0;
        for (int i = 0; i < str.length(); i++) {
            consecutiveCharacterCount++;
            if ((i + 1) == str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedStr = compressedStr + (str.charAt(i) + consecutiveCharacterCount);
                consecutiveCharacterCount = 0;
            }
        }
        return (compressedStr.length() < str.length()) ? compressedStr : str;
    }

    public static void main(String[] args) {
        System.out.println("Compress aabcccccaaa: " + compress("aabcccccaaa"));
        System.out.println("Compress abb: " + compress("abb"));
    }
}
