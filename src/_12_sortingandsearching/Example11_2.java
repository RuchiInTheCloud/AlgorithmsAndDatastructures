package _12_sortingandsearching;

import java.util.Arrays;

//Peaks and Valleys: {5, 8, 6, 2, 3, 4, 6}, {8, 6} are peaks and {5, 2} are valleys
//Peak is a number that is surrounded by elements less or equal to it
//Valley is a number that is surrounded by elements greater or equal to it
//
//Swap the middle element with the largest adjacent number
//0 1 2 --> 0 2 1
//0 2 1 --> peak
//1 0 2 --> 1 2 0
//1 2 0 --> peak
//2 1 0 --> 1 2 0
//2 0 1 --> 0 2 1
//
//If we swap the left element with smaller middle element, the valley in the left remains
public class Example11_2 {
    private static void sortValleyPeak(int[] array) {
        for (int i = 1; i < array.length; i += 2) {
            int biggestIndex = maxIndex(array, i - 1, i, i + 1);
            if (biggestIndex != i) {
                swap(array, i, biggestIndex);
            }
        }
    }

    private static int maxIndex(int[] array, int i0, int i1, int i2) {
        int a0 = (i0 >= 0 && i0 < array.length) ? array[i0] : Integer.MIN_VALUE;
        int a1 = (i1 >= 0 && i1 < array.length) ? array[i1] : Integer.MIN_VALUE;
        int a2 = (i2 >= 0 && i2 < array.length) ? array[i2] : Integer.MIN_VALUE;

        int max = Math.max(a0, Math.max(a1, a2));
        if (a0 == max) {
            return i0;
        } else if (a1 == max) {
            return i1;
        } else {
            return i2;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {5, 8, 6, 2, 3, 4, 6};
        sortValleyPeak(array);
        System.out.println(Arrays.toString(array));
    }
}
