package _3_arraysandstrings;

// Does a string have unique characters
// Assumption: ASCII charachter set 128
// Example: ABCDEF, ABBA, String of size > 128
// Brute force: In boolean array keep track whether the character was seen
// Brute force complexity: 1) Time O(N) 2) Space O(1)
// Optimize: BCR
// Walk Through:
//              if string size > 128, return Not unique
//              create boolean[128] array,
//              for every character in string
//                  if flag is true --> return Not unique
//                  toggle the flag at the character index
//              return Unique
// Implement: ---
// Test: ---
public class Example1_1 {
    static boolean isUniqueChars(String str) {
        if (str.length() > 128) {
            return false;
        }
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Is ABCDEF unique?: " + (isUniqueChars("ABCDEF") ? "yes" : "no"));
        System.out.println("Is ABBA unique?: " + (isUniqueChars("ABBA") ? "yes" : "no"));
    }
}
