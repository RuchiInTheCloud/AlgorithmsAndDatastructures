package stacksandqueues;

public class Example1_2 {
    static class MultiStack {
        static class StackInfo {
            int start;
            int capacity;
            int size;

            StackInfo(int start, int capacity) {
                this.start = start;
                this.capacity = capacity;
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
        }

        int pop(int stackNumber) {
        }

        int peek(int stackNumber) {
        }

        boolean isFull(int stackNumber) {
        }

        boolean isEmpty(int stackNumber) {
        }
    }

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
    }
}
