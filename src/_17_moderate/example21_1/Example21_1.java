package _17_moderate.example21_1;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
Given two arrays of integers: Find a pair of values that you can swap to give the two arrays the same sum
Compute sumA and sumB, then for every pair of values check whether the newSums match
Complexity O(AB)
 */
public class Example21_1 {
    static int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = sum(array1);
        int sum2 = sum(array2);

        for (int one : array1) {
            for (int two : array2) {
                int newSum1 = sum1 - one + two;
                int newSum2 = sum2 - two + one;
                if (newSum1 == newSum2) {
                    return new int[]{one, two};
                }
            }
        }
        return null;
    }

    static int sum(int[] values) {
        return IntStream.of(values).sum();
    }

    public static void main(String[] args) {
        int[] a = {4, 1, 2, 1, 1, 2};
        int[] b = {3, 6, 3, 3};
        int[] swapValues = findSwapValues(a, b);
        System.out.println(Arrays.toString(swapValues));
    }
}
