package stacksandqueues;

import stacksandqueues.datastructures.FullStackException;

import java.util.EmptyStackException;

//Implement three stacks with an array
//Brute force:
//Allocate [0, n/3), [n/3, 2n/3), [2n/3, n) spaces in the array
//Implement pop(stackNumber), push(stackNumber, T item), peek(stackNumber), isEmpty(stackNumber)
public class Example1_1 {
    static class FixedMultiStack {
        private int numberOfStacks = 3;
        private int stackCapacity;
        int[] values;
        int[] sizes;

        FixedMultiStack(int defaultSize) {
            values = new int[defaultSize * numberOfStacks];
            stackCapacity = defaultSize;
            sizes = new int[numberOfStacks];
        }

        void push(int stackNumber, int value) {
            if (isFull(stackNumber)) {
                throw new FullStackException();
            }
            sizes[stackNumber]++;
            values[indexOfTop(stackNumber)] = value;
        }

        private int indexOfTop(int stackNumber) {
            return stackNumber * stackCapacity + sizes[stackNumber] - 1;
        }

        int pop(int stackNumber) {
            if (isEmpty(stackNumber)) {
                throw new EmptyStackException();
            }

            int value = values[indexOfTop(stackNumber)];
            sizes[stackNumber]--;
            return value;
        }

        int peek(int stackNumber) {
            if (isEmpty(stackNumber)) {
                throw new EmptyStackException();
            }

            return values[indexOfTop(stackNumber)];
        }

        boolean isFull(int stackNumber) {
            return sizes[stackNumber] == stackCapacity;
        }

        boolean isEmpty(int stackNumber) {
            return sizes[stackNumber] == 0;
        }
    }

    public static void main(String[] args) {
        FixedMultiStack multiStack = new FixedMultiStack(2);
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
    }
}
