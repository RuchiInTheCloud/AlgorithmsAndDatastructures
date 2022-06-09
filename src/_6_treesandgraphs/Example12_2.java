package _6_treesandgraphs;

import _3_arraysandstrings.datastructures.HashTable;
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
//
//                        1 -> 2 -> 3 ->  4 ->  5 -> 6
// Consider a given path -1 -> 1 -> 3 -> -1 -> -1 -> 1
// Runningsum along path -1 -> 0 -> 3 ->  2 ->  1 -> 2
// Running sum along a node - targetSum gives a runningSum, We can check at each node if it was detected earlier
// If targetSum is 2
// E.g. At node 4 = 2 - 2 = 0 (found at node "2"), 3 --> 4 path gives sum 2
// If the currentSum at node is targetSum, there exists a path from root node till current node
// E.g. At node 4 = 1 --> 4 is a path with sum 2
// E.g. At node 6 = 1 --> 6 is a path with sum 2
//
// Do a DFS (pre order search), at every node
// Compute current sum,
//    check whether current sum = target sum, if so pathcount += 1;
//    check whether current sum - target sum is present in hash table pathcount += occurence of (sum - target sum)
//    add current sum in hash table
//    pathcount += DFS (node.left, target sum, hash table)
//    pathcount += DFS (node.right, target sum, hash table)
//    remove current sum from hashtable
public class Example12_2 {
    private static int pathCountWithCurrentSum(BinaryTree<Integer> binaryTree, int targetSum) {
        return pathCountWithCurrentSum(binaryTree.root, targetSum, 0, new HashTable<>());
    }

    private static int pathCountWithCurrentSum(BinaryTree.Node<Integer> node, int targetSum, int runningSum,
            HashTable<Integer, Integer> runningSums) {
        if (node == null) {
            return 0;
        }
        int pathCount = 0;

        runningSum += node.data;
        if (runningSum == targetSum) {
            pathCount += 1;
        }

        int possibleSum = runningSum - targetSum;
        pathCount += runningSums.getOrElse(possibleSum, 0);

        changeHashTable(runningSums, runningSum, 1);

        pathCount += pathCountWithCurrentSum(node.left, targetSum, runningSum, runningSums);
        pathCount += pathCountWithCurrentSum(node.right, targetSum, runningSum, runningSums);

        changeHashTable(runningSums, runningSum, -1);

        return pathCount;
    }

    private static void changeHashTable(HashTable<Integer, Integer> hashTable, int key, int delta) {
        Integer value = hashTable.get(key);
        if (value == null) {
            hashTable.put(key, delta);
        } else {
            value = value + delta;
            if (value == 0) {
                hashTable.remove(key);
            } else {
                hashTable.put(key, value);
            }
        }
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

        System.out.println("Total paths with sum 2 found are " + pathCountWithCurrentSum(binaryTree, 2));
    }
}
