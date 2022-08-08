package _6_treesandgraphs;

import _6_treesandgraphs.datastructures.BinaryTree;

//Check if binary tree is a binary search tree
//left subtree <= n < right subtree
//execute pre-order traversal
//Check if max != null --> node.value <= max? if not return false;
//Check if min != null --> node.value > min? if not return false;
//Check the same for the left and right subtree, if either result is false return false
//Time complexity: O(n), space complexity O(log n)
public class Example5_3 {
    private static boolean checkBST(BinaryTree<Integer> binaryTree) {
        return checkBST(binaryTree.root, null, null);
    }

    private static boolean checkBST(BinaryTree.Node<Integer> node, Integer max, Integer min) {
        if (node == null) {
            return true;
        }

        if ((max != null && node.data > max) || (min != null && node.data <= min)) {
            return false;
        }

        if (!(checkBST(node.left, node.data, null) || !checkBST(node.right, null, min))) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        BinaryTree.Node<Integer> node = new BinaryTree.Node<>(2);
        BinaryTree.Node<Integer> subNode = new BinaryTree.Node<>(1);
        node.left = subNode;
        subNode.parent = node;
        subNode = new BinaryTree.Node<>(3);
        node.right = subNode;
        subNode.parent = node;

        binaryTree.root = node;

        System.out.println("Is binary tree a binary search tree? " + checkBST(binaryTree));

        node = subNode;
        subNode = new BinaryTree.Node<>(4);
        node.right = subNode;
        subNode.parent = node;
        node = subNode;
        subNode = new BinaryTree.Node<>(5);
        node.right = subNode;
        subNode.parent = node;

        System.out.println("Is binary tree a binary search tree? " + checkBST(binaryTree));
    }
}
