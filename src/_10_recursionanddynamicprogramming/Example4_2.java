package _10_recursionanddynamicprogramming;

import _3_arraysandstrings.datastructures.ArrayList;

//Write a method to return all subsets of a set
//
public class Example4_2 {
    public static void main(String[] args) {
        ArrayList<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(3);

        System.out.println("Subsets of set " + set);
        System.out.println(getSubsets(set, 0));
    }
}
