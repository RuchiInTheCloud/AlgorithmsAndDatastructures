package _17_moderate;

/*
Implement subtract, multiply, divide via addition
Negate complexity: O(log a)^2
Reducing a to a/2 takes O(log a) work
Reducing a/2 to a/4 takes O(log a/2) work
.. for log(a) rounds
 */
public class Example9_1 {
    static int negate(int a) {
        int neg = 0;
        int newSign = a < 0 ? 1 : -1;
        int delta = newSign;
        while (a != 0) {
            boolean differentSigns = (a + delta > 0) != (a > 0);
            if (a + delta != 0 && differentSigns) {
                delta = newSign;
            }
            a += delta;
            neg += delta;
            delta += delta;
        }
        return neg;
    }

    static int abs(int a) {
        return a < 0 ? negate(a) : a;
    }

    static int minus(int a, int b) {
        return a + negate(b);
    }

    static int multiply(int a, int b) {
        if (a < b) {
            return multiply(b, a);
        }
        int sum = 0;
        for (int i = abs(b); i > 0; i = minus(i, 1)) {
            sum += a;
        }
        if (b < 0) {
            sum = negate(sum);
        }
        return sum;
    }

    static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("ERROR");
        }
        int absa = abs(a);
        int absb = abs(b);

        int product = 0;
        int x = 0;
        while (product + absb <= absa) {
            product += absb;
            x += 1;
        }

        if ((a < 0 && b < 0) || (a > 0 && b > 0)) {
            return x;
        } else {
            return negate(x);
        }
    }

    public static void main(String[] args) {
        System.out.println(divide(10, 2));
    }
}
