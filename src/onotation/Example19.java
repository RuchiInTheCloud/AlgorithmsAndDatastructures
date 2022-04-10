package onotation;

public class Example19 {
    // Java does a round down during integer division
    // n = 50 --> -1
    // n = 25 --> 5

    // n = 100 --> (1, 100) = 50 -> (1, 49) = 25 --> (1, 24) = 12 --> (1, 11) = 6 --> (7, 11) = 9 --> (10, 11) = 10
    // n = 200 --> (1, 200) = 100 -> (1, 99) = 50 --> (1, 49) = 25 --> (1, 24) = 12 --> (13, 24) = 18 --> (13, 17) = 15
    //         --> (13, 14) = 13 -> (14, 14) = 14 --> (15, 14)

    static int sqrt(int n) {
        System.out.println(1 + " " + n);
        return sqrt_helper(n, 1, n);
    }

    static int sqrt_helper(int n, int min, int max) {
        if (max < min)
            return -1;

        int guess = (min + max) / 2;
        if (guess * guess == n) {
            return guess;
        } else if (guess * guess < n) {
            System.out.println((guess + 1) + " " + max);

            return sqrt_helper(n, guess + 1, max);
        } else {
            System.out.println(min + " " + (guess - 1));

            return sqrt_helper(n, min, guess - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(sqrt(200));
    }
}
