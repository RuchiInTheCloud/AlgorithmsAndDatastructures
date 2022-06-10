package _7_bitmanipulation;

//Given a "positive" integer, find the next largest and smallest numbers with same number of 1 bits
//00000111 --> No next smallest number with three 1 bits, largest number 00001011
//00001000 --> Next smallest number 00000100 with 1 bit, largest number 00010000
//00001010 --> Next smaller number 00001001 with 2 bit, largest number 00001100
//00001011 -->                                        , largest number 00001110
//00001100 -->                                                         00010001
//
// if i > j, Flip bit i from 1 to 0 and j from 0 to 1 --> creates a smaller number
// if i < j, Flip bit i from 1 to 0 and j from 0 to 1 --> creates a larger number
//
//For largest number:
//      Flip the rightmost non-trailing zero
//      Count the number of 0s and 1s to the right of the right most non-trailing zero
//      Clear the digits to the right of the non trailing zero
//      Add (c1 - 1) 1 bits to the right of the non trailing zero
//      If there is no non-trailing zero there is no larger number. E.g. 11110000
//
//      To determine rightmost non-trailing zero, count the sequence of zeros to the right and sequence of ones next to it
//
//For smaller number:
//      Flip the rightmost non-trailing 1 to zero, say this is position p
//     Count the number of trailing 1s to the right of p
//     Clear the digits to the right of p
//     Place c1 + 1 ones adjacent to p
public class Example4_1 {
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

        int mask = 1 << (c0 + c1);
        num = num | mask; // Add 1 at the position of non trailing zero
        mask = ~(mask - 1);
        num = num & mask; // Clear bits post the position of non trailing zero
        mask = (1 << (c1 - 1)) - 1;
        num = num | mask; // Add c1 - 1 bits to the right of the non trailing zero
        return num;
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

        num &= ((~0) << (c0 + c1 + 1)); //clear c0 + c1 + 1 bits
        num |= ((1 << (c1 + 1)) - 1) << (c0 - 1); //move c1 + 1 bits right by c0 - 1 bits

        return num;
    }

    public static void main(String[] args) {
        System.out.println("Next number with the same number of bits " + getNext(7));
        System.out.println("Previous number with the same number of bits " + getPrevious(7));
    }
}
