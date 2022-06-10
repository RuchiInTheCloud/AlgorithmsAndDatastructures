package _7_bitmanipulation;

//How many bit need to be flipped so that a and b are equal
//The bits that are unequal can be detected via ^ XOR
//Count the number of times n & (n - 1) can be done until the result is zero
public class Example6_2 {
    private static int getDifferentBitCount(int a, int b) {
        int x = a ^ b;
        int count = 0;
        for (int i = x; i != 0; i = i & (i - 1)) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getDifferentBitCount(8, 7));
    }
}
