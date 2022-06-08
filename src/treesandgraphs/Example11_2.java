package treesandgraphs;

import java.util.Random;

//Implement a BST with a method to return a random node
//Each node should have probability 1/N of being returned
//Reduce random number calls compare to the previous solution
//
//Select a random index
//Fetch the ith node according to inorder traversal
//
//time and space complexity O(d), where d is max depth of the tree
public class Example11_2 {
    private static class BinarySearchTree {
        private static class Node {
            int data;
            Node left;
            Node right;
            int size;

            Node(int data) {
                this.data = data;
                size = 1;
            }

            @Override
            public String toString() {
                return data + "";
            }
        }

        Node root;

        public void insert(int data) {
            if (root == null) {
                root = new Node(data);
            } else {
                insert(root, data);
            }
        }

        private Node insert(Node node, int data) {
            Node subNode;
            if (node.data >= data) {
                if (node.left == null) {
                    subNode = new Node(data);
                    node.left = subNode;
                    node.size++;
                    return subNode;
                } else {
                    subNode = insert(node.left, data);
                    node.size++;
                }
            } else {
                if (node.right == null) {
                    subNode = new Node(data);
                    node.right = subNode;
                    node.size++;
                } else {
                    subNode = insert(node.right, data);
                    node.size++;
                }
                return subNode;
            }
            return subNode;
        }

        public Node getRandomNode() {
            if (root == null) {
                return null;
            }
            Random random = new Random();
            int index = random.nextInt(root.size);
            return getIthNode(root, index);
        }

        private Node getIthNode(Node node, int index) {
            int leftSize = node.left == null ? 0 : node.left.size;
            if (index < leftSize) {
                return getIthNode(node.left, index);
            } else if (index == leftSize) {
                return node;
            } else {
                return getIthNode(node.right, index - (leftSize + 1));
            }
        }

        public Node find(int data) {
            return find(root, data);
        }

        private Node find(Node node, int data) {
            if (node == null) {
                return null;
            }

            if (node.data == data) {
                return node;
            } else if (node.data > data && node.left != null) {
                return find(node.left, data);
            } else if (node.data < data && node.right != null) {
                return find(node.right, data);
            }

            return null;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(5);
        binarySearchTree.insert(4);
        binarySearchTree.insert(3);
        binarySearchTree.insert(10);
        binarySearchTree.insert(7);

        System.out.println("Random node: " + binarySearchTree.getRandomNode());
        System.out.println("Random node: " + binarySearchTree.getRandomNode());
        System.out.println("Random node: " + binarySearchTree.getRandomNode());
        System.out.println("Random node: " + binarySearchTree.getRandomNode());
        System.out.println("Random node: " + binarySearchTree.getRandomNode());
        System.out.println("Random node: " + binarySearchTree.getRandomNode());
        System.out.println("Random node: " + binarySearchTree.getRandomNode());
        System.out.println("Random node: " + binarySearchTree.getRandomNode());
        System.out.println("Random node: " + binarySearchTree.getRandomNode());
    }
}
