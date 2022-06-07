package linkedlists;

import linkedlists.datastructures.LinkedList;

//Delete a node in the middle given access to the middle node, ignore last node
//Example: a -> b -> c -> d -> e -> f
//Brute force:
// Base Case: node is null or next is null --> ignore
// Copy the next node content into current node,
// Update current node's next pointer and delete the next node
// Complexity: Time = O(1)
// Optimize: BCR
// Walk through:
// deleteNode(node) --> boolean
//  base case --> false
//  n.data = n.next.data
//  n.next = n.next.next
//  --> true
// Test: The last node cannot be deleted by this approach
public class Example3_1 {
    static boolean deleteNode(LinkedList.Node<String> node) {
        if (node == null || node.next == null) {
            return false;
        }
        node.data = node.next.data;
        node.next = node.next.next;
        return true;
    }

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addLast("a");
        linkedList.addLast("b");
        linkedList.addLast("c");
        linkedList.addLast("d");
        linkedList.addLast("e");
        linkedList.addLast("f");

        System.out.println("Initial List: " + linkedList.string());
        deleteNode(linkedList.head.next.next);
        System.out.println("After Deletion: " + linkedList.string());
    }
}
