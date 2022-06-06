package treesandgraphs;

import treesandgraphs.datastructures.BinaryTree;

public class Example4_2 {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        BinaryTree.Node<Integer> node = new BinaryTree.Node<>(1);
        BinaryTree.Node<Integer> subNode = new BinaryTree.Node<>(2);
        node.left = subNode;
        subNode = new BinaryTree.Node<>(3);
        node.right = subNode;
        binaryTree.root = node;

        System.out.println("Is binary tree balanced? " + checkBalanced(binaryTree));

        node = subNode;
        subNode = new BinaryTree.Node<>(4);
        node.right = subNode;
        node = subNode;
        subNode = new BinaryTree.Node<>(5);
        node.right = subNode;

        System.out.println("Is binary tree balanced? " + checkBalanced(binaryTree));
    }

    private static boolean checkBalanced(BinaryTree<Integer> binaryTree) {
        return false;
    }
}
