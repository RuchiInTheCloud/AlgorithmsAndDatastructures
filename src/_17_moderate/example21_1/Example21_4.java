package _17_moderate.example21_1;

import java.util.Arrays;

/*
Given two arrays of integers: Find a pair of values that you can swap to give the two arrays the same sum
We are looking for values a, b such that
sumA - a + b = sumB - b + a
(a - b) = (sumA - sumB) / 2 = target
sumA - sumB must be even otherwise there is no result. Use Integer to save (sumA-sumB)/2, null to indicate error
 Complexity O(A + B), if sorted
 Complexity O(AlogA + BlogB) if unsorted
 */
public class Example21_4 {
    static int[] findSwapValues(int[] array1, int[] array2) {
        Integer target = getTarget(array1, array2);
        if (target == null) {
            return null;
        }
        return findDifference(array1, array2, target);
    }

    static int[] findDifference(int[] array1, int[] array2, int target) {
        int a = 0;
        int b = 0;
        while (a < array1.length && b < array2.length) {
            int difference = array1[a] - array2[b];
            if (difference == target) {
                return new int[]{array1[a], array2[b]};
            } else if (difference < target) {
                a++;
            } else {
                b++;
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
        int[] a = {1, 1, 1, 2, 2, 4};
        int[] b = {3, 3, 3, 6};
        int[] swapValues = findSwapValues(a, b);
        System.out.println(Arrays.toString(swapValues));
    }
}
