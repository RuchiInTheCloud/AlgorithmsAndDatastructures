package _7_bitmanipulation;

//Given a real number between 0 and 1. Print its binary representation
//
// 0.72 > 0.5 --> 1
// 0.72 - 0.5 = 0.22 > 0.25 --> 0
// 0.22 > 0.125 --> 1
// 0.22 - 0.125 = 0.095 > 0.0625 --> 1
// 0.095 - 0.0625 = 0.0325 > 0.03125
public class Example2_2 {
    static String toBinary(double num) {
        if (!(num < 1 && num > 0)) {
            return "ERROR";
        }
        StringBuilder sb = new StringBuilder("0.");
        double frac = 0.5;
        while (num > 0) {
            if (sb.length() > 32) {
                return "ERROR: " + sb.toString();
            }
            if (num >= frac) {
                sb.append(1);
                num -= frac;
            } else {
                sb.append(0);
            }
            frac /= 2;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        double num = 0.72;
        System.out.println(toBinary(num));
    }
}
