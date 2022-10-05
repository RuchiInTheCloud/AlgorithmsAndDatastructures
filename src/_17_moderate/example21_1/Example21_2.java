package _17_moderate.example21_1;

import java.util.Arrays;

/*
Given two arrays of integers: Find a pair of values that you can swap to give the two arrays the same sum
We are looking for values a, b such that
sumA - a + b = sumB - b + a
(a - b) = (sumA - sumB) / 2
sumA - sumB must be even otherwise there is no result
Complexity O(AB)

 */
public class Example21_2 {
    static int[] findSwapValues(int[] array1, int[] array2) {
    }

    public static void main(String[] args) {
        int[] a = {4, 1, 2, 1, 1, 2};
        int[] b = {3, 6, 3, 3};
        int[] swapValues = findSwapValues(a, b);
        System.out.println(Arrays.toString(swapValues));
    }
}
