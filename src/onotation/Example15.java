package onotation;

public class Example15 {
    //Time complexity of fibonnaci = O(2^N)
    //fib(1) = O(2^1), fib(2) = O(2^2), fib(3) = O(2^3),..
    // 2^1+2^2+2^3+2^4+.. = O(2^(N+1)) = O(2^N)
    static void allFib(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(i + ": " + fib(i));
        }
    }

    static int fib(int n) {
        if (n == 0)
            return 1;
        else if (n == 1)
            return 1;
        else
            return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        allFib(5);
    }
}
