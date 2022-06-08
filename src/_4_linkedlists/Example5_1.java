package _4_linkedlists;

import _4_linkedlists.datastructures.LinkedList;

//Two numbers represented by linked list (each node contains a single digit), return their sum as a linked list
//Input: (7 -> 1 -> 6) + (5 -> 9 -> 2) = 617 + 295
//Output: 2 -> 1 -> 9: 912
//Example2 : null + null = null
//Bruteforce:
// Base case: null + null + 0 = return null
// Generic case: Sum the digits and the carry at the same index, repeat for the next nodes and carry generated
// Complexity: O(n+m)
// Optimize: BCR
//Walk through:
// node sum(node1, node2, carry)
//  base case node1 = null & node2 = null & carry = 0 --> return null
//  new node
//  sum = node1.val? + node2.val? + carry?;
//  new node.value = sum % 10
//  node.next(sum(node.next, node.next, carry))
//  return node
//Test:
public class Example5_1 {
    static LinkedList.Node<Integer> sum(LinkedList.Node<Integer> number1, LinkedList.Node<Integer> number2, int carry) {
        if (number1 == null && number2 == null && carry == 0) {
            return null;
        }
        int sum = carry;
        if (number1 != null) {
            sum += number1.data;
        }
        if (number2 != null) {
            sum += number2.data;
        }
        LinkedList.Node<Integer> node = LinkedList.Node.createNode(sum % 10);
        node.next = sum(number1 == null ? null : number1.next,
                number2 == null ? null : number2.next, sum >= 10 ? 1 : 0);
        return node;
    }

    public static void main(String[] args) {
        LinkedList<Integer> number1 = new LinkedList<>();
        number1.addLast(7);
        number1.addLast(1);
        number1.addLast(6);

        LinkedList<Integer> number2 = new LinkedList<>();
        number2.addLast(5);
        number2.addLast(9);
        number2.addLast(2);

        System.out.println("Number 1: " + number1);
        System.out.println("Number 2: " + number2);

        LinkedList<Integer> sum = new LinkedList<>();
        sum.head = sum(number1.head, number2.head, 0);

        System.out.println("Sum: " + sum.string());
    }
}
