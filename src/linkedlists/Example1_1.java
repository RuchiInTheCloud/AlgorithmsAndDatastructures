package linkedlists;

import linkedlists.datastructures.LinkedList;

import java.util.HashSet;

//Given: Remove duplicates from an unsorted linked list
//Example: 1 -> 2 -> 1 : 1 -> 2
//Example: null
//Example: 1 -> 2 -> 3
//Brute force: Traverse the linked list, drop content into a hashtable. If key found, remove element from linked list
//Complexity: time O(n), space O(n)
//Optimize: Use no buffer in next solution
//Walk through: Create hash set, Keep track of previous node
//Test: prev update
public class Example1_1 {
    public static void removeDuplicates(LinkedList<Integer> linkedList) {
        HashSet<Integer> set = new HashSet<>();
        LinkedList.Node<Integer> prev = null;
        LinkedList.Node<Integer> current = linkedList.head;

        while (current != null) {
            if (set.contains(current.data)) {
                prev.next = current.next;
            } else {
                set.add(current.data);
                prev = current;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.appendToTail(1);
        linkedList.appendToTail(2);
        linkedList.appendToTail(3);

        System.out.println(linkedList);

        removeDuplicates(linkedList);

        System.out.println(linkedList);
    }
}
