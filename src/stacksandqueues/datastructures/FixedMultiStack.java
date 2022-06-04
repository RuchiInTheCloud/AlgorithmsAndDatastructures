package stacksandqueues.datastructures;

import java.util.EmptyStackException;

public class FixedMultiStack {
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public FixedMultiStack(int defaultSize) {
        values = new int[defaultSize * numberOfStacks];
        stackCapacity = defaultSize;
        sizes = new int[numberOfStacks];
    }

    public void push(int stackNumber, int value) {
        if (isFull(stackNumber)) {
            throw new FullStackException();
        }
        sizes[stackNumber]++;
        values[indexOfTop(stackNumber)] = value;
    }

    public int pop(int stackNumber) {
        if (isEmpty(stackNumber)) {
            throw new EmptyStackException();
        }

        int value = values[indexOfTop(stackNumber)];
        sizes[stackNumber]--;
        return value;
    }

    public int peek(int stackNumber) {
        if (isEmpty(stackNumber)) {
            throw new EmptyStackException();
        }

        return values[indexOfTop(stackNumber)];
    }

    public boolean isFull(int stackNumber) {
        return sizes[stackNumber] == stackCapacity;
    }

    public boolean isEmpty(int stackNumber) {
        return sizes[stackNumber] == 0;
    }

    private int indexOfTop(int stackNumber) {
        return stackNumber * stackCapacity + sizes[stackNumber] - 1;
    }
}
