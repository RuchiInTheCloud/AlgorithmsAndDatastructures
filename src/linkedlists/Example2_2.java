package linkedlists;

import linkedlists.datastructures.LinkedList;

// Return kth to the last element
// Example: 5 -> 2 -> 1 -> 4 -> 3 ====== 2 --> 4, 3 --> 1, 6 --> null
// Brute force: Traverse the list, move the pointer p2 to the kth element
// Next start pointer p1 and p2 simultaneously, move both p1, p2 pointers simultaneously
// and return the kth element when p2 reaches the end
// Complexity: time = O(n), space = O(1)
// Optimize: BCR
// Walk through:
// Node kthElement(node, k)
//  Initially p1, p2 = head
//  Move p1 ahead by k steps
//  Move p1 and p2 simultaneously, when p1 == null, p2 is at the kth element from the end
// Test: Import library
public class Example2_2 {
    public static LinkedList.Node<String> kthElement(LinkedList.Node<String> head, int k) {
        LinkedList.Node<String> p1 = head;
        LinkedList.Node<String> p2 = head;
        for (int i = 0; i < k; i++) {
            if (p1 == null) {
                return null;
            }
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.appendToTail("Hi");
        linkedList.appendToTail("I");
        linkedList.appendToTail("am");
        linkedList.appendToTail("Ruchi");

        LinkedList.Node<String> kthNode = kthElement(linkedList.head, 2);
        System.out.println("2nd Element found: " + (kthNode == null ? null : kthNode.data));
        kthNode = kthElement(linkedList.head, 3);
        System.out.println("3rd Element found: " + (kthNode == null ? null : kthNode.data));
    }
}
