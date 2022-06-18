package _10_recursionanddynamicprogramming;

import _3_arraysandstrings.datastructures.ArrayList;

//Write a method to return all subsets of a set
//The number of subsets are 2^n
public class Example4_2 {
    private static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        int subsetCount = 1 << set.size();
        for (int i = 0; i < subsetCount; i++) {
            ArrayList<Integer> subset = generateSubset(set, i);
            subsets.add(subset);
        }
        return subsets;
    }

    private static ArrayList<Integer> generateSubset(ArrayList<Integer> set, int num) {
        ArrayList<Integer> subset = new ArrayList<>();
        Integer element;
        int index = 0;
        for (int i = num; i != 0; i = i >> 1) {
            if ((i & 1) == 1) {
                element = set.get(index);
                subset.add(element);
            }
            index += 1;
        }
        return subset;
    }

    public static void main(String[] args) {
        ArrayList<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(3);

        System.out.println("Subsets of set " + set);
        System.out.println(getSubsets(set));
    }
}
