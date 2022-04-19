package arraysandstrings;

// Assume characters 'a' - 'z' are present in the string
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
