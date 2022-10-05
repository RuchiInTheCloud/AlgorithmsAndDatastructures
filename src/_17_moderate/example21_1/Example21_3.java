package _17_moderate.example21_1;

import java.util.Arrays;
import java.util.HashSet;

/*
Given two arrays of integers: Find a pair of values that you can swap to give the two arrays the same sum
We are looking for values a, b such that
sumA - a + b = sumB - b + a
(a - b) = (sumA - sumB) / 2 = target
sumA - sumB must be even otherwise there is no result. Use Integer to save (sumA-sumB)/2, null to indicate error
 b = a - target, put all b in hashmap and search for b for a given a
 Complexity O(A + B)
 */
public class Example21_3 {
    static int[] findSwapValues(int[] array1, int[] array2) {
        Integer target = getTarget(array1, array2);
        if (target == null) {
            return null;
        }
        return findDifference(array1, array2, target);
    }

    static int[] findDifference(int[] array1, int[] array2, int target) {
        HashSet<Integer> contents2 = getContents(array2);
        for (int one : array1) {
            int two = one - target;
            if (contents2.contains(two)) {
                return new int[]{one, two};
            }
        }
        return null;
    }

    static HashSet<Integer> getContents(int[] array) {
        HashSet<Integer> set = new HashSet();
        for (int a : array) {
            set.add(a);
        }
        return set;
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
