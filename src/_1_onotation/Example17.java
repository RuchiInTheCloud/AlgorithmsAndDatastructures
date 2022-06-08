package _1_onotation;

public class Example17 {
    // Number of times n can be halved is log n
    // log (N) space and time complexity
    // 50 --> 25 --> 12 --> 6 --> 3 --> 1
    // 32 --> 16 --> 8 --> 4 --> 2 --> 1
    static int powersOf2(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1) {
            System.out.println(1);
            return 1;
        } else {
            int prev = powersOf2(n / 2);
            int curr = prev * 2;
            System.out.println(curr);
            return curr;
        }
    }

    public static void main(String[] args) {
        powersOf2(5);
    }
}
