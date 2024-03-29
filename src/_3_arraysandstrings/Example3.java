package _3_arraysandstrings;

// Input: String with space and length, String has spaces at the end to accommodate %20
// Output: String where space is replaced by %20
// Example:
// 1: "My dog chichi    ", 13 --> "My%20dog%20chichi"
// 2: "a   ", 2 --> "a%20"
// Brute force:
// First scan calculate extra characters needed
// Second scan in reverse order, shift non space character to new position
// Shift and replace space character by %20 to its new position
// Complexity: Time = O(n), Space = O(1)
// Optimize: BCR
// Walk Through: ---
// Implement: ---
// Test: ---
public class Example3 {
    public static void replaceSpaces(char[] str, int length) {
        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        int newLength = length + spaceCount * 2;
        for (int i = length - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';
                newLength -= 3;
            } else {
                str[newLength - 1] = str[i];
                newLength--;
            }
        }
    }

    public static void main(String[] args) {
        char[] str = "My dog chichi    ".toCharArray();
        replaceSpaces(str, 13);
        System.out.println(str);
    }
}
