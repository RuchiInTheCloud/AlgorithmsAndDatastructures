package _10_recursionanddynamicprogramming;

import _3_arraysandstrings.datastructures.ArrayList;

//Permutations
//
//P(a0) = a0
//P(a0a1) = a1a0 + a0a1 = Insert a1 at the front of P(a0) + Insert a0 at the front of P(a1)
//P(a0a1a2) = a2a1a0 + a1a2a0 + a1a0a2 + a2a0a1 + a0a2a1 + a0a1a2 = Insert a0 at the front of P(a1a2)
// + Insert a1 at the front of P(a0a2) + Insert a2 at the front of P(a0a1)
//

public class Example7_2 {
    private static ArrayList<String> permutation(String string) {
        if (string == null) {
            return null;
        }
        ArrayList<String> permutations = new ArrayList<>();
        String permutation;
        if (string.length() == 0) {
            permutations.add("");
        } else {
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                String before = string.substring(0, i);
                String after = string.substring(i + 1);
                ArrayList<String> subPermutations = permutation(before + after);
                for (int j = 0; j < subPermutations.size(); j++) {
                    permutation = c + subPermutations.get(j);
                    permutations.add(permutation);
                }
            }
        }
        return permutations;
    }

    public static void main(String[] args) {
        ArrayList<String> permutations = permutation("abcd");
        System.out.println(permutations);
    }
}
