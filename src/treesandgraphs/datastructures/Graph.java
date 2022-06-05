package treesandgraphs.datastructures;

import arraysandstrings.datastructures.ArrayList;
import stacksandqueues.datastructures.Queue;

public class Graph<T> {
    public static class Node<T> {
        private T data;
        private ArrayList<Node<T>> adjacentNodes = new ArrayList<>();
        State state;

        private Node(T data) {
            this.data = data;
        }

        private void add(Node<T> adjacentNode) {
            adjacentNodes.add(adjacentNode);
        }
    }

    enum State {
        Unvisited,
        Visiting,
        Visited
    }

    private ArrayList<Node<T>> nodes = new ArrayList<>();

    public void add(T data) {
        Node<T> node = new Node<>(data);
        nodes.add(node);
    }

    public void add(int sourceIndex, int targetIndex) {
        Node<T> sourceNode = get(sourceIndex);
        Node<T> targetNode = get(targetIndex);

        sourceNode.add(targetNode);
    }

    public Node<T> get(int index) {
        return nodes.get(index);
    }

    public boolean breadthFirstSearch(int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return true;
        }

        Node<T> startNode = get(startIndex);
        Node<T> endNode = get(endIndex);

        if (startNode != null && endNode != null) {
            resetNodeState();

            Queue<Node<T>> queue = new Queue<>();
            startNode.state = State.Visiting;
            queue.add(startNode);

            Node<T> node;
            Node<T> adjacentNode;
            while (!queue.isEmpty()) {
                node = queue.remove().data;
                visit(node);
                for (int i = 0; i < node.adjacentNodes.size(); i++) {
                    adjacentNode = node.adjacentNodes.get(i);
                    if (adjacentNode.state == State.Unvisited) {
                        if (adjacentNode == endNode) {
                            return true;
                        } else {
                            adjacentNode.state = State.Visiting;
                            queue.add(adjacentNode);
                        }
                    }
                }
                node.state = State.Visited;
            }
        }
        return false;
    }

    private void resetNodeState() {
        for (int i = 0; i < nodes.size(); i++) {
            nodes.get(i).state = State.Unvisited;
        }
    }

    public void depthFirstSearch(Node<T> node) {
        if (node != null) {
            visit(node);
            node.state = State.Visited;

            Node<T> adjacentNode;
            for (int i = 0; i < node.adjacentNodes.size(); i++) {
                adjacentNode = node.adjacentNodes.get(i);
                if (adjacentNode.state == State.Unvisited) {
                    adjacentNode.state = State.Visiting;
                    depthFirstSearch(adjacentNode);
                }
            }
        }
    }

    /*public void bidirectionalSearch(Node<T> start, Node<T> end) {
        if (start != null && end != null) {
            if (node != null) {
                Queue<Node<T>> queue = new Queue<>();
                node.marked = true;
                queue.add(node);

                Node<T> adjacentNode;
                while (!queue.isEmpty()) {
                    node = queue.remove().data;
                    visit(node);
                    for (int i = 0; i < node.adjacentNodes.size(); i++) {
                        adjacentNode = node.adjacentNodes.get(i);
                        if (!adjacentNode.marked) {
                            adjacentNode.marked = true;
                            queue.add(adjacentNode);
                        }
                    }
                }
            }
        }
    }*/

    private void visit(Node<T> node) {
        System.out.print(node.data + " -> ");
    }

}
