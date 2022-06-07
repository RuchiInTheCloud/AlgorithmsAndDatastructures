package linkedlists;

import linkedlists.datastructures.LinkedList;

//Two numbers represented by linked list (each node contains a single digit), return their sum as a linked list
//If digits are stored in forward order, Repeat the above problem
//Input: (1 -> 6 -> 1 -> 7) + (2 -> 9 -> 5) = 1617 + 295
//Output: 1 -> 9 -> 1 -> 2: 912
//Example 2 : null + null = null
//Example 3 : 6 + 2
//Example 4 : 6 + 6 = 1 -> 2
//Example 5 : (1 -> 6) + (0 -> 6) = 2 -> 2
//Brute force:
// node sum(node node1, node node2) --> return head of partial linked list
// Measure the length of the two lists
// Since the two list are of different size, pad zeros in the front of the shorter list to ensure both list are of same size
//   Sum needs to start once at the bottom of the call stack with the base condition
//   if (node1==null && node2==null) return new PartialSum(sum, carry)
//   partialSum = sum(node1.next, node2.next)
//   sum = node1.value + node2.value + carry
//   create new node with value = sum%10
//   Insert this node before partialSum.sum and update partialSum.sum, update partialSum.carry
//   return partialSum
// if partialSum received has a carry, create new node with value =  carry, Insert this node before partialSum.sum and update partialSum.sum;
//Complexity: O(N || M), Space: O(N || M)
//Optimize: BCR
//Walk through:
//Test: Changing reference passed to a method inside the method, does not reflect in the calling method
public class Example5_2 {
    private static class PartialSum {
        LinkedList.Node<Integer> sum;
        int carry = 0;
    }

    static LinkedList.Node<Integer> sum(LinkedList.Node<Integer> number1, LinkedList.Node<Integer> number2) {
        int l1 = length(number1);
        int l2 = length(number2);

        if (l1 < l2) {
            number1 = padList(number1, l2 - l1);
        } else {
            number2 = padList(number2, l1 - l2);
        }

        PartialSum sum = sumHelper(number1, number2);
        if (sum.carry > 0) {
            LinkedList.Node<Integer> node = new LinkedList.Node<>(sum.carry);
            node.next = sum.sum;
            sum.sum = node;
        }

        return sum.sum;
    }

    static PartialSum sumHelper(LinkedList.Node<Integer> number1, LinkedList.Node<Integer> number2) {
        if (number1 == null && number2 == null) {
            return new PartialSum();
        }
        PartialSum partialSum = sumHelper(number1.next, number2.next);
        int sum = number1.data + number2.data + partialSum.carry;

        LinkedList.Node<Integer> node = new LinkedList.Node<>(sum % 10);
        node.next = partialSum.sum;
        partialSum.sum = node;
        partialSum.carry = sum / 10;

        return partialSum;
    }

    private static LinkedList.Node<Integer> padList(LinkedList.Node<Integer> node, int n) {
        LinkedList.Node<Integer> current = node;
        for (int i = 0; i < n; i++) {
            LinkedList.Node<Integer> zero = new LinkedList.Node<>(0);
            zero.next = current;
            current = zero;
        }
        return current;
    }

    private static int length(LinkedList.Node<Integer> node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    public static void main(String[] args) {
        LinkedList<Integer> number1 = new LinkedList<>();
        number1.addLast(1);
        number1.addLast(6);
        number1.addLast(1);
        number1.addLast(7);

        LinkedList<Integer> number2 = new LinkedList<>();
        number2.addLast(2);
        number2.addLast(9);
        number2.addLast(5);

        System.out.println("Number 1: " + number1);
        System.out.println("Number 2: " + number2);

        LinkedList<Integer> sum = new LinkedList<>();
        sum.head = sum(number1.head, number2.head);

        System.out.println("Sum: " + sum.string());
    }
}
