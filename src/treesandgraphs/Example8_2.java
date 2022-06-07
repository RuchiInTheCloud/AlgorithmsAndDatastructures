package treesandgraphs;

import treesandgraphs.datastructures.BinaryTree;
import treesandgraphs.datastructures.Tree;

// Question: Find the common ancestor of two tree nodes
//
// Example: Nodes could belong to a different tree, and have no common ancestor
// Example: Nodes could belong to the same tree, in which case they should have a common ancestor
//
// Check whether the root covers the nodes p, q
// Check whether p cover q, or q covers p
// Check iteratively whether for every ancestor of p, p's sibling covers q
//      in every iteration p = p's parent
//
// To check whether a node covers another node
//    if node is null return false
//    if node == another node return true;
//    check whether the left of node covers the other node or the right of the node covers the other node
// Complexity: O(n), where n is all nodes in the tree
public class Example8_2 {
    private static BinaryTree.Node<Integer> commonAncestor(BinaryTree.Node<Integer> root, BinaryTree.Node<Integer> p,
            BinaryTree.Node<Integer> q) {
        if (!covers(root, p) || !covers(root, q)) {
            return null;
        } else if (covers(p, q)) {
            return p;
        } else if (covers(q, p)) {
            return q;
        }

        BinaryTree.Node<Integer> sibling = sibling(p);
        BinaryTree.Node<Integer> parent = p.parent;

        while (!covers(sibling, q)) {
            sibling = sibling(parent);
            parent = parent.parent;
        }

        return parent;
    }

    private static BinaryTree.Node<Integer> sibling(BinaryTree.Node<Integer> node) {
        BinaryTree.Node<Integer> parent = node.parent;
        return parent.left == node ? parent.right : parent.left;
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
