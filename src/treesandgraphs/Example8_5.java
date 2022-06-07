package treesandgraphs;

import treesandgraphs.datastructures.BinaryTree;

public class Example8_5 {
    private static
    private static BinaryTree.Node<Integer> commonAncestor(BinaryTree.Node<Integer> root, BinaryTree.Node<Integer> left,
            BinaryTree.Node<Integer> right) {

    }

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        BinaryTree.Node<Integer> node = new BinaryTree.Node<>(2);
        binaryTree.root = node;

        BinaryTree.Node<Integer> subNode = new BinaryTree.Node<>(1);
        node.left = subNode;
        subNode.parent = node;
        subNode = new BinaryTree.Node<>(3);
        node.right = subNode;
        subNode.parent = node;

        node = subNode;
        subNode = new BinaryTree.Node<>(4);
        node.right = subNode;
        subNode.parent = node;
        node = subNode;
        subNode = new BinaryTree.Node<>(5);
        node.right = subNode;
        subNode.parent = node;

        BinaryTree.Node<Integer> commonAncestor = commonAncestor(binaryTree.root, binaryTree.root.left,
                binaryTree.root.right.right.right);
        System.out.println("Common ancestor " + commonAncestor);
    }

}
