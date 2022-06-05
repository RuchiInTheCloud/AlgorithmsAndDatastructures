package treesandgraphs.datastructures;

import arraysandstrings.datastructures.ArrayList;
import stacksandqueues.datastructures.Queue;

public class Graph<T> {
    static class Node<T> {
        public T data;
        public ArrayList<Node<T>> adjacentNodes;
        State state;

        public Node(T data) {
            this.data = data;
        }
    }

    static enum State {
        Unvisited,
        Visiting,
        Visited
    }

    public ArrayList<Node<T>> nodes;

    public boolean breadthFirstSearch(Node<T> start, Node<T> end) {
        if (start == end) {
            return true;
        }

        if (start != null && end != null) {
            for (int i = 0; i < nodes.size(); i++) {
                nodes.get(0).state = State.Unvisited;
            }

            Queue<Node<T>> queue = new Queue<>();
            start.state = State.Visiting;
            queue.add(start);

            Node<T> node;
            Node<T> adjacentNode;
            while (!queue.isEmpty()) {
                node = queue.remove().data;
                visit(node);
                for (int i = 0; i < node.adjacentNodes.size(); i++) {
                    adjacentNode = node.adjacentNodes.get(i);
                    if (adjacentNode.state == State.Unvisited) {
                        if (adjacentNode == end) {
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

    public void depthFirstSearch(Node<T> node) {
        if (node != null) {
            visit(node);
            node.marked = true;

            Node<T> adjacentNode;
            for (int i = 0; i < node.adjacentNodes.size(); i++) {
                adjacentNode = node.adjacentNodes.get(i);
                if (!adjacentNode.marked) {
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
        System.out.println(node.data);
    }
}
