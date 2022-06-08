package treesandgraphs;

import treesandgraphs.datastructures.BinaryTree;

import java.util.Random;

//Implement a BST with a method to return a random node
//Each node should have probability 1/N of being returned
//The probability of choosing left subtree : LEFT_SIZE/n
//probability of choosing current node: 1/n
//probability of choosing right subtree: RIGHT_SIZE/n
public class Example11_1 {
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
            if (node == null) {
                return null;
            }
            if (node.data >= data) {
                Node subNode = insert(node.left, data);
                if (subNode == null) {
                    subNode = new Node(data);
                    node.left = subNode;
                    node.size++;
                } else {
                    node.size++;
                }
                return subNode;
            } else {
                Node subNode = insert(node.right, data);
                if (subNode == null) {
                    subNode = new Node(data);
                    node.right = subNode;
                    node.size++;
                } else {
                    node.size++;
                }
                return subNode;
            }
        }

        public Node getRandomNode() {
            return getRandomNode(root);
        }

        private Node getRandomNode(Node node) {
            int leftSize = node.left == null ? 0 : node.left.size;
            Random random = new Random();
            int index = random.nextInt(node.size);
            if (index < leftSize) {
                return getRandomNode(node.left);
            } else if (index == leftSize) {
                return node;
            } else {
                return getRandomNode(node.right);
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
                Node subNode = find(node.left, data);
                return subNode;
            } else if (node.data < data && node.right != null) {
                Node subNode = find(node.right, data);
                return subNode;
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
    }
}
