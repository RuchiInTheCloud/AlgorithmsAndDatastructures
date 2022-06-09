package _7_bitmanipulation;

//Given a real number between 0 and 1. Print its binary representation
// 0.72
// 0.72 * 2 = 1.44 --> 1
// 0.44 * 2 = 0.88 --> 0
// 0.88 * 2 = 1.76 --> 1
// 0.76 * 2 = 1.52 --> 1
// 0.52 * 2 = 1.04 --> 1
// 0.04 * 2 = 0.08 --> 0
// 0.08 * 2 = 0.16 --> 0
// 0.16 * 2 = 0.32 --> 0
// 0.32 * 2 = 0.64 --> 0
// 0.64 * 2 = 1.28 --> 1
// 0.28 * 2 = 0.56 --> 0
// 0.56 * 2 = 1.12 --> 1
// 0.12 * 2 = 0.24 --> 0
// 0.24 * 2 = 0.48 --> 0
// 0.48 * 2 = 0.96 --> 0
// 0.96 * 2 = 1.92 --> 1
// 0.92 * 2 = 1.84 --> 1

public class Example2_1 {
    private static String toBinary(double num) {
        if (num >= 1 || num <= 0 ) {
            return "ERROR";
        }

        StringBuilder sb = new StringBuilder("0.");
        while (num > 0) {
            if (sb.length() > 32) {
                return "ERROR: " + sb.toString();
            }
            num = num * 2;
            if (num >= 1) {
                sb.append(1);
                num = num - 1;
            } else {
                sb.append(0);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        double num = 0.72;
        System.out.println(toBinary(num));
    }
}
