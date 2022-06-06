package treesandgraphs;

import treesandgraphs.datastructures.BinaryTree;

//Check balanced: For every node in the tree, height of left and right subtree differs at most by 1
//Brute force
//
//boolean checkBalanced(treenode node)
//  if (node == null) return true;
//  leftheight = height(node.left)
//  rightheight = height(node.right)
//  if (Math.abs(leftheight - rightheight) <= 1)
//      return checkBalanced(node.left) && checkBalanced(node.right)
//  else return false
//
//int height(treenode node)
//  if (node == null) return -1;
//  Math.max(height(node.left), height(node.right)) + 1;
//
// Complexity: O(nlogn) in time, because every node is touched by checkBalanced. Every node is called by the nodes above
// it to compute their height, in the worst case this is O(log n) times
// Complexity: O(logn) in stack space
public class Example4_1 {
    private static boolean checkBalanced(BinaryTree<Integer> binaryTree) {
        return checkBalanced(binaryTree.root);
    }

    private static boolean checkBalanced(BinaryTree.Node<Integer> node) {
        if (node == null) {
            return true;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        if (Math.abs(leftHeight - rightHeight) <= 1) {
            return checkBalanced(node.left) && checkBalanced(node.right);
        } else {
            return false;
        }
    }

    private static int getHeight(BinaryTree.Node<Integer> node) {
        if (node == null) {
            return -1;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        BinaryTree.Node<Integer> node = new BinaryTree.Node<>(1);
        BinaryTree.Node<Integer> subNode = new BinaryTree.Node<>(2);
        node.left = subNode;
        subNode.parent = node;
        subNode = new BinaryTree.Node<>(3);
        node.right = subNode;
        subNode.parent = node;

        binaryTree.root = node;

        System.out.println("Is binary tree balanced? " + checkBalanced(binaryTree));

        node = subNode;
        subNode = new BinaryTree.Node<>(4);
        node.right = subNode;
        subNode.parent = node;

        node = subNode;
        subNode = new BinaryTree.Node<>(5);
        node.right = subNode;
        subNode.parent = node;

        System.out.println("Is binary tree balanced? " + checkBalanced(binaryTree));
    }
}
