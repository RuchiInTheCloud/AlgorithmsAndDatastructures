package _6_treesandgraphs;

import _6_treesandgraphs.datastructures.BinaryTree;

//Count the total number of paths with a certain sum
//Start of the path could be any node
//End of the path can be any child node reachable while travelling downwards from the chosen start
//
//                      -1
//                 1           2
//             3
//       -1
//   -1
//1
// From root, there is a path with sum 2: -1 --> 1 --> 3 --> -1 &&& -1 --> 1 --> 3 --> -1 --> -1 --> 1
// In the left subtree of root there is a path with sum: 3 --> -1
// At root, we should could the paths found from root as well as the paths located from one of the nodes below
//
//Traverse every node in the tree in pre order
//At every node check whether there are path with a certain sum
//
//
//int countPathsWithSum(Node node, int targetSum)
//  if (node == null)
//      return 0
//  int totalPathFromNode = ???
//
//  int totalPathsFoundInLeftSubtree = countPathsWithSum(node.left, targetSum)
//  int totalPathFoundInRightSubtree = countPathsWithSum(node.right, targetSum)
//
//  return totalPathsFromNode + totalPathsFoundInLeftSubtree + totalPathFoundInRightSubtree
//
// From a node there can be multiple paths with a targetSum
//
//int countPathsWithSum(Node node, int targetSum, int currentSum)
//  if (node == null)
//  return 0
//
//  currentSum += node.value
//
//  int totalPathEndingInNode = 0;
//  if (targetSum == currentSum)
//      totalPathEndingInNode += 1;
//
//  int totalPathIncludingNode = 0;
//  totalPathIncludingNode + = countPathsWithSum(node.left, targetSum, currentSum)
//  totalPathIncludingNode + = countPathsWithSum(node.right, targetSum, currentSum)
//  return totalPathEndingInNode + totalPathIncludingNode;
//
//Complexity: O(N log N)
//Reasoning: N + N - 1 + N - 3 + N - 7 + N - 15 + ... N - 2^logN - 1 = approx O(NlogN)
//Worst case: O(N^2)
//Reasoning: N + N - 1 + N - 2 + N - 3 + ... + N - N = N^2 - N(N+1)/2 = O(N^2)

public class Example12_1 {
    public static int countTotalPaths(BinaryTree<Integer> tree, int targetSum) {
        return countTotalPaths(tree.root, targetSum);
    }

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
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        BinaryTree.Node<Integer> node = new BinaryTree.Node<>(-1);
        binaryTree.root = node;

        BinaryTree.Node<Integer> subNode = new BinaryTree.Node<>(1);
        node.left = subNode;
        subNode.parent = node;
        node = subNode;
        subNode = new BinaryTree.Node<>(3);
        node.left = subNode;
        subNode.parent = node;
        node = subNode;
        subNode = new BinaryTree.Node<>(-1);
        node.left = subNode;
        subNode.parent = node;
        node = subNode;
        subNode = new BinaryTree.Node<>(-1);
        node.left = subNode;
        subNode.parent = node;
        node = subNode;
        subNode = new BinaryTree.Node<>(1);
        node.left = subNode;
        subNode.parent = node;

        node = binaryTree.root;
        subNode = new BinaryTree.Node<>(1);
        node.right = subNode;
        subNode.parent = node;

        System.out.println("Total paths with sum 2 found are " + countTotalPaths(binaryTree, 2));
    }
}