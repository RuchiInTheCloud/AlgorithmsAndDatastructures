package _10_recursionanddynamicprogramming;

import _3_arraysandstrings.datastructures.ArrayList;

//Permutations
//P(a0) = a0
//P(a0a1) = a1a0 + a0a1
//P(a0a1a2) = a2a1a0 + a1a2a0 + a1a0a2 + a2a0a1 + a0a2a1 + a0a1a2
//P(a0a1a2a3) = Insert a3 into every position of every string in P(a0a1a2)
//
//Time Complexity = O(n!), Space Complexity = O(n!) ????????? According to text book
//
//P(0) = 0
//P(1) = 1
//P(2) = 2 + 2 = 2 * 2
//P(3) = 3 + 3 + 3 + 3 + 3 + 3 = 3 * 6
//P(4) = 4 + 4 + 4 + 4 + 4 + 4 + 4 + 4 + 4 + 4 + 4 + 4 + 4 + 4 + 4 + 4 + 4 + 4 + 4 + 4 + 4 + 4 + 4 + 4 = 4 * 24
//P(n) = n * n!
//O(n) = P(0) + P(1) + P(2) +... P(n)
//     = ??
public class Example7_1 {
    private static ArrayList<String> permutation(String string) {
        if (string == null) {
            return null;
        }

        ArrayList<String> permutations = new ArrayList<>();
        if (string.length() == 0) {
            permutations.add("");
        } else {
            char first = string.charAt(0);
            String remainder = string.substring(1);
            ArrayList<String> words = permutation(remainder);
            for (String word : words) {
                for (int i = 0; i < word.length(); i++) {
                    String permutation = insertCharAt(word, i, first);
                    permutations.add(permutation);
                }
            }
        }
        return permutations;
    }

    private static String insertCharAt(String word, int index, char letter) {
        String first = word.substring(0, index);
        String second = word.substring(index);
        return first + letter + second;
    }

    public static void main(String[] args) {
        ArrayList<String> permutations = permutation("abcd");
        System.out.println(permutations);
    }
}
