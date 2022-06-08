package _4_linkedlists;

import _4_linkedlists.datastructures.LinkedList;

//Determine the start of a loop, if loop is present in a linked list
//Example:X - X - X - X
//                 X     X
//              X          X
//                X      X
//                    X
//Example: null
//Example:X - X - X
//Brute force:
//Create two pointers p1, p2.
//Traverse the list, let p1 make 2 step hops. Let p2 make 1 step hops.
//   If the start of the loop is k step away from head,
//      after k steps, p1 = k or K (mod(k%loopsize)) steps into loop, p2 = k steps from head
//      after loopsize - K steps, p1 will be at p2, break
//Move p1 to head
//Traverse the list, move both p1 and p2 at 1 step hop. After k = K +(m * loopsize) steps they will hit the start of the loop
//Complexity: O(n) in time
//Optimize: ?
//Test
public class Example8_1 {
    static LinkedList.Node<Integer> findBeginning(LinkedList.Node<Integer> head) {
        if (head == null) {
            return null;
        }

        LinkedList.Node<Integer> p1 = head;
        LinkedList.Node<Integer> p2 = head;

        while (p1 != null && p1.next != null) {
            p1 = p1.next.next;
            p2 = p2.next;

            if (p1 == p2) {
                break;
            }
        }

        if (p1 == null || p1.next == null) {
            return null;
        }

        p1 = head;

        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.addLast(0);
        list1.addLast(1);
        list1.addLast(1);
        list1.addLast(1);
        list1.addLast(1);
        list1.addLast(1);
        list1.addLast(1);
        list1.addLast(1);
        list1.addLast(list1.head);

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.addLast(1);
        list2.addLast(1);
        list2.addLast(1);
        list2.addLast(list1.head);

        LinkedList.Node<Integer> beginning = findBeginning(list2.head);

        System.out.println("Beginning node is: " + beginning.data);
    }
}
