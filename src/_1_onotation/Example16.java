package _1_onotation;

public class Example16 {
    // Memoization
    // O(n) runtime
    // O(n) space complexity
    // At every call we have already computed values of fib(n-1) and fib(n-2)
    static void allFib(int n) {
        int[] memo = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println(i + ": " + fib(i, memo));
        }
    }

    static int fib(int n, int[] memo) {
        if (n <= 0)
            return 0;
        else if (n == 1)
            return 1;
        else if (memo[n] > 0)
            return memo[n];
        else {
            memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
            return memo[n];
        }
    }

    public static void main(String[] args) {
        allFib(5);
    }
}
