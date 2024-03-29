package _4_linkedlists;

import _4_linkedlists.datastructures.LinkedList;

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
        LinkedList.Node<Integer> current = linkedList.head;
        while (current != null) {
            LinkedList.Node<Integer> runner = current;
            while (runner.next != null) {
                if (runner.next.data.equals(current.data)) {
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
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(1);

        System.out.println(linkedList.string());

        removeDuplicates(linkedList);

        System.out.println(linkedList.string());
    }
}
