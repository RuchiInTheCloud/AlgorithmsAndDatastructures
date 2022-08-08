package _4_linkedlists;

import _4_linkedlists.datastructures.LinkedList;

//Implement a function to check if a linked list is a palindrome
//Example: 0 -> 1 -> 2 -> 1 -> 0
//Example: null
//Example: 0 -> 1 -> 2 -> 3
//Brute force: Reverse the list and compare to original
//Complexity: O(n) in time and space
//Optimize: space?
//Walk through: boolean isPalindrome(node node)
//reverse --> create new linked list
//  To reverse we need to go down the callstack by following the next pointer
//  The root call should return the tail node of original with consecutive next pointers set up to traverse the original in reverse
//      To update the next node of the reverse list the tail node of the partial reverse list also needs to be passed up the stack
//compare reverse with original
//Test: check for null values
public class Example6_1 {
    private static class HeadAndTail {
        LinkedList.Node<Integer> head;
        LinkedList.Node<Integer> tail;

        HeadAndTail(LinkedList.Node<Integer> head, LinkedList.Node<Integer> tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    static boolean isPalindrome(LinkedList.Node<Integer> head) {
        boolean isPalindrome = false;
        if (head != null) {
            HeadAndTail ht = reverse(head);
            isPalindrome = isEqual(head, ht.head);
        }
        return isPalindrome;
    }

    static HeadAndTail reverse(LinkedList.Node<Integer> node) {
        if (node == null) {
            return null;
        }

        HeadAndTail ht = reverse(node.next);
        LinkedList.Node<Integer> duplicate = new LinkedList.Node<>(node.data);

        if (ht == null) {
            return new HeadAndTail(duplicate, duplicate);
        }

        ht.tail.next = duplicate;
        ht.tail = duplicate;
        return ht;
    }

    static boolean isEqual(LinkedList.Node<Integer> head1, LinkedList.Node<Integer> head2) {
        while (head1 != null && head2 != null) {
            if (!head1.data.equals(head2.data)) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1 == null && head2 == null;
    }

    public static void main(String[] args) {
        LinkedList<Integer> example1 = new LinkedList<>();
        example1.addLast(0);
        example1.addLast(1);
        example1.addLast(2);
        example1.addLast(1);
        example1.addLast(0);

        System.out.println("Is example " + example1.string() + " a palindrome? " + isPalindrome(example1.head));
    }
}
