package linkedlists;

// Return kth to the last element
// Example: 1 -> 4 -> 3, 2 --> 4, 3 --> 1
// Brute force: Traverse the entire linked list via recursion. Once at the end of the stack count backwards
// and return the kth element
// Complexity: time = O(n), space = O(n)
// Optimize: Space?
// Walk through:
// int kthElement(node, k) depth = x + 1 --> kthElement(node.next, k) depth = x
// ----------------------------------
// Index class
// base case node == null in kthElement(node, k, index) --> index = 0
// node kthElement(node, k, index) --> kthElement(node.next, k, index) index = x
// node kthElement(node, k, index) index = x + 1 <-- kthElement(node.next, k, index)
// node kthElement(node, k, index) index == k, return node <-- kthElement(node.next, k, index)
// node kthElement(node, k, index) index != k, return kthElement(node.next, k, index)

import linkedlists.datastructures.LinkedList;

public class Example2_1 {
    /*public static int kthElement(LinkedList<String>.Node node, int k) {
        if (node == null) {
            return 0;
        }
        int depth = kthElement(node.next, k) + 1;
        if (depth == k) {
            System.out.println("kth Element found: " + node.data);
        }
        return depth;
    }*/
    static class Index {
        int value = 0;
    }
    public static LinkedList.Node<String> kthElement(LinkedList.Node<String> head, int k) {
        return kthElement(head, k, new Index());
    }
    public static LinkedList.Node<String> kthElement(LinkedList.Node<String> head, int k, Index index) {
        if (head == null) {
            return null;
        }
        LinkedList.Node<String> node = kthElement(head.next, k, index);
        index.value = index.value + 1;
        if (index.value == k) {
            return head;
        }
        return node;
    }
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addLast("Hi");
        linkedList.addLast("I");
        linkedList.addLast("am");
        linkedList.addLast("Ruchi");

        LinkedList.Node<String> kthNode = kthElement(linkedList.head, 2);
        System.out.println("2nd Element found: " + kthNode.data);
        kthNode = kthElement(linkedList.head, 3);
        System.out.println("3rd Element found: " + kthNode.data);
    }
}
