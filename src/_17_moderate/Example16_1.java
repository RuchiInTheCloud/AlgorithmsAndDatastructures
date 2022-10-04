package _17_moderate;

/*
Given an array of integers, find indices m, n such that if you sorted elements from m through n the entire array would be sorted
E.g. 1, 2, 4, 7, 10, 8, 12, 5, 6, 16, 18, 19
Split array into left, middle, right segments
left: 1, 2, 4, 7, 10
middle: 8, 12
right: 5, 6, 16, 18, 19
Shrink left and right segments based on following criteria
- left segment should contain elements smaller than the smallest of middle and right segment
- right segment should contain elements larger than the largest element in the left and middle segment
 */
public class Example16_1 {
    static void findUnsortedSequence(int[] array) {
        int end_left = findEndOfLeftSubsequence(array);
        if (end_left >= array.length - 1)
            return;
        int start_right = findStartOfRightSubsequence(array);

        int max_index = end_left;
        int min_index = start_right;
        for (int i = end_left + 1; i < start_right; i++) {
            if (array[i] < array[min_index])
                min_index = i;
            if (array[i] > array[max_index])
                max_index = i;
        }

        int left_index = shrinkLeft(array, min_index, end_left);
        int right_index = shrinkRight(array, max_index, start_right);

        System.out.println(left_index + " " + right_index);
    }

    static int findEndOfLeftSubsequence(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return i - 1;
            }
        }
        return array.length - 1;
    }

    static int findStartOfRightSubsequence(int[] array) {
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] > array[i + 1]) {
                return i + 1;
            }
        }
        return 0;
    }

    static int shrinkLeft(int[] array, int min_index, int start_index) {
        int comp = array[min_index];
        for (int i = start_index; i >= 0; i--) {
            if (array[i] <= comp) {
                return i + 1;
            }
        }
        return 0;
    }

    static int shrinkRight(int[] array, int max_index, int start_index) {
        int comp = array[max_index];
        for (int i = start_index; i < array.length; i++) {
            if (array[i] >= comp) {
                return i - 1;
            }
        }
        return array.length - 1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 10, 8, 12, 5, 6, 16, 18, 19};
        findUnsortedSequence(array);
    }
}
