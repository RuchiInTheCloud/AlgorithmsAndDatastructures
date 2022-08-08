package _4_linkedlists;

import _4_linkedlists.datastructures.LinkedList;

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
        LinkedList.Node<Integer> next = null;

        while (current != null) {
            next = current.next;
            current.next = null;

            if (set.contains(current.data)) {
                prev.next = next;
            } else {
                set.add(current.data);
                prev = current;
            }
            current = next;
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
