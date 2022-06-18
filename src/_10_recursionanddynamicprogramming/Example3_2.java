package _10_recursionanddynamicprogramming;

import java.util.Arrays;

//A magic index in an array is an index i where A[i] = i
//Given a sorted array with non distinct elements return the magic index
// 11 12 13 14 15 16 17 18 19 20  21
//  0  1  2  3  4  5  6  7  8  9  10
//
// -1  0  2  5  9 10 10 10 10 10  10
//  0  1  2  3  4  5  6  7  8  9  10
//
//
//-11 -2  2  2  2  2  4  5  6  7  10
//  0  1  2  3  4  5  6  7  8  9  10
//
//If start > end return -1
//If A[mid] == mid return mid
//If A[mid] < mid, search in the left side in the interval (start, min(A[mid], mid - 1))
//If the above condition returns -1, search in the right side
//If A[mid] > mid, search in the right side in the interval (max(A[mid], mid + 1), end)
//
//O(log n) time and space complexity
public class Example3_2 {
    private static int magicIndex(int[] array) {
        return magicIndex(array, 0, array.length - 1);
    }

    private static int magicIndex(int[] array, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        int midValue = array[mid];
        if (midValue == mid) {
            return mid;
        }

        int left = magicIndex(array, start, Math.min(mid - 1, midValue));
        if (left >= 0) {
            return left;
        }

        return magicIndex(array, Math.max(mid + 1, midValue), end);
    }

    public static void main(String[] args) {
        int[] array = {-11, -2, 2, 2, 2, 2, 4, 5, 6, 7, 10};
        System.out.println(Arrays.toString(array) + " has magic index: " + magicIndex(array));
    }
}
