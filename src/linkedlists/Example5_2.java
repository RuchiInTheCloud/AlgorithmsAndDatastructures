package linkedlists;

import linkedlists.datastructures.LinkedList;

//Two numbers represented by linked list (each node contains a single digit), return their sum as a linked list
//If digits are stored in forward order, Repeat the above problem
//Input: (6 -> 1 -> 7) + (2 -> 9 -> 5) = 617 + 295
//Output: 9 -> 1 -> 2: 912
//Example2 : null + null = null
public class Example5_2 {
    static LinkedList.Node<Integer> sum(LinkedList.Node<Integer> number1, LinkedList.Node<Integer> number2, int carry) {
    }

    public static void main(String[] args) {
        LinkedList<Integer> number1 = new LinkedList<>();
        number1.appendToTail(6);
        number1.appendToTail(1);
        number1.appendToTail(7);

        LinkedList<Integer> number2 = new LinkedList<>();
        number2.appendToTail(2);
        number2.appendToTail(9);
        number2.appendToTail(5);

        System.out.println("Number 1: " + number1);
        System.out.println("Number 2: " + number2);

        LinkedList<Integer> sum = new LinkedList<>();
        sum.head = sum(number1.head, number2.head, 0);

        System.out.println("Sum: " + sum);
    }
}
