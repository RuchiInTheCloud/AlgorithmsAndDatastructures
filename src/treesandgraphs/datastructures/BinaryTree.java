package treesandgraphs.datastructures;

public class BinaryTree<T> {
    public static class Node<T> {
        T data;

        public Node<T> left;
        public Node<T> right;

        public Node(T data) {
            this.data = data;
        }
    }

    public Node<T> root;

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
