package _17_moderate.example24_1;

import java.util.ArrayList;
import java.util.Arrays;

/*
Print all pairs of integers within an array which sum to a specified value
Brute force
If there are duplicates in the array the same sum may be printed twice {5, 6, 5}
 */
public class Example24_1 {
    static ArrayList<int[]> printPairSums(int[] array, int sum) {
        ArrayList<int[]> result = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    result.add(new int[]{array[i], array[j]});
                }
            }
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
