package linkedlists;

import linkedlists.datastructures.LinkedList;

//Partition a linked list around a value x such that elements < x appear on the left side and elements >= x on the right side
//Example: I/P: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [x = 5] O/P: 3 -> 2 -> 1 -> 10 -> 5 -> 5 -> 8
//Bruteforce: Traverse through the list and create two lists with elem < x, elem >= x
//            Next join the two
//Complexity: time: O(N)
//Optimize: BCR
//Walk through:
//Help variable: remember start and end of both new lists to be able to join them
//Node partition(Node head, int x)
//Test: Be careful about circular references and overwriting original linked list
public class Example4_1 {
    static void partition(LinkedList<Integer> linkedList, int x) {
        LinkedList.Node<Integer> beforeStart = null;
        LinkedList.Node<Integer> beforeEnd = null;
        LinkedList.Node<Integer> afterStart = null;
        LinkedList.Node<Integer> afterEnd = null;

        LinkedList.Node<Integer> current = linkedList.head;
        while (current != null) {
            LinkedList.Node<Integer> next = current.next;
            current.next = null;
            if (current.data < x) {
                if (beforeStart == null) {
                    beforeStart = current;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = current;
                    beforeEnd = current;
                }
            } else {
                if (afterStart == null) {
                    afterStart = current;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = current;
                    afterEnd = current;
                }
            }
            current = next;
            current = current.next;
        }

        if (beforeStart == null) {
            linkedList.head = afterStart;
        }

        beforeEnd.next = afterStart;
        linkedList.head = beforeStart;
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
