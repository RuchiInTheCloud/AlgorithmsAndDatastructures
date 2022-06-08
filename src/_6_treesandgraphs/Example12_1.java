package _6_treesandgraphs;

import _6_treesandgraphs.datastructures.BinaryTree;

//Count the total number of paths with a certain sum
//Start of the path could be any node
//End of the path can be any child node reachable while travelling downwards from the chosen start
//
//Complexity: O(N log N)
//Reasoning: N + N - 1 + N - 3 + N - 7 + N - 15 + ... N - 2^logN - 1 = approx O(NlogN)
//Worst case: O(N^2)
//Reasoning: N + N - 1 + N - 2 + N - 3 + ... + N - N = N^2 - N(N+1)/2 = O(N^2)

public class Example12_1 {
    public static int countTotalPaths(BinaryTree.Node<Integer> node, int targetSum) {
        if (node == null) {
            return 0;
        }
        int totalPathsFromNode = 0;
        totalPathsFromNode += countPathsFromNode(node, targetSum, 0);
        totalPathsFromNode += countTotalPaths(node.left, targetSum);
        totalPathsFromNode += countTotalPaths(node.right, targetSum);
        return totalPathsFromNode;
    }

    private static int countPathsFromNode(BinaryTree.Node<Integer> node, int targetSum, int currentSum) {
        if (node == null) {
            return 0;
        }

        int totalPathFromNode = 0;
        currentSum += node.data;
        if (currentSum == targetSum) {
            totalPathFromNode++;
        }

        totalPathFromNode += countPathsFromNode(node.left, targetSum, currentSum);
        totalPathFromNode += countPathsFromNode(node.right, targetSum, currentSum);
        return totalPathFromNode;
    }

    public static void main(String[] args) {

    }
}