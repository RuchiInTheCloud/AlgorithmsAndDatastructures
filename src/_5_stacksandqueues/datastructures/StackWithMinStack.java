package _5_stacksandqueues.datastructures;

public class StackWithMinStack extends Stack<Integer> {
    Stack<Integer> minStack;

    public StackWithMinStack(int capacity) {
        super(capacity);
        minStack = new Stack<>(capacity);
    }

    public boolean push(Integer data) {
        if (data < min()) {
            minStack.push(data);
        }
        return super.push(data);
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
