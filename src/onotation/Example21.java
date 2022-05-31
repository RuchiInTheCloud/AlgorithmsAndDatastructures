package onotation;

import java.util.Arrays;

public class Example21 {
    //Time complexity O(n^2)
    //Space complexity O(n^2)

    static int[] copyArray(int[] array) {
        int[] copy = new int[0];
        for (int value : array) {
            copy = appendToNew(copy, value);
        }
        return copy;
    }

    static int[] appendToNew(int[] array, int value) {
        int[] bigger = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            bigger[i] = array[i];
        }
        bigger[array.length] = value;
        return bigger;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(copyArray(array)));
    }
}
