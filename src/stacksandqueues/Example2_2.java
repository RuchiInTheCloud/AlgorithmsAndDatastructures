package stacksandqueues;

import stacksandqueues.datastructures.Stack;

public class Example2_2 {
    public static void main(String[] args) {
        StackWithMinStack stackWithMin = new StackWithMinStack();
        stackWithMin.push(5);
        stackWithMin.push(6);
        stackWithMin.push(3);
        stackWithMin.push(7);

        System.out.println("Minimum of stack: " + stackWithMin.min());

        stackWithMin.pop();
        stackWithMin.pop();

        System.out.println("Minimum of stack: " + stackWithMin.min());
    }
}

class StackWithMinStack extends Stack<Integer> {
    Stack<Integer> minStack = new Stack<>();

    public void push(Integer data) {
        if (data < min()) {
            minStack.push(data);
        }
        super.push(data);
    }

    public Node<Integer> pop() {
        if (super.peek().data <= min()) {
            minStack.pop();
        }
        return super.pop();
    }

    public Integer min() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE;
        }

        return minStack.peek().data;
    }
}
