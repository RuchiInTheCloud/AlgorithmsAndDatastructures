package _7_bitmanipulation;

//M, N: 32 bit integers
//Insert M into N, from position j until i, j >= i
//Assume j ... i have enough space for M
//Example: I/P: N = 10000000000 M = 10011, j = 6, i = 2
//         O/P: N = 10001001100,
//
//Brute force: Clear N at positions XXX000000XXX
//             Shift M by i positions  XXXXXX000
//             N & M
//
//Walk through
//Clear N at positions XXX000000XXX
//  (mask desired = 111110000011111)
//  mask = (-1 << (j + 1)) || ((1 << i) - 1 )
//  n = n & mask
//  m = m << i
//  n | m
public class Example1_1 {
    static int updateBits(int n, int m, int i, int j) {
        int mask = (-1 << (j + 1)) | ((1 << i) - 1);
        n = n & mask;
        m = m << i;
        return n | m;
    }

    public static void main(String[] args) {
        int n = 0b10000000000;
        int m = 0b10011;
        int j = 6;
        int i = 2;
        System.out.println(Integer.toBinaryString(updateBits(n, m, i, j)));
    }
}
