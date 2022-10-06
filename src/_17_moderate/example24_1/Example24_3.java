package _17_moderate.example24_1;

import java.util.ArrayList;
import java.util.Arrays;

/*
Print all pairs of integers within a "sorted" array which sum to a specified value
first = 0
last = len - 1
if a[f] + a[l] < sum --> a[f] has no complement increment f
 */
public class Example24_3 {
    static ArrayList<int[]> printPairSums(int[] array, int sum) {
        ArrayList<int[]> result = new ArrayList<>();

        int l = 0;
        int r = array.length - 1;
        while (l < r) {
            if (array[l] + array[r] == sum) {
                result.add(new int[]{array[l], array[r]});
                l++;
                r--;
            } else {
                if (array[l] + array[r] < sum) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<int[]> result = printPairSums(new int[]{5, 5, 6, 6}, 11);
        for (int[] value : result) {
            System.out.println(Arrays.toString(value));
        }
    }
}
