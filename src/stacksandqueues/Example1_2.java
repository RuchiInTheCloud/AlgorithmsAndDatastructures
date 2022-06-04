package stacksandqueues;

import stacksandqueues.datastructures.FullStackException;

import java.util.EmptyStackException;

public class Example1_2 {
    public static void main(String[] args) {
        MultiStack multiStack = new MultiStack(3, 2);
        multiStack.push(0, 1);
        System.out.println("State of stack 0: Is empty? " + multiStack.stackInfos[0].isEmpty());
        System.out.println("State of stack 0: Is full? " + multiStack.stackInfos[0].isFull());

        multiStack.push(1, 1);
        multiStack.push(1, 2);
        System.out.println("State of stack 1: Is empty? " + multiStack.stackInfos[1].isEmpty());
        System.out.println("State of stack 1: Is full? " + multiStack.stackInfos[1].isFull());

        multiStack.push(2, 1);
        multiStack.push(2, 2);
        multiStack.push(2, 3);
        System.out.println("State of stack 2: Is empty? " + multiStack.stackInfos[2].isEmpty());
        System.out.println("State of stack 2: Is full? " + multiStack.stackInfos[2].isFull());
    }
}

class MultiStack {
    class StackInfo {
        int start;
        int capacity;
        int size;

        StackInfo(int start, int capacity) {
            this.start = start;
            this.capacity = capacity;
        }

        public int lastElementIndex() {
            return adjustIndex(start + size - 1);
        }

        public boolean isFull() {
            return size == capacity;
        }

        boolean isEmpty() {
            return size == 0;
        }
    }

    int[] values;
    StackInfo[] stackInfos;

    MultiStack(int numberOfStacks, int defaultSize) {
        values = new int[defaultSize * numberOfStacks];
        stackInfos = new StackInfo[numberOfStacks];
        for (int i = 0; i < numberOfStacks; i++) {
            stackInfos[i] = new StackInfo(i * defaultSize, defaultSize);
        }
    }

    void push(int stackNumber, int value) {
        if (allStacksFull()) {
            throw new FullStackException();
        }

        if (stackInfos[stackNumber].isFull()) {
            expand(stackNumber);
        }

        stackInfos[stackNumber].size++;
        values[stackInfos[stackNumber].lastElementIndex()] = value;
    }

    int pop(int stackNumber) {
        if (stackInfos[stackNumber].isEmpty()) {
            throw new EmptyStackException();
        }
        int value = values[stackInfos[stackNumber].lastElementIndex()];
        values[stackInfos[stackNumber].lastElementIndex()] = 0;
        stackInfos[stackNumber].size--;
        return value;
    }

    int peek(int stackNumber) {
        if (stackInfos[stackNumber].isEmpty()) {
            throw new EmptyStackException();
        }
        return values[stackInfos[stackNumber].lastElementIndex()];
    }

    private void expand(int stackNumber) {
        shift((stackNumber + 1) % stackInfos.length);
        stackInfos[stackNumber].capacity++;
    }

    private void shift(int stackNumber) {
    }

    private boolean allStacksFull() {
        return numberOfElements() == values.length;
    }

    private int numberOfElements() {
        int numberOfElements = 0;
        for (StackInfo stackInfo : stackInfos) {
            numberOfElements += stackInfo.size;
        }
        return numberOfElements;
    }

    private int adjustIndex(int index) {
        return (index + values.length) % values.length;
    }
}
