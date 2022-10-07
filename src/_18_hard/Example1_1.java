package _18_hard;

/*
Add without plus
 */
public class Example1_1 {
    static int add(int a, int b) {
        while (b != 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(add(759, 674));
    }
}
