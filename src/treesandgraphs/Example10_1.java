package treesandgraphs;

import arraysandstrings.datastructures.StringBuilder;
import treesandgraphs.datastructures.BinaryTree;

//T1 and T2 are two tree. T1 is much larger than T2.
//Write a method to determine if T2 is contained in T1
//
//     3           2
//   2          1     3
// 1
//
//1. In order traversal: X1X2X3X
//2. In order traversal: X1X2X3X
//1. Pre order traversal: 321XXXX
//2. Pre order traversal: 21XX3XX
//
//Create a preorder traversal string for T1 and T2
//Check whether T2 is part of T1
//
//preOrderString(Treenode node, StringBuilder sb)
//  if (node == null) sb.append(X) return
//  sb.append(node.data)
//  preOrderString(node.left)
//  preOrderString(node.right)
//
//boolean isSubtree(Treenode node1, Treenode node2)
//  Stringbuilder preOrderString1 = new Stringbuilder()
//  Stringbuilder preOrderString2 = new Stringbuilder()
//  preOrderString(node1, preOrderString1)
//  preOrderString(node2, preOrderString2)
//  return preOrderString1.toString().indexOf(preOrderString2.toString()) > -1
//
//O(N + M) in time complexity where N is the size of T1 and M the size of T2
//O(N + M) in space complexity
public class Example10_1 {
    static void preOrderString(BinaryTree.Node<Integer> node, StringBuilder sb) {
        if (node == null) {
            sb.append("X");
            return;
        }
        sb.append(node.data + "");
        preOrderString(node.left, sb);
        preOrderString(node.right, sb);
    }

    static boolean isSubtree(BinaryTree<Integer> tree1, BinaryTree<Integer> tree2) {
        StringBuilder preOrderString1 = new StringBuilder();
        StringBuilder preOrderString2 = new StringBuilder();
        preOrderString(tree1.root, preOrderString1);
        preOrderString(tree2.root, preOrderString2);

        return preOrderString1.toString().contains(preOrderString2.toString());
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
