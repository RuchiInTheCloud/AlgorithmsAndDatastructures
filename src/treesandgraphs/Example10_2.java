package treesandgraphs;

import treesandgraphs.datastructures.BinaryTree;

//T1 and T2 are two tree. T1 is much larger than T2.
//Write a method to determine if T2 is contained in T1
//
//if T2 is null it is included
//Other wise isSubtree(node1, node2)
//if (node1 == null) return false;
//if (node1.data == node2.data && matchSubtree(node1, node2)
//return true
//isSubtree(node.left, node2) || isSubtree(node.right, node2)
//
//boolean matchSubtree(node1, node2)
//node1 == null && node2 == null
//  return true;
//node1 == null or node2 == null
// return false;
//node1.data != node2.data
// return false;
//matchSubtree(node1.left, node2.left) && matchSubtree(node1.right, node2.right)
public class Example10_2 {
    private static boolean isSubtree(BinaryTree<Integer> tree1, BinaryTree<Integer> tree2) {
        if (tree2.root == null) {
            return true;
        } else {
            return isSubtreeHelper(tree1.root, tree2.root);
        }
    }

    private static boolean isSubtreeHelper(BinaryTree.Node<Integer> node1, BinaryTree.Node<Integer> node2) {
        if (node1 == null) {
            return false;
        }
        if (node1.data.equals(node2.data) && matchSubtree(node1, node2)) {
            return true;
        }
        return isSubtreeHelper(node1.left, node2) || isSubtreeHelper(node1.right, node2);
    }

    private static boolean matchSubtree(BinaryTree.Node<Integer> node1, BinaryTree.Node<Integer> node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (!node1.data.equals(node2.data)) {
            return false;
        }
        return matchSubtree(node1.left, node2.left) && matchSubtree(node1.right, node2.right);
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

        node = subNode;
        subNode = new BinaryTree.Node<>(4);
        node.right = subNode;
        subNode.parent = node;
        node = subNode;
        subNode = new BinaryTree.Node<>(5);
        node.right = subNode;
        subNode.parent = node;

        BinaryTree<Integer> subBinaryTree = new BinaryTree<>();

        node = new BinaryTree.Node<>(4);
        subNode = new BinaryTree.Node<>(5);
        node.right = subNode;
        subNode.parent = node;

        subBinaryTree.root = node;

        System.out.println("Is T2 part of T1: " + isSubtree(binaryTree, subBinaryTree));
    }
}
