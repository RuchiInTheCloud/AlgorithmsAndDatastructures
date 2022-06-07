package treesandgraphs;

import treesandgraphs.datastructures.BinaryTree;

// Question: Find the common ancestor of two tree nodes
//
//Example: Two nodes may be in separate trees
//Example: One node may be the parent of the other
//Example: Two nodes may be in the left subtree of root
//Example: Two nodes may be in the right subtree of root
//Example: Two nodes may be in the left and right subtree of a node
//
// Search for p and q, bubble up when found
// Return the node where p and q are found in its left and right subtree
//
// Time Complexity: n
//
//Cannot distinguish the case where p or q is not in the tree
public class Example8_5 {
    private static class Result {
        public BinaryTree.Node<Integer> node;
        public boolean isAncestor;
        public Result(BinaryTree.Node<Integer> node, boolean isAncestor) {
            this.node = node;
            this.isAncestor = isAncestor;
        }
    }

    private static BinaryTree.Node<Integer> commonAncestor(BinaryTree.Node<Integer> root, BinaryTree.Node<Integer> p,
            BinaryTree.Node<Integer> q) {
         Result result = commonAncestorHelper(root, p, q);
         return result.isAncestor ? result.node : null;
    }

    private static Result commonAncestorHelper(BinaryTree.Node<Integer> root, BinaryTree.Node<Integer> p, BinaryTree.Node<Integer> q) {
        if (root == null) {
            return new Result(root, false);
        }

        if (root == p && root == q) {
            return new Result(root, true);
        }

        Result result_left = commonAncestorHelper(root.left, p, q);
        if (result_left.isAncestor) {
            return result_left;
        }

        Result result_right = commonAncestorHelper(root.right, p, q);
        if (result_right.isAncestor) {
            return result_right;
        }

        if (result_left.node != null && result_right.node != null) {
            return new Result(root, true);
        } else if (root == p || root == q) {
            boolean isAncenstor = result_left.node != null || result_right.node != null;
            return new Result(root, isAncenstor);
        } else if (result_left.node != null ) {
            return new Result(result_left.node, false);
        } else {
            return new Result(result_right.node, false);
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
