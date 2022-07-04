package _12_sortingandsearching.example7_1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

//Given an input file with 1 billion non-negative integers
//Provide an algorithm to generate an integer not contained in the file
//Assume 10MB memory available for this task
//10^9 X 4 bytes = 4 GB
//
//There are total 2^32 or 4 billion distinct integers possible, 2^31 non-negative integers = 2 billion distinct numbers
//The file does not contains dups
//
//Consider blocks such as 0 - 999, 1000 - 1999, ...; in this example of size 1000
//Construct blocks and count the numbers in each block
//Maximum integers possible = 2^31
//Memory = 2^23 bytes = 2^21 ints
//
//arraysize = 2^31/ rangesize <= 2^21 ints
//rangesize >= 2^10
//
//rangesize <= 2^26 bits
//
//First pass count numbers in every block
//Find block with less numbers
//Create bit vector for the block via second pass
//Find the missing number by looking for zero in bit vector
public class Example7_2 {
    private static String fileName = "input.txt";

    private static int findOpenNumber() throws FileNotFoundException {
        int rangeSize = (1 << 20);
        int[] blocks = getCountPerBlock(rangeSize);
        int blockIndex = findBlockWithMissingValue(blocks, rangeSize);

        if (blockIndex == -1) {
            return -1;
        }
        byte[] bitVector = getBitVectorForRange(fileName, blockIndex, rangeSize);

        int offset = findZero(bitVector);
        if (offset == -1) {
            return -1;
        }
        return blockIndex * rangeSize + offset;
    }

    private static int[] getCountPerBlock(int rangeSize) throws FileNotFoundException {
        int arraySize = Integer.MAX_VALUE / rangeSize + 1;
        int[] blocks = new int[arraySize];
        Scanner in = new Scanner(new FileReader(fileName));
        while (in.hasNextInt()) {
            int n = in.nextInt();
            blocks[n / rangeSize]++;
        }
        return blocks;
    }

    private static int findBlockWithMissingValue(int[] blocks, int rangeSize) {
        for (int i = 0; i < blocks.length; i++) {
            if (blocks[i] < rangeSize) {
                return i;
            }
        }
        return -1;
    }

    private static byte[] getBitVectorForRange(String fileName, int blockIndex, int rangeSize)
            throws FileNotFoundException {
        int startRange = blockIndex * rangeSize;
        int endRange = startRange + rangeSize;
        byte[] bitVector = new byte[rangeSize / Byte.SIZE];
        Scanner in = new Scanner(new FileReader(fileName));
        while (in.hasNextInt()) {
            int n = in.nextInt();
            if (n >= startRange && n < endRange) {
                int offset = n - startRange;
                int mask = 1 << offset % Byte.SIZE;
                bitVector[offset / Byte.SIZE] |= mask;
            }
        }
        return bitVector;
    }

    private static int findZero(byte[] bitVector) {
        for (int i = 0; i < bitVector.length; i++) {
            if (bitVector[i] != ~0) {
                int bitIndex = findZero(bitVector[i]);
                return i * Byte.SIZE + bitIndex;
            }
        }
        return -1;
    }

    private static int findZero(byte b) {
        for (int i = 0; i < Byte.SIZE; i++) {
            int mask = (1 << i);
            if ((b & mask) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws FileNotFoundException {
        findOpenNumber();
    }
}
