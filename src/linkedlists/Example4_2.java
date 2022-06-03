package linkedlists;

import linkedlists.datastructures.LinkedList;

//Partition a linked list around a value x such that elements < x appear on the left side and elements >= x on the right side
//Example: I/P: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [x = 5] O/P: 3 -> 2 -> 1 -> 10 -> 5 -> 5 -> 8
//Bruteforce: Traverse through the list and create in place a new list such that elem < x are placed in front of head,
// and elem >= x are placed after tail
//Complexity: time: O(N)
//Optimize: BCR
//Walk through:
//Help variable: head and tail pointing initially to linked list head, next to point to the next element to traverse to
//void partition(Linkedlist list, int x)
//Base case: No element in linked list
//Base case: Only one element in linked list
//Test:
public class Example4_2 {
    static void partition(LinkedList<Integer> linkedList, int x) {
        if (linkedList.head == null) {
            return;
        }

        LinkedList.Node<Integer> node = linkedList.head;
        LinkedList.Node<Integer> next = node.next;
        node.next = null;
        LinkedList.Node<Integer> head = node;
        LinkedList.Node<Integer> tail = node;

        node = next;
        while (node != null) {
            next = node.next;
            node.next = null;
            if (node.data < x) {
                node.next = head;
                head = node;
            }  else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        linkedList.head = head;
    }
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.appendToTail(3);
        linkedList.appendToTail(5);
        linkedList.appendToTail(8);
        linkedList.appendToTail(5);
        linkedList.appendToTail(10);
        linkedList.appendToTail(2);
        linkedList.appendToTail(1);

        System.out.println("Initial List: " + linkedList.string());
        partition(linkedList, 5);
        System.out.println("After Partition: " + linkedList.string());
    }
}
