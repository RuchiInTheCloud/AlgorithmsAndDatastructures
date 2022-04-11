package onotation;

public class Example23 {
    //Time complexity (kc^k)
    static void printSortedStrings(int remaining) {
        printSortedStrings(remaining, "");
    }

    static void printSortedStrings(int remaining, String prefix) {
        if (remaining == 0) {
            if (isInOrder(prefix)) {
                System.out.println(prefix);
            }
        } else {
            for (int i = 0; i < 26; i++) {
                char c = (char) ('a' + i);
                printSortedStrings(remaining - 1, prefix + c);
            }
        }
    }

    private static boolean isInOrder(String prefix) {
        for (int i = 0; i < prefix.length() - 1; i++) {
            if (prefix.charAt(i) > prefix.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        printSortedStrings(2);
    }
}
