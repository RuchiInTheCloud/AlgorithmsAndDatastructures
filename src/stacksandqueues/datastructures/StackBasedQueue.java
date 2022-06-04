package stacksandqueues.datastructures;

public class StackBasedQueue {
    Stack<Integer> stackOldest;
    Stack<Integer> stackNewest;

    public StackBasedQueue(int capacity) {
        stackOldest = new Stack<>(capacity);
        stackNewest = new Stack<>(capacity);
    }

    public void add(Integer data) {
        stackNewest.push(data);
    }

    public Stack.Node<Integer> remove() {
        shiftStacks();
        return stackOldest.pop();
    }

    private void shiftStacks() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                Integer oldData = stackNewest.pop().data;
                stackOldest.push(oldData);
            }
        }
    }
}
