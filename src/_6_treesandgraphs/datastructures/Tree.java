package _6_treesandgraphs.datastructures;

public class Tree<T> {
    public class Node<T> {
        public T data;

        public Node<T> parent;
        public Node<T>[] children;

        public Node(T data) {
            this.data = data;
            children = new Node[N];
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public Node<T> root;
    private int N;

    public Tree(int N) {
        this.N = N;
    }
}
