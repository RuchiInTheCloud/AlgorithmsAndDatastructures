package _5_stacksandqueues.datastructures;

public class StackWithContiguousMin extends Stack<NodeWithMin> {
    public StackWithContiguousMin(int capacity) {
        super(capacity);
    }

    public void push(int value) {
        int newMin = Math.min(min(), value);
        NodeWithMin nodeWithMin = new NodeWithMin(value, newMin);
        super.push(nodeWithMin);
    }

    public int min() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE;
        }

        return peek().data.min;
    }
}

class NodeWithMin {
    int value;
    int min;

    NodeWithMin(int value, int min) {
        this.value = value;
        this.min = min;
    }
}
