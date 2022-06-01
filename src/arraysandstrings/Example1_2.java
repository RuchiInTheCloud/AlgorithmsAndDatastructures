package arraysandstrings;

// Does a string have unique characters
// Assumption: Assume characters 'a' - 'z' are present in the string
// Example: abcdef, abba, String of size > 26
// Brute force: In an integer keep track whether the character was seen
// Brute force complexity: 1) Time O(N) 2) Space O(1)
// Optimize: BCR
// Walk Through:
//              if string size > 26, return Not unique
//              create integer = 0,
//              for every character in string
//                  if integer & toggled bit is true --> return Not unique
//                  toggle the bit at the character index via |
//              return Unique
// Implement: ---
// Test: ---
public class Example1_2 {
    static boolean isUniqueChars(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker = checker | (1 << val);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Is abcdef unique?: " + (isUniqueChars("abcdef") ? "yes" : "no"));
        System.out.println("Is abba unique?: " + (isUniqueChars("abba") ? "yes" : "no"));
    }
}
