package _6_treesandgraphs.datastructures;

public class BinaryTree<T> {
    public static class Node<T> {
        public T data;

        public Node<T> parent;
        public Node<T> left;
        public Node<T> right;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public Node<T> root;


    public int size(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return size(node.left) + size(node.right) + 1;
    }

    public void inOrderTraversal(Node<T> node) {
        if (node != null) {
            inOrderTraversal(node.left);
            visit(node);
            inOrderTraversal(node.right);
        }
    }

    public void preOrderTraversal(Node<T> node) {
        if (node != null) {
            visit(node);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public void postOrderTraversal(Node<T> node) {
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
