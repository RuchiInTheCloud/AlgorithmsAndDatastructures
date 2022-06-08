package _6_treesandgraphs;

import _6_treesandgraphs.datastructures.BinaryTree;

//Check balanced: For every node in the tree, height of left and right subtree differs at most by 1
//Brute force: During computing the height check for imbalance
//int getHeight(treenode node)
//  node == null? return -1;
//  return Math.max(getHeight(node.left), getHeight(node.right)) + 1
//
//int checkHeight(treenode node)
//  node == null? return -1;
//  leftHeight = getHeight(node.left)
//  if (leftHeight == Int.minvalue)
//      return Int.minvalue
//  rightHeight = getHeight(node.right)
//  if (rightHeight == Int.minvalue)
//      return Int.minvalue
//  if (Math.abs(leftHeight - rightHeight)) > 1)
//      return Int.minvalue
//  else
//      return Math.max(getHeight(node.left), getHeight(node.right)) + 1
//
//  boolean checkBalanced(tree tree)
//      return checkHeight(tree.root) != Int.minValue;
//
//  Complexity: O(n) in time, O(H) in stack space, H is height of tree
public class Example4_2 {
    private static boolean checkBalanced(BinaryTree<Integer> binaryTree) {
        return checkHeight(binaryTree.root) != Integer.MIN_VALUE;
    }

    private static int checkHeight(BinaryTree.Node<Integer> node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = checkHeight(node.left);
        if (leftHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        int rightHeight = checkHeight(node.right);
        if (rightHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
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
