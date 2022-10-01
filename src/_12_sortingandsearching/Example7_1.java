package _12_sortingandsearching;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

//Given an input file with 4 billion non-negative integers
//Provide an algorithm to generate an integer not contained in the file
//Assume 1GB memory available for this task
//4 x 10^9 X 4 bytes = 16 GB
//
//There are total 2^32 or 4 billion distinct integers possible, 2^31 non-negative integers = 2 billion distinct numbers
//Therefore the file contains dups
//
//1GB memory available or 8 billion bits. We can map all integers to a distinct bit.
//- Create bit vector with 2^31 bits (byte array = 8 bits array)
//- Initialize bit vector with zeros
//- Scan all numbers and call BV.set(num, 1)
//- Scan BV from the zeroth index.
//- Return first index with value zero.
public class Example7_1 {
    private static long numberOfInts = ((long) Integer.MAX_VALUE) + 1;
    private static byte[] bitField = new byte[(int) numberOfInts / 8];
    private static String fileName = "input.txt";

    private static void findOpenNumber() throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader(fileName));
        while (in.hasNextInt()) {
            int n = in.nextInt();
            bitField[n / 8] |= (1 << n % 8);
        }
        for (int i = 0; i < bitField.length; i++) {
            for (int j = 0; j < 8; j++) {
                if ((bitField[i] & (1 << j)) == 0) {
                    System.out.println(i * 8 + j);
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        findOpenNumber();
    }
}
