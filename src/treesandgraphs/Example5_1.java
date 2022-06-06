package treesandgraphs;

//Check if binary tree is a binary search tree
//left subtree <= n < right subtree
//If there are no duplicates in the tree one could transfer the content of the tree to an array and check whether all
// elements are strictly less than their predecessor
//This approach does not work in case of duplicates, since
//         20         ||          20
//        /                         \
//      20                           20
// In the first case above the tree is a BST, in the second case it is not.
// Via array it is hard to distinguish between the two cases
//
// boolean checkBST(tree tree)
//  int[] array = new int[tree.size()]
//  copyBST(array, tree.root, 0)
//  for i = 1 .. n - 1
//      if (array[i] <= array[i - 1])
//          return false
//  return true
//
// class Index {
//    int index = 0;
// }
//
// copyBST(array, treenode node, Integer index)
//      copyBST(array, node.left, index)
//      array[index] = node.data
//      index.index = index.index + 1;
//      copyBST(array, node.right, index)
//
// time complexity= O(n), space complexity O(n)
// Optimize space in next attempt
import treesandgraphs.datastructures.BinaryTree;

public class Example5_1 {
    private static class Index {
        int index = 0;
    }

    static void copyBST(BinaryTree.Node<Integer> node, int[] array, Index index) {
        if (node == null) {
            return;
        }
        copyBST(node.left, array, index);
        array[index.index] = node.data;
        index.index++;
        copyBST(node.right, array, index);
    }

    static boolean checkBST(BinaryTree<Integer> binaryTree) {
        int[] array = new int[binaryTree.size(binaryTree.root)];
        copyBST(binaryTree.root, array, new Index());
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] <= array[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        BinaryTree.Node<Integer> node = new BinaryTree.Node<>(2);
        BinaryTree.Node<Integer> subNode = new BinaryTree.Node<>(1);
        node.left = subNode;
        subNode = new BinaryTree.Node<>(3);
        node.right = subNode;
        binaryTree.root = node;

        System.out.println("Is binary tree a binary search tree? " + checkBST(binaryTree));

        node = subNode;
        subNode = new BinaryTree.Node<>(4);
        node.right = subNode;
        node = subNode;
        subNode = new BinaryTree.Node<>(5);
        node.right = subNode;

        System.out.println("Is binary tree a binary search tree? " + checkBST(binaryTree));
    }
}
