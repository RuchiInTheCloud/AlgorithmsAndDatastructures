package _6_treesandgraphs;

import _6_treesandgraphs.datastructures.BinaryTree;

// Question: Find the common ancestor of two tree nodes
//
//Example: Two nodes may be in separate trees
//Example: One node may be the parent of the other
//Example: Two nodes may be in the left subtree of root
//Example: Two nodes may be in the right subtree of root
//
//Check the first case by checking whether the root covers both p and q
//Call recursive method with root, p, q
//
//Recursively check
//
// if (node == null || node == p || node == q)
//      return node
//
//  whether p, and q are on the left side of the node
//      If they are on opposite side --> return node
//
//  If both are on the right side, call recursively with node.right, p, q
//  If both are on the left side, call recursively with node.left, p, q
//
// Time complexity: n + n + n/2 + n/2 + n/4 + n/4 .. = O(n)
public class Example8_3 {
    private static BinaryTree.Node<Integer> commonAncestor(BinaryTree.Node<Integer> root, BinaryTree.Node<Integer> p,
            BinaryTree.Node<Integer> q) {
        if (!covers(root, p) || !covers(root, q)) {
            return null;
        }

        return ancestorHelper(root, p, q);
    }

    private static BinaryTree.Node<Integer> ancestorHelper(BinaryTree.Node<Integer> node, BinaryTree.Node<Integer> p,
            BinaryTree.Node<Integer> q) {
        if ((node == null) || (node == p) || (node == q)) {
            return node;
        }

        boolean pIsOnLeft = covers(node.left, p);
        boolean qIsOnLeft = covers(node.right, q);

        if (pIsOnLeft != qIsOnLeft) {
            return node;
        }

        BinaryTree.Node<Integer> nextParent = (pIsOnLeft ? node.left : node.right);
        return ancestorHelper(nextParent, p, q);
    }

    private static boolean covers(BinaryTree.Node<Integer> node, BinaryTree.Node<Integer> anotherNode) {
        if (node == null)
            return false;
        else if (node == anotherNode)
            return true;
        else
            return covers(node.left, anotherNode) || covers(node.right, anotherNode);
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
