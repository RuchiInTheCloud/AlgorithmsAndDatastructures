package _10_recursionanddynamicprogramming;

import _3_arraysandstrings.datastructures.ArrayList;

//Write a method to return all subsets of a set
//
//P(0) = {}
//P(1) = {{}, {a0}}
//P(2) = {{}, {a0}, {a1}, {a0, a1}}
//P(3) = {{}, {a0}, {a1}, {a2}, {a0, a1}, {a0, a2}, {a1, a2}, {a0, a1, a2}}
//P(3) = P(2) + {P(2) + a2}
//
//The number of subsets are 2^n
//The number of elements in subsets are n2^(n - 1)
//A given element is present in half of 2^n subsets
//
public class Example4_1 {
    private static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        if (index == set.size()) {
            ArrayList<Integer> emptySet = new ArrayList<>();
            ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
            subsets.add(emptySet);
            return subsets;
        } else {
            ArrayList<ArrayList<Integer>> subsets = getSubsets(set, index + 1);

            Integer element = set.get(index);
            ArrayList<ArrayList<Integer>> newSubsets = new ArrayList<>();
            for (ArrayList subset : subsets) {
                ArrayList<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(element);
                newSubsets.add(newSubset);
            }
            subsets.addAll(newSubsets);
            return subsets;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(3);

        System.out.println("Subsets of set " + set);
        System.out.println(getSubsets(set, 0));
    }
}
