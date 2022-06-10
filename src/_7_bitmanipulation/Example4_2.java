package _7_bitmanipulation;

//Given a "positive" integer, find the next largest and smallest numbers with same number of 1 bits
//00000111 --> No next smallest number with three 1 bits, largest number 00001011
//00001000 --> Next smallest number 00000100 with 1 bit, largest number 00010000
//00001010 --> Next smaller number 00001001 with 2 bit, largest number 00001100
//00001011 --> Next smaller number 00000111 with 2 bit, largest number 00001110
//00001100 --> Next smaller number 00001010 with 2 bit, largest number 00010001
//For largest number:
//Count the trailing zeros c0
//Count the next sequence of trailing ones c1
//Place a one at the index c0 + c1 ----> num = num + (2^c0 - 1) + 1
//Place c1 - 1 ones at the right most end --> num = num + 2^(c1 - 1) - 1
//num + 2^c0 + 2^(c1 - 1) - 1
//For smaller number:
//Count the trailing ones c1
//Count the next sequence of trailing zeros c0
//Clean the c1 trailing ones ---> num = num - (2^c1 - 1)
//Place a zero at the index c0 + c1 --> num = num - 1
//Place c1 + 1 ones right of c0 + c1 --> num = num - (2^(c0 - 1) - 1)
//num - 2^c1 - 2^(c0 - 1) + 1
public class Example4_2 {
    private static int getNext(int num) {
        int temp = num;
        int c0 = 0;
        int c1 = 0;
        while ((temp & 1) == 0 && temp > 0) {
            c0 += 1;
            temp = temp >> 1;
        }
        while ((temp & 1) == 1 && temp > 0) {
            c1 += 1;
            temp = temp >> 1;
        }
        if (c0 + c1 == 31) {
            return -1;
        }
        return (num + (1 << c0) + (1 << (c1 - 1)) - 1);
    }

    private static int getPrevious(int num) {
        int temp = num;
        int c0 = 0;
        int c1 = 0;
        while ((temp & 1) == 1 && temp > 0) {
            c1 += 1;
            temp = temp >> 1;
        }

        if (temp == 0) {
            return -1;
        }

        while ((temp & 1) == 0 && temp > 0) {
            c0 += 1;
            temp = temp >> 1;
        }

        if (c0 == 0) {
            return -1;
        }

        return num - ((1 << c1) - 1) - (1 << (c0 - 1)) + 1;
    }

    public static void main(String[] args) {
        System.out.println("Next number with the same number of bits " + getNext(7));
        System.out.println("Previous number with the same number of bits " + getPrevious(7));
    }
}
