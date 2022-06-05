package treesandgraphs.datastructures;

public class BinaryTree<T> {
    static class Node<T> {
        T data;

        Node<T> parent;
        Node<T> left;
        Node<T> right;

        Node (T data) {
            this.data = data;
        }
    }

    protected Node<T> root;

    void inOrderTraversal(Node<T> node) {
        if (node != null) {
            inOrderTraversal(node.left);
            visit(node);
            inOrderTraversal(node.right);
        }
    }

    void preOrderTraversal(Node<T> node) {
        if (node != null) {
            visit(node);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    void postOrderTraversal(Node<T> node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            visit(node);
        }
    }

    private void visit(Node<T> node) {
        System.out.print(node.data + " -> ");
    }
}
