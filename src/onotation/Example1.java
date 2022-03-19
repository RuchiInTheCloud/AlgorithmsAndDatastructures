package onotation;

public class Example1 {
    // Stack space: O(n)
    // Time complexity: O(n)
    static int sum(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + sum(n - 1);
    }

    public static void main(String[] args) {
        System.out.printf("%2d", sum(15));
    }
}
