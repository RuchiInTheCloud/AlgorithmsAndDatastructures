package _5_stacksandqueues;

import _5_stacksandqueues.datastructures.StackWithMinStack;

//Implement a stack with min method that returns the smallest element in the stack at a given time and operates in O(1) complexity
//Example: 5, 6, 3, 7 --> min 3
//         5, 6 --> min 5
//Brute force: Since min keeps changing depending on the content in the stack, push new min into separate stack whenever data is pushed
//When stack is popped, pop from min Stack if a min was popped from original stack
//Complexity: O(n) in space
public class Example2_2 {
    public static void main(String[] args) {
        StackWithMinStack stackWithMin = new StackWithMinStack(10);
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

