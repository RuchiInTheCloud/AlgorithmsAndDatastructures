package linkedlists;

import linkedlists.datastructures.LinkedList;

//Implement a function to check if a linked list is a palindrome
//Example: 0 -> 1 -> 2 -> 1 -> 0
//Example: null
//Example: 0 -> 1 -> 2 -> 3
//Brute force:
//Determine the length of the list
//Determine the center of the list via recursion
//Compare the elements equidistant from the center when coming out of the call stack
//Complexity: O(n) in time and space
//Walk through:
//Determine the length of the list -> len
//Find the mid point of list through recursion
//  isPalindrome(node, len)
//      if (node == null || len == 0)
//          return node, true
//      if (len == 1)
//          return node.next, true
//      returned node, result = isPalindrome(node.next, len - 2)
//      if (result == false)
//          return returned node, result
//      result = returned node.data == node.data
//      return returned node.next, result
public class Example6_3 {
    static class Result {
        LinkedList.Node<Integer> node;
        boolean result;

        Result(LinkedList.Node<Integer> node, boolean result) {
            this.node = node;
            this.result = result;
        }
    }

    static boolean isPalindrome(LinkedList.Node<Integer> head) {
        int length = length(head);
        Result result = isPalindrome(head, length);
        return result.result;
    }

    private static int length(LinkedList.Node<Integer> head) {
        LinkedList.Node<Integer> current = head;
        int size = 0;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    static Result isPalindrome(LinkedList.Node<Integer> node, int length) {
        if (node == null || length == 0) {
            return new Result(node, true);
        } else if (length == 1) {
            return new Result(node.next, true);
        }
        Result result = isPalindrome(node.next, length - 2);
        if (!result.result) {
            return result;
        }

        result.result = (result.node.data.equals(node.data));
        result.node = result.node.next;
        return result;
    }

    public static void main(String[] args) {
        LinkedList<Integer> example1 = new LinkedList<>();
        example1.appendToTail(0);
        example1.appendToTail(1);
        example1.appendToTail(2);
        example1.appendToTail(1);
        example1.appendToTail(0);

        System.out.println("Is example " + example1 + " a palindrome? " + isPalindrome(example1.head));

        LinkedList<Integer> example2 = new LinkedList<>();
        example2.appendToTail(0);
        example2.appendToTail(1);
        example2.appendToTail(2);
        example2.appendToTail(3);

        System.out.println("Is example " + example2 + " a palindrome? " + isPalindrome(example2.head));
    }
}
