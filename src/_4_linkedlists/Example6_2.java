package _4_linkedlists;

import _4_linkedlists.datastructures.LinkedList;

import java.util.Stack;

//Implement a function to check if a linked list is a palindrome
//Example: 0 -> 1 -> 2 -> 1 -> 0
//Example: null
//Example: 0 -> 1 -> 2 -> 3
//Brute force:
//Determine the middle
//The elements equally distant from the middle are the same for palindrome
//Complexity: O(n) in time and space
//Optimize:?
//Walk through:
// boolean isPalindrome(node)
//  Determine the middle of the second half, at the same time push elements while traversing the first half down a stack
//    Create two pointers p1, p2: Move p2 at twice speed. When p1 or p1.next reaches the end, p2 is at midpoint
//    If p1 != null, move p2 to its next
//  Pop element from the stack and traverse the second half to determine if the elements around center are equal
//    Loop until p2 != null
// Test
public class Example6_2 {
    static boolean isPalindrome(LinkedList.Node<Integer> head) {
        LinkedList.Node<Integer> p1 = head;
        LinkedList.Node<Integer> p2 = head;
        Stack<Integer> stack = new Stack<>();

        //2 time next can be done only if next is not null
        while(p1 != null && p1.next != null) {
            stack.add(p2.data);

            p1 = p1.next.next;
            p2 = p2.next;
        }

        if (p1 != null) {
            p2 = p2.next;
        }

        while (p2 != null) {
            int left = stack.pop();
            int right = p2.data;
            if (left != right) {
                return false;
            }
            p2 = p2.next;
        }

        return true;
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
