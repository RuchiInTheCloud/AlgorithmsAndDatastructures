package _6_treesandgraphs;

import _6_treesandgraphs.datastructures.BinaryTree;

//Convert a sorted array into a BST
// left descendants <= n < right descendants
// If we insert every element into tree the time to insert n elements would be O(nlogn)
// Tree needs to be "constructed" recursively
// treenode createBST(array, start, end)
// Initially root in middle
// root.left = mid of left subsection [start, mid - 1] (recursively construct this nodes children)
// root.right = mid of right subsection [mid + 1, end] (recursively construct this nodes children)
// return root
//Complexity: O(n) in time, call stack space: O(log n)
public class Example2_1 {
    private static BinaryTree<Integer> createMinimalBST(int[] array) {
        BinaryTree<Integer> bst = new BinaryTree<>();
        bst.root = createMinimalBST(array, 0, array.length - 1);
        return bst;
    }

    private static BinaryTree.Node<Integer> createMinimalBST(int[] array, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = (low + high) / 2;
        BinaryTree.Node<Integer> node = new BinaryTree.Node<>(array[mid]);
        node.left = createMinimalBST(array, low, mid - 1);
        if (node.left != null) {
            node.left.parent = node;
        }
        node.right = createMinimalBST(array, mid + 1, high);
        if (node.right != null) {
            node.right.parent = node;
        }

        return node;
    }

    public static void main(String[] args) {
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        BinaryTree<Integer> bst = createMinimalBST(array);
        bst.inOrderTraversal(bst.root);
    }
}
