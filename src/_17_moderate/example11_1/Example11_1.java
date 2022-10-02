package _17_moderate.example11_1;

import java.util.HashSet;

/*
Given two kinds of planks one smaller and other longer
Determine the possible lengths of boards that can be created by putting k planks together
Complexity: O(2^k)
 */
public class Example11_1 {
    static HashSet<Integer> allLengths(int k, int shorter, int longer) {
        HashSet<Integer> lengths = new HashSet<>();
        getAllLengths(k, 0, shorter, longer, lengths);
        return lengths;
    }

    static void getAllLengths(int k, int total, int shorter, int longer, HashSet<Integer> lengths) {
        if (k == 0) {
            lengths.add(total);
        } else {
            getAllLengths(k - 1, total + shorter, shorter, longer, lengths);
            getAllLengths(k - 1, total + longer, shorter, longer, lengths);
        }
    }

    public static void main(String[] args) {
        System.out.println(allLengths(5, 2, 3));
    }
}
