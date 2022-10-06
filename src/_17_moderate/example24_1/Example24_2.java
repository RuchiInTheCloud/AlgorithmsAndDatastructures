package _17_moderate.example24_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
Print all pairs of integers within an array which sum to a specified value
For every element x lookup sum - x in the hashset and if it exists and x has not been seen before,
add pair to result and add x to hashset
 */
public class Example24_2 {
    static ArrayList<int[]> printPairSums(int[] array, int sum) {
        ArrayList<int[]> result = new ArrayList<>();
        HashSet<Integer> elements = new HashSet<>();
        for (int x : array) {
            int complement = sum - x;
            if (elements.contains(complement) && !elements.contains(x)) {
                result.add(new int[]{x, complement});
            }
            elements.add(x);
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<int[]> result = printPairSums(new int[]{5, 6, 5}, 11);
        for (int[] value : result) {
            System.out.println(Arrays.toString(value));
        }
    }
}