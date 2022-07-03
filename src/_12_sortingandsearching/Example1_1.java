package _12_sortingandsearching;

import java.util.Arrays;

//Given two sorted arrays A and B. Merge B into A
//Move the largest element to the back
public class Example1_1 {
    private static void merge(int[] a, int[] b, int lastA, int lastB) {
        int indexA = lastA - 1;
        int indexB = lastB - 1;
        int indexMerged = lastA + lastB - 1;
        while (indexB >= 0) {
            if (indexA >= 0 && a[indexA] > b[indexB]) {
                a[indexMerged] = a[indexA];
                indexA--;
            } else {
                a[indexMerged] = b[indexB];
                indexB--;
            }
            indexMerged--;
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 4, 9, 0, 0, 0, 0};
        int[] B = {0, 3, 5, 7};
        merge(A, B, 4, 4);
        System.out.println(Arrays.toString(A));
    }
}
