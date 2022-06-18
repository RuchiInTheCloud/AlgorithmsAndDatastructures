package _10_recursionanddynamicprogramming;

import java.util.Arrays;

//A magic index in an array is an index i where A[i] = i
//Given a sorted array with non distinct elements return the magic index
public class Example3_2 {
    private static int magicIndex(int[] array) {
        return magicIndex(array, 0, array.length - 1);
    }

    public static void main(String[] args) {
        int[] array = {-11, -2, -1, 0, 1, 2, 4, 5, 6, 7, 10};
        System.out.println(Arrays.toString(array) + " has magic index: " + magicIndex(array));
    }
}
