package treesandgraphs.datastructures;

import arraysandstrings.datastructures.ArrayList;
import arraysandstrings.datastructures.HashTable;
import stacksandqueues.datastructures.Queue;

public class Graph<T> {
    public static class Node<T> {
        public T data;
        public State state;
        int dependencies;

        public ArrayList<Node<T>> adjacentNodes = new ArrayList<>();
        private HashTable<String, Node<T>> adjacentNodesMap = new HashTable<>();

        protected Node(T data) {
            this.data = data;
            dependencies = 0;
        }

        protected void addNeighbor(String adjacentNodeName, Node<T> adjacentNode) {
            if (!adjacentNodesMap.containsKey(adjacentNodeName)) {
                adjacentNodes.add(adjacentNode);
                adjacentNodesMap.put(adjacentNodeName, adjacentNode);
                adjacentNode.dependencies++;
            }
        }

        public void decrementDependencies() {
            this.dependencies--;
        }

        public void resetDependencies() {
            this.dependencies = this.adjacentNodes.size();
        }

        public int getDependencies() {
            return dependencies;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public enum State {
        Unvisited,
        Visiting,
        Visited
    }

    public ArrayList<Node<T>> nodes = new ArrayList<>();
    private HashTable<String, Node<T>> nodesMap = new HashTable<>();

    public int size() {
        return nodes.size();
    }

    public void add(String nodeName, T data) {
        if (!nodesMap.containsKey(nodeName)) {
            Node<T> node = new Node<>(data);
            nodes.add(node);
            nodesMap.put(nodeName, node);
        }
    }

    public void addEdge(String startName, String endName) {
        Node<T> sourceNode = get(startName);
        Node<T> targetNode = get(endName);

        if (sourceNode != null && targetNode != null) {
            sourceNode.addNeighbor(endName, targetNode);
        }
    }

    public Node<T> get(String nodeName) {
        if (nodesMap.containsKey(nodeName)) {
            return nodesMap.get(nodeName);
        }
        return null;
    }

    public Node<T> get(int index) {
        return nodes.get(index);
    }

    public boolean breadthFirstSearch(String startName, String endName) {
        if (startName.equals(endName)) {
            return true;
        }

        Node<T> startNode = get(startName);
        Node<T> endNode = get(endName);

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

    public void resetNodeState() {
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
