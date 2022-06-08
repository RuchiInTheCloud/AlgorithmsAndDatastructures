package _1_onotation;

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

    // 5 --> (4, 3) --> ((3, 2), (2, 1)) --> ((2, 1), (1, 0), (1, 0)) --> (1, 0)
    // Levels: 0 .. N-1
    public static void main(String[] args) {
        System.out.println(fib(5));
    }
}
