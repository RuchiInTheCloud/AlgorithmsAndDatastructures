package treesandgraphs;

import treesandgraphs.datastructures.BinaryTree;

//Convert a sorted array into a BST
//Left descendants <= n < Right descendants
//Tree needs to be "constructed" recursively
//Complexity: O(n) in time, call stack space: O(log n)
public class Example2_1 {
    static BinaryTree.Node<Integer> createMinimalBST(int[] array, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = (low + high) / 2;
        BinaryTree.Node<Integer> node = new BinaryTree.Node<>(array[mid]);
        node.left = createMinimalBST(array, low, mid - 1);
        node.right = createMinimalBST(array, mid + 1, high);

        return node;
    }

    public static void main(String[] args) {
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        BinaryTree<Integer> bst = new BinaryTree<>();
        bst.root = createMinimalBST(array, 0, array.length - 1);
        bst.inOrderTraversal(bst.root);
    }
}
