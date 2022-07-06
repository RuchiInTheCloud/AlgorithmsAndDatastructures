package _12_sortingandsearching;

import java.util.Arrays;

//Peaks and Valleys: {5, 8, 6, 2, 3, 4, 6}, {8, 6} are peaks and {5, 2} are valleys
//Peak is a number that is surrounded by elements less or equal to it
//Valley is a number that is surrounded by elements greater or equal to it
public class Example11_2 {
    private static void sortValleyPeak(int[] array) {
    }

    public static void main(String[] args) {
        int[] array = {5, 8, 6, 2, 3, 4, 6};
        sortValleyPeak(array);
        System.out.println(Arrays.toString(array));
    }
}
