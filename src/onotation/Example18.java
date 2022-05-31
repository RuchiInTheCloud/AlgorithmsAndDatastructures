package onotation;

public class Example18 {
    // O(b) time complexity
    static int product(int a, int b) {
        int sum = 0;
        for (int i = 0; i < b; i++) {
            sum += a;
        }
        return sum;
    }

    // time and space complexity O(b)
    static int power(int a, int b) {
        if (b < 0) {
            return 0;
        } else if (b == 0) {
            return 1;
        } else {
            return a * power(a, b - 1);
        }
    }

    // O(1)
    int mod(int a, int b) {
        if (b <= 0) {
            return -1;
        }
        int div = a / b;
        return a - div * b;
    }

    // time complexity O(lower bound a/b)
    // 5, 3
    // Init: 3 (0), Loop: 6 (1)
    // Init: 3 (1), Loop: 6 (2)

    // Case a = 1, b = 2 --> 0; b > a
    // Case a = 2, b = 2 --> 1; b = a; 2b > a
    // Case a = 3, b = 2 --> 1; b < a; 2b > a
    // Case a = 4, b = 2 --> 2; b < a; 2b = a; 3b > a
    int div(int a, int b) {
        int count = 0;
        int sum = b;

        while (sum <= a) {
            sum += b;
            count++;
        }

        return count;
    }
}
