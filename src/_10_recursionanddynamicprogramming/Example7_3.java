package _10_recursionanddynamicprogramming;

import _3_arraysandstrings.datastructures.ArrayList;

//Permutations
//
//P(a0) = a0
//P(a0a1) = a1a0 + a0a1 = Insert a1 at the front of P(a0) + Insert a0 at the front of P(a1)
//P(a0a1a2) = a2a1a0 + a1a2a0 + a1a0a2 + a2a0a1 + a0a2a1 + a0a1a2 = Insert a0 at the front of P(a1a2)
// + Insert a1 at the front of P(a0a2) + Insert a2 at the front of P(a0a1)
//
public class Example7_3 {
    private static ArrayList<String> permutation(String string) {
        ArrayList<String> permutations = new ArrayList<>();
        permutation(string, permutations, "");
        return permutations;
    }

    private static void permutation(String remainder, ArrayList<String> permutations, String prefix) {
        if (remainder == null) {
            return;
        }

        if (remainder.length() == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < remainder.length(); i++) {
                String before = remainder.substring(0, i);
                String after = remainder.substring(i + 1);
                permutation(before + after, permutations, prefix + remainder.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<String> permutations = permutation("abcd");
        System.out.println(permutations);
    }
}
