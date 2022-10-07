package _18_hard.example3_1;

import java.util.Arrays;

/*
Generate a set of m integers from an array of size n
Generate a set of m integers from array of size n - 1, decide randomly whether the n'th element should be part of subset
 */
public class Example3_2 {
    static int rand(int higher) {
        return (int) (Math.random() * (higher + 1));
    }

    static int[] pickMIteratively(int[] original, int m) {
        int[] subset = Arrays.copyOfRange(original, 0, m);
        for (int i = m; i < original.length; i++) {
            int k = rand(i);
            if (k < m) {
                subset[k] = original[i];
            }
        }
        return subset;
    }

    public static void main(String[] args) {
        int[] cards = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(pickMIteratively(cards, 3)));
    }
}
