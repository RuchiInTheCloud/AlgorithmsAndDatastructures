package _7_bitmanipulation.datastructures;

public class BitManipulation {
    static boolean getBit(int num, int i) {
        return (num & 1 << i) != 0;
    }

    static int setBit(int num, int i) {
        return (num | 1 << i);
    }

    static int clearBit(int num, int i) {
        int mask = ~(1 << i);
        return num & mask;
    }

    static int clearBitMSBThroughI(int num, int i) {
        int mask = (1 << i) - 1;
        return num & mask;
    }

    static int clearBitsIThroughZero(int num, int i) {
        int mask = ~(-1 >> (31 - i));
        return num & mask;
    }

    static int updateBit(int num, int i, boolean bitIs1) {
        int mask = ~(1 << i);
        int value = bitIs1 ? 1 : 0;
        return (num & mask) | value << i;
    }
}
