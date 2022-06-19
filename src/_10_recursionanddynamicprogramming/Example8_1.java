package _10_recursionanddynamicprogramming;

import _3_arraysandstrings.datastructures.ArrayList;

//Write a method to compute permutations of a string whose characters are not unique
//Create unique permutations
public class Example8_1 {
    public static void main(String[] args) {
        ArrayList<String> permutations = permutation("abba");
        System.out.println(permutations);
    }
}
