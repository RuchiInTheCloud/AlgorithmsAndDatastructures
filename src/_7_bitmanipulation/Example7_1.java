package _7_bitmanipulation;

//Write a program to swap the odd and even bits
//32 bits - 31 ... 0 index
//OE....OE, Retain odd by & with 101010...1010. 8 As --> 0xaaaaaaaa
//OE....OE, Retain even by & with 010101...0101. 8 5s --> 0x55555555
//Logical right shift the odd elements <------
//Arithmetic left shift the the event elements <---------
//Or the two results
//
//Example: 00000111, 00001011
public class Example7_1 {
    private static int swapOddEvenBits(int num) {
        return ((num & 0xaaaaaaaa) >>> 1) | ((num & 0x55555555) << 1);
    }

    public static void main(String[] args) {
        System.out.println("After swaping the odd and even bits on 7 we get: " + swapOddEvenBits(7));
    }
}
