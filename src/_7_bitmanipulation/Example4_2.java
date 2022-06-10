package _7_bitmanipulation;

//Given a "positive" integer, find the next largest and smallest numbers with same number of 1 bits
//00000111 --> No next smallest number with three 1 bits, largest number 00001011
//00001000 --> Next smallest number 00000100 with 1 bit, largest number 00010000
//00001010 --> Next smaller number 00001001 with 2 bit, largest number 00001100
//00001011 --> Next smaller number 00000111 with 2 bit, largest number 00001110
//00001100 --> Next smaller number 00001010 with 2 bit, largest number 00010001
//For largest number:
//
//For smaller number:
//
public class Example4_2 {
    private static String getNext(int num) {
    }

    private static String getPrevious(int num) {
    }

    public static void main(String[] args) {
        System.out.println("Next number with the same number of bits " + getNext(7));
        System.out.println("Previous number with the same number of bits " + getPrevious(7));
    }
}
