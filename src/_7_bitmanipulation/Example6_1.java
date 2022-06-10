package _7_bitmanipulation;

//How many bit need to be flipped so that a and b are equal
//The bits that are unequal can be detected via ^ XOR
//Next count the 1s in the XOR result
public class Example6_1 {
    private static int getDifferentBitCount(int a, int b) {
        int x = a ^ b;
        int count = 0;
        for (int i = x; i != 0; i = i >>> 1) {
            count = count + (i & 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getDifferentBitCount(8, 7));
    }
}
