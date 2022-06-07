package treesandgraphs;

import treesandgraphs.datastructures.BinaryTree;

// Question: Find the common ancestor of two tree nodes
//
//Example: Two nodes may be in separate trees
//Example: One node may be the parent of the other
//Example: Two nodes may be in the left subtree of root
//Example: Two nodes may be in the right subtree of root
//
// Search for p and q, bubble up when found
// Return the node where p and q are found in its left and right subtree
//
// Time Complexity: n
//
//Cannot distinguish the case where p or q is not in the tree
public class Example8_4 {
    private static BinaryTree.Node<Integer> commonAncestor(BinaryTree.Node<Integer> root, BinaryTree.Node<Integer> p,
            BinaryTree.Node<Integer> q) {
        if (root == null) {
            return null;
        } else if (root == p && root == q) {
            return root;
        }

        BinaryTree.Node<Integer> x = commonAncestor(root.left, p, q);
        if (x != null && x != p && x != q) {
            return x;
        }
        BinaryTree.Node<Integer> y = commonAncestor(root.right, p, q);
        if (y != null && y != p && y != q) {
            return x;
        }

        if (x != null && y != null) {
            return root;
        } else if (root == p || root == q) {
            // q could be in left or right subtree OR p could be in left or right subtree
            return root;
        } else if (x != null) {
            return x;
        } else {
            return y;
        }
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
