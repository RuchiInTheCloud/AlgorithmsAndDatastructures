package _10_recursionanddynamicprogramming;

import java.util.Arrays;

//A magic index in an array is an index i where A[i] = i
//Given a sorted array with distinct elements return the magic index
// 11 12 13 14 15 16 17 18 19 20  21
//  0  1  2  3  4  5  6  7  8  9  10
//
// -1  0  2  5  9 10 11 12 13 14  15
//  0  1  2  3  4  5  6  7  8  9  10
//
//
//-11 -2 -1  0  1  2  4  5  6  7  10
//  0  1  2  3  4  5  6  7  8  9  10
//
//Look at the mid of the array if A[mid] = mid return mid
//If A[mid] > mid, search in the left side
//If A[mid] < mid, search in the right side
//If start > end, nothing found
//
//O(log n) time and space complexity
public class Example3_1 {
    private static int magicIndex(int[] array) {
        return magicIndex(array, 0, array.length - 1);
    }

    private static int magicIndex(int[] array, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (array[mid] == mid) {
            return mid;
        } else if (array[mid] > mid) {
            return magicIndex(array, start, mid - 1);
        } else {
            return magicIndex(array, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] array = {-11, -2, -1, 0, 1, 2, 4, 5, 6, 7, 10};
        System.out.println(Arrays.toString(array) + " has magic index: " + magicIndex(array));
    }
}
