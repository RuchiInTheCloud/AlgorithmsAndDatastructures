package _12_sortingandsearching.fundamentals;

import java.util.Arrays;

public class MergeSort {
    private static void mergeSort(int[] array) {
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(array, helper, low, mid);
            mergeSort(array, helper, mid + 1, high);
            merge(array, helper, low, mid, high);
        }
    }

    private static void merge(int[] array, int[] helper, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = mid + 1;
        int index = low;
        while (helperLeft <= mid && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[index] = helper[helperLeft];
                helperLeft += 1;
            } else {
                array[index] = helper[helperRight];
                helperRight += 1;
            }
            index += 1;
        }

        while (helperLeft <= mid) {
            array[index] = helper[helperLeft];
            helperLeft += 1;
            index += 1;
        }

    }

    public static void main(String[] args) {
        int[] array = {5, 4, 1, 9, 8, 2};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
