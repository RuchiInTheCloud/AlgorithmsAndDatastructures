package onotation;

import java.util.Arrays;

public class Example24 {
    int intersection(int[] a, int[] b) {
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

    }
}
