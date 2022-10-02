package _17_moderate.example11_1;

import java.util.HashSet;

/*
Given two kinds of planks one smaller and other longer
Determine the possible lengths of boards that can be created by putting k planks together
0 of type A, k of type B; 1 of type A, k - 1 of type B;...
If A and B are of same length there can only be one size of all the k planks combined
 */
public class Example11_3 {
    static HashSet<Integer> allLengths(int k, int shorter, int longer) {
        HashSet<Integer> lengths = new HashSet<>();
        for (int nShorter = 0; nShorter <= k; nShorter++) {
            int nLonger = k - nShorter;
            int length = nShorter * shorter + nLonger * longer;
            lengths.add(length);
        }
        return lengths;
    }

    public static void main(String[] args) {
        System.out.println(allLengths(5, 2, 3));
    }
}
