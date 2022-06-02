package linkedlists;

import linkedlists.datastructures.LinkedList;

//Given: Remove duplicates from an unsorted linked list
//Example: 1 -> 2 -> 1 : 1 -> 2
//Example: null
//Example: 1 -> 2 -> 3
//Brute force: Traverse the linked list. For every element, look at the next elements. If key found, remove element from linked list
//Complexity: time O(n^2), space O(1)
//Optimize:
//Walk through:
//Test:
public class Example1_2 {
    public static void removeDuplicates(LinkedList<Integer> linkedList) {
        LinkedList<Integer>.Node current = linkedList.head;
        while (current != null) {
            LinkedList<Integer>.Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.appendToTail(1);
        linkedList.appendToTail(2);
        linkedList.appendToTail(1);

        System.out.println(linkedList);

        removeDuplicates(linkedList);

        System.out.println(linkedList);
    }
}
