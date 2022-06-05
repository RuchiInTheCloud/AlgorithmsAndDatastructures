package treesandgraphs.datastructures;

import arraysandstrings.datastructures.ArrayList;

public class Graph<T> {
    public static class Node<T> {
        public T data;
        public ArrayList<Node<T>> adjacentNodes;

        public Node(T data) {
            this.data = data;
        }
    }

    public ArrayList<Node<T>> nodes;
}
