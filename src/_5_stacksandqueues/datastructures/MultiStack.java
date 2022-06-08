package _5_stacksandqueues.datastructures;

import java.util.EmptyStackException;

public class MultiStack {
    class StackInfo {
        private int start;
        private int capacity;
        private int size;

        StackInfo(int start, int capacity) {
            this.start = start;
            this.capacity = capacity;
        }

        public boolean isIndexWithinStackCapacity(int index) {
            int contiguousIndex = index < start ? index + values.length : index;
            int end = start + capacity;
            return start <= contiguousIndex && contiguousIndex < end;
        }

        public int lastElementIndex() {
            return adjustIndex(start + size - 1);
        }

        public int lastCapacityIndex() {
            return adjustIndex(start + capacity - 1);
        }

        public boolean isFull() {
            return size == capacity;
        }

        boolean isEmpty() {
            return size == 0;
        }
    }

    private int[] values;
    private MultiStack.StackInfo[] stackInfos;

    public MultiStack(int numberOfStacks, int defaultSize) {
        values = new int[defaultSize * numberOfStacks];
        stackInfos = new MultiStack.StackInfo[numberOfStacks];
        for (int i = 0; i < numberOfStacks; i++) {
            stackInfos[i] = new MultiStack.StackInfo(i * defaultSize, defaultSize);
        }
    }

    public void push(int stackNumber, int value) {
        if (allStacksFull()) {
            throw new FullStackException();
        }

        if (stackInfos[stackNumber].isFull()) {
            expand(stackNumber);
        }

        stackInfos[stackNumber].size++;
        values[stackInfos[stackNumber].lastElementIndex()] = value;
    }

    public int pop(int stackNumber) {
        if (stackInfos[stackNumber].isEmpty()) {
            throw new EmptyStackException();
        }
        int value = values[stackInfos[stackNumber].lastElementIndex()];
        values[stackInfos[stackNumber].lastElementIndex()] = 0;
        stackInfos[stackNumber].size--;
        return value;
    }

    public int peek(int stackNumber) {
        if (stackInfos[stackNumber].isEmpty()) {
            throw new EmptyStackException();
        }
        return values[stackInfos[stackNumber].lastElementIndex()];
    }

    public boolean isEmpty(int stackNumber) {
        return stackInfos[stackNumber].isEmpty();
    }

    public boolean isFull(int stackNumber) {
        return stackInfos[stackNumber].isFull();
    }

    private void expand(int stackNumber) {
        shift((stackNumber + 1) % stackInfos.length);
        stackInfos[stackNumber].capacity++;
    }

    private void shift(int stackNumber) {
        MultiStack.StackInfo stack = stackInfos[stackNumber];
        if (stack.isFull()) {
            shift((stackNumber + 1) % stackInfos.length);
            stack.capacity++;
        }

        int index = stack.lastCapacityIndex();
        while (stack.isIndexWithinStackCapacity(index)) {
            values[index] = values[previousIndex(index)];
            index = previousIndex(index);
        }

        values[stack.start] = 0;
        stack.start = nextIndex(stack.start);
        stack.capacity--;
    }

    private boolean allStacksFull() {
        return numberOfElements() == values.length;
    }

    private int numberOfElements() {
        int numberOfElements = 0;
        for (MultiStack.StackInfo stackInfo : stackInfos) {
            numberOfElements += stackInfo.size;
        }
        return numberOfElements;
    }

    private int nextIndex(int index) {
        return adjustIndex(index + 1);
    }

    private int previousIndex(int index) {
        return adjustIndex(index - 1);
    }

    private int adjustIndex(int index) {
        return (index % values.length + values.length) % values.length;
    }
}
