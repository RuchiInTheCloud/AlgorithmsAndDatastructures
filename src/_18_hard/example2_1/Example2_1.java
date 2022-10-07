package _18_hard.example2_1;

import java.util.Arrays;

/*
Shuffle a deck of 52 cards with every permutation being equally likely
Based on base case of n - 1 elements, Generate a combination and swap the n-th element with an element in the array
 */
public class Example2_1 {
    static int rand(int higher) {
        return (int) (Math.random() * (higher + 1));
    }

    static int[] shuffleArrayRecursively(int[] cards, int i) {
        if (i == 0) {
            return cards;
        }

        shuffleArrayRecursively(cards, i - 1);
        int k = rand(i);

        int temp = cards[k];
        cards[k] = cards[i];
        cards[i] = temp;

        return cards;
    }

    public static void main(String[] args) {
        int[] cards = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(shuffleArrayRecursively(cards, 4)));
    }
}
