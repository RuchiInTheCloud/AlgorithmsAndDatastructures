package onotation;

public class Example10 {
    //Balanced binary search tree
    //Time complexity = O(N), N is number of nodes in the tree
    static class Node {
        int value;
        Node left;
        Node right;
    }

    static int sum(Node node) {
        if (node == null) {
            return 0;
        }
        return sum(node.left) + node.value + sum(node.right);
    }

    public static void main(String[] args) {
        Node n0 = new Node();
        n0.value = 1;
        Node nl = new Node();
        nl.value = 2;
        Node nr = new Node();
        nr.value = 3;
        n0.left = nl;
        n0.right = nr;

        System.out.println(sum(n0));
    }
}
