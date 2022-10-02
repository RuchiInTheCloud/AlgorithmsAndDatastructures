package _17_moderate;

/*
Find max value without using if else or comparison operator
 */
public class Example7_1 {
    static int flip(int bit) {
        return 1 ^ bit;
    }

    static int sign(int a) {
        return flip((a >> 31) & 0x01);
    }

    static int getMax(int a, int b) {
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);

        int use_sign_of_a = sa ^ sb;
        int use_sign_of_c = flip(use_sign_of_a);

        int k = use_sign_of_a * sa + use_sign_of_c * sc;
        int q = flip(k);
        return a * k + b * q;
    }

    public static void main(String[] args) {
        System.out.println("5, 2: " + getMax(5, 2));
        System.out.println("2^31 - 2, -15: " + getMax(Integer.MAX_VALUE - 2, -15));
    }
}
