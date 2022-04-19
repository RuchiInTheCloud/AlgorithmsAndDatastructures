package arraysandstrings;

// Does a string have unique characters
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
