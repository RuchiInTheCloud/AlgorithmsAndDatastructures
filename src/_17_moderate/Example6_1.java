package _17_moderate;

import java.util.Arrays;

/*
Find smallest non negative difference between pair of numbers
 */
public class Example6_1 {
    static int findSmallestDifference(int[] array1, int[] array2) {
        Arrays.sort(array1);
        Arrays.sort(array2);
        int a = 0;
        int b = 0;
        int difference = Integer.MAX_VALUE;
        while (a < array1.length && b < array2.length) {
            if (Math.abs(array1[a] - array2[b]) < difference) {
                difference = Math.abs(array1[a] - array2[b]);
            }
            if (array1[a] < array2[b]) {
                a++;
            } else {
                b++;
            }
        }
        return difference;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 11, 15};
        int[] array2 = {4, 12, 19, 23, 127, 235};
        System.out.println(findSmallestDifference(array1, array2));
    }
}
