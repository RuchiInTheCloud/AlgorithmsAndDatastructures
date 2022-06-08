package _1_onotation;

import java.util.Arrays;

public class Example24 {
    static int intersection(int[] a, int[] b) {
        int intersection = 0;
        Arrays.sort(b);
        for (int x : a) {
            if (Arrays.binarySearch(b, x) >= 0) {
                intersection++;
            }
        }
        return intersection;
    }

    // Time complexity: O(blogb + alogb)
    public static void main(String[] args) {
        int[] a = new int[]{5, 4, 3, 2, 1};
        int[] b = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        System.out.println(intersection(a, b));
    }
}
