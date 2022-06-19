package _10_recursionanddynamicprogramming;

import _3_arraysandstrings.datastructures.ArrayList;

//Permutations
//
//P(a0) = a0
//P(a0a1) = a1a0 + a0a1
//P(a0a1a2) = a2a1a0 + a1a2a0 + a1a0a2 + a2a0a1 + a0a2a1 + a0a1a2
//P(a0a1a2a3) = Insert a3 into every position of every string in P(a0a1a2)
//
public class Example7_2 {
    public static void main(String[] args) {
        ArrayList<String> permutations = permutation("abcd");
        System.out.println(permutations);
    }
}
