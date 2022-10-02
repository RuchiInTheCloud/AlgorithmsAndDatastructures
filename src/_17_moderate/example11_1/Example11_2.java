package _17_moderate.example11_1;

import java.util.HashSet;

/*
Given two kinds of planks one smaller and other longer
Determine the possible lengths of boards that can be created by putting k planks together
Use Memoization, picking plank 1 then plank 2 is same as picking plank 2 then plank 1
Use total planks length, plank count as key
There can be at most k planks of each type, table is (k x k) --> Complexity: O(k^2)
 */
public class Example11_2 {
    static HashSet<Integer> allLengths(int k, int shorter, int longer) {
        HashSet<Integer> lengths = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        getAllLengths(k, 0, shorter, longer, lengths, visited);
        return lengths;
    }

    static void getAllLengths(int k, int total, int shorter, int longer, HashSet<Integer> lengths,
            HashSet<String> visited) {
        if (k == 0) {
            lengths.add(total);
        } else {
            String key = k + " " + total;
            if (!visited.contains(key)) {
                getAllLengths(k - 1, total + shorter, shorter, longer, lengths, visited);
                getAllLengths(k - 1, total + longer, shorter, longer, lengths, visited);
                visited.add(key);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(allLengths(5, 2, 3));
    }
}
