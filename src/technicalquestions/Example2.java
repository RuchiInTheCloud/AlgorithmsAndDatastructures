package technicalquestions;

import java.util.Arrays;

public class Example2 {
    public static void swapMinMax(int[] array) {
        int minIndex = getMinIndex(array);
        int maxIndex = getMaxIndex(array);
        swap(array, minIndex, maxIndex);
    }

    private static void swap(int[] array, int idx1, int idx2) {
        int temp = array[idx2];
        array[idx2] = array[idx1];
        array[idx1] = temp;
    }

    private static int getMaxIndex(int[] array) {
        int max = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[max]) {
                max = i;
            }
        }
        return max;
    }

    private static int getMinIndex(int[] array) {
        int min = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[min]) {
                min = i;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        swapMinMax(array);
        System.out.println(Arrays.toString(array));
    }
}
