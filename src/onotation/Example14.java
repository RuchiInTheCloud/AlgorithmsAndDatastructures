package onotation;

public class Example14 {
    // Two branches, N depth: O(2^N) time complexity, O(N) space complexity
    static int fib(int n) {
        if (n == 0)
            return 1;
        else if (n == 1)
            return 1;
        else
            return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fib(5));
    }
}
