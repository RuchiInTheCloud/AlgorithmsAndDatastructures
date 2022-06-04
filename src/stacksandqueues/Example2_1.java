package stacksandqueues;

import stacksandqueues.datastructures.Stack;

//Implement a stack with min method that returns the smallest element in the stack at a given time and operates in O(1) complexity
//Example: 5, 6, 3, 7 --> min 3
//         5, 6 --> min 5
//Brute force: Since min keeps changing depending on the content in the stack, keep track of it with every push in the node
//Complexity: O(n) in space

public class Example2_1 {
    public static void main(String[] args) {
        StackWithContiguousMin stackWithMin = new StackWithContiguousMin();
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

class StackWithContiguousMin extends Stack<NodeWithMin> {
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
    public int value;
    public int min;

    NodeWithMin(int value, int min) {
        this.value = value;
        this.min = min;
    }
}
