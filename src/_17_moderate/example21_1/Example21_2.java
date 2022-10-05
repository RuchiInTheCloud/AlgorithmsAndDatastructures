package _17_moderate.example21_1;

import java.util.Arrays;

/*
Given two arrays of integers: Find a pair of values that you can swap to give the two arrays the same sum
We are looking for values a, b such that
sumA - a + b = sumB - b + a
(a - b) = (sumA - sumB) / 2
sumA - sumB must be even otherwise there is no result. Use Integer to save (sumA-sumB)/2, null to indicate error
Complexity O(AB)
 */
public class Example21_2 {
    static int[] findSwapValues(int[] array1, int[] array2) {
        Integer target = getTarget(array1, array2);
        if (target == null) {
            return null;
        }
        for (int one : array1) {
            for (int two : array2) {
                if (one - two == target) {
                    return new int[]{one, two};
                }
            }
        }
        return null;
    }

    static Integer getTarget(int[] array1, int[] array2) {
        int sum1 = Arrays.stream(array1).sum();
        int sum2 = Arrays.stream(array2).sum();
        if ((sum1 - sum2) % 2 != 0)
            return null;
        return (sum1 - sum2) / 2;
    }

    public static void main(String[] args) {
        int[] a = {4, 1, 2, 1, 1, 2};
        int[] b = {3, 6, 3, 3};
        int[] swapValues = findSwapValues(a, b);
        System.out.println(Arrays.toString(swapValues));
    }
}
