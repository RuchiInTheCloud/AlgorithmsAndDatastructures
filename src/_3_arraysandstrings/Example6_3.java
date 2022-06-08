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
// Complexity: O(n + k^2)
// Optimize: Use String Builder, Check in advance whether the compressionLength is smaller
// Complexity: O(n)
// Walk through
// Implement
// Test:
public class Example6_3 {
    public static String compress(String str) {
        int compressedLength = countCompression(str);
        if (compressedLength >= str.length()) {
            return str;
        }
        StringBuilder compressedStr = new StringBuilder();
        int consecutiveCharacterCount = 0;
        for (int i = 0; i < str.length(); i++) {
            consecutiveCharacterCount++;
            if ((i + 1) == str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedStr.append(str.charAt(i));
                compressedStr.append(consecutiveCharacterCount);
                consecutiveCharacterCount = 0;
            }
        }
        return compressedStr.toString();
    }
    public static int countCompression(String str) {
        int newLength = 0;
        int consecutiveCharacterCount = 0;
        for (int i = 0; i < str.length(); i++) {
            consecutiveCharacterCount++;
            if ((i + 1) == str.length() || str.charAt(i) != str.charAt(i + 1)) {
                newLength += (1 + String.valueOf(consecutiveCharacterCount).length());
                consecutiveCharacterCount = 0;
            }
        }
        return newLength;
    }
    public static void main(String[] args) {
        System.out.println("Compress aabcccccaaa: " + compress("aabcccccaaa"));
        System.out.println("Compress abb: " + compress("abb"));
    }
}
