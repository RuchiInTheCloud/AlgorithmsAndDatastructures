package onotation;

public class Example11 {
    // Time complexity : O(sqrt n)

    /*static boolean isPrime(int n) {
        for (int x = 2; x * x <= n; x++) {
            if (n % x == 0) {
                return false;
            }
        }
        return true;
    }*/

    static boolean isPrime(int n) {
        for (int x = 2; x <= Math.sqrt(n); x++) {
            if (n % x == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(5));
    }
}
