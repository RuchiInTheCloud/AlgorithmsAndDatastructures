package stacksandqueues;

import stacksandqueues.datastructures.MultiStack;

public class Example1_2 {
    public static void main(String[] args) {
        MultiStack multiStack = new MultiStack(3, 2);
        multiStack.push(0, 1);
        System.out.println("State of stack 0: Is empty? " + multiStack.isEmpty(0));
        System.out.println("State of stack 0: Is full? " + multiStack.isFull(0));

        multiStack.push(1, 1);
        multiStack.push(1, 2);
        System.out.println("State of stack 1: Is empty? " + multiStack.isEmpty(1));
        System.out.println("State of stack 1: Is full? " + multiStack.isFull(1));

        multiStack.push(2, 1);
        multiStack.push(2, 2);
        multiStack.push(2, 3);
        System.out.println("State of stack 2: Is empty? " + multiStack.isEmpty(2));
        System.out.println("State of stack 2: Is full? " + multiStack.isFull(2));

        multiStack.push(0, 2);
    }
}

