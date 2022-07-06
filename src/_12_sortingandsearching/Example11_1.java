package _12_sortingandsearching;

import java.util.Arrays;

//Peaks and Valleys: {5, 8, 6, 2, 3, 4, 6}, {8, 6} are peaks and {5, 2} are valleys
//Peak is a number that is surrounded by elements less or equal to it
//Valley is a number that is surrounded by elements greater or equal to it
//Sort the array into an alternating sequence of peaks and valleys
//Solution: Sort the array and then in every second medium of the low medium high sequence, switch medium with low
//Solution runs in O(nlogn)
public class Example11_1 {
    private static void sortValleyPeak(int[] array) {
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        for (int i = 1; i < array.length; i += 2) {
            swap(array, i - 1, i);
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
