package treesandgraphs;

import treesandgraphs.datastructures.BinaryTree;

//Check if binary tree is a binary search tree
//left subtree <= n < right subtree
//Assumption: there are no duplicates
//Through in order traversal one can get hold of the previous node value
//E.g. When checking the BST condition for a parent node, one would want to have the left child node
// When checking the BST condition for a right child not, one would want to have the right child node
// time complexity= O(n), space complexity O(log n)

public class Example5_2 {
    static class PreviousContent {
        Integer value;
    }

    private static boolean checkBST(BinaryTree<Integer> binaryTree) {
        return checkBST(binaryTree.root, new PreviousContent());
    }

    private static boolean checkBST(BinaryTree.Node<Integer> node, PreviousContent previousContent) {
        if (node == null) {
            return true;
        }

        if (!checkBST(node.left, previousContent)) {
            return false;
        }

        if (previousContent.value != null && node.data <= previousContent.value) {
            return false;
        }
        previousContent.value = node.data;

        if (!checkBST(node.right, previousContent)) {
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
