package _6_treesandgraphs;

//Return the next node of a node based on in-order traversal
//If node has a right subtree. The left most node in the subtree is the next node
//Otherwise, the above node of the node, to which the current node falls on the right side is the next node
//TreeNode inOrderSucc(TreeNode node)
//  if (node.right != null)
//      return leftMostNode(node.right)
//  else
//      parent = node.parent
//      child = node
//      while (parent != null && parent.right == child)
//          child = parent
//          parent = parent.parent
//      return parent
//TreeNode leftMostNode(TreeNode node)
//  while (node.left != null)
//      node = node.left
//  return node
//Complexity: Time: Distance to leftmost child node or Above node to which the input node lies to the left

import _6_treesandgraphs.datastructures.BinaryTree;

public class Example6_1 {
    private static BinaryTree.Node<Integer> inOrderSuccessor(BinaryTree.Node<Integer> node) {
        if (node.right != null) {
            return leftMostNode(node.right);
        } else {
            BinaryTree.Node<Integer> parent = node.parent;
            BinaryTree.Node<Integer> child = node;
            while (parent != null && parent.right == child) {
                child = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    private static BinaryTree.Node<Integer> leftMostNode(BinaryTree.Node<Integer> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
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

        System.out.println("Next successor of node 3? " + inOrderSuccessor(subNode));

        node = subNode;
        subNode = new BinaryTree.Node<>(4);
        node.right = subNode;
        subNode.parent = node;
        node = subNode;
        subNode = new BinaryTree.Node<>(5);
        node.right = subNode;
        subNode.parent = node;

        System.out.println("Next successor of node 2? " + inOrderSuccessor(binaryTree.root));
    }
}
