package _2_technicalquestions;

public class Example1 {
    // Time complexity = O(log_2 A + log_16 B)
    // Space complexity = O(1)
    static boolean compareBinToHex(String binary, String hex) {
        int n1 = convertFromBase(binary, 2);
        int n2 = convertFromBase(hex, 16);

        System.out.println(n1 + "  " + n2);
        if (n1 < 0 || n2 < 0) {
            return false;
        }
        return n1 == n2;
    }

    private static int convertFromBase(String number, int base) {
        if (base > 10 && base != 16) {
            return -1;
        }
        int value = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            int digit = digitToValue(number.charAt(i));
            if (digit < 0 || digit >= base) {
                return -1;
            }
            int exp = number.length() - 1 - i;
            value = value + digit * (int) Math.pow(base, exp);
        }
        return value;
    }

    private static int digitToValue(char digit) {
        switch (digit) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case 'A':
                return 10;
            case 'B':
                return 11;
            case 'C':
                return 12;
            case 'D':
                return 13;
            case 'E':
                return 14;
            case 'F':
                return 15;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        String hex = "FF";
        String binary = "11111111";
        System.out.println(compareBinToHex(binary, hex));
    }
}
