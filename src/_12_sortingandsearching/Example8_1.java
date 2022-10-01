package _12_sortingandsearching;

//Find duplicates: Array contains number between 1 and N (<=32000). The array may have duplicate entries.
//With 4KB memory given find the duplicates
public class Example8_1 {
    private static void checkDuplicates(int[] array) {
        BitSet bs = new BitSet(32000);
        for (int num : array) {
            int num0 = num - 1;
            if (bs.get(num0)) {
                System.out.println(num);
            } else {
                bs.set(num0);
            }
        }
    }

    private static class BitSet {
        int[] bitVector;

        public BitSet(int size) {
            bitVector = new int[(size >> 5) + 1];
        }

        public void set(int num) {
            int wordNumber = num >> 5;
            int bitNumber = num & 0x1F;
            bitVector[wordNumber] |= (1 << bitNumber);
        }

        public boolean get(int num) {
            int wordNumber = num >> 5;
            int bitNumber = num & 0x1F;
            return (bitVector[wordNumber] & (1 << bitNumber)) != 0;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 32000, 1, 32000};
        checkDuplicates(array);
    }
}
