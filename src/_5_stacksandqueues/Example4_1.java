package _5_stacksandqueues;

import _5_stacksandqueues.datastructures.StackBasedQueue;

//Implement a queue using two stacks
//Modify peek and pop to remove first element
//Keep 1st stack to push elements
//Use stack 2 for pop and peek: Keep it in reverse order by popping elements from stack 1 to stack 2, when stack 2 is empty
//Complexity: O(1)
public class Example4_1 {
    public static void main(String[] args) {
        StackBasedQueue stackBasedQueue = new StackBasedQueue(5);
        stackBasedQueue.add(1);
        stackBasedQueue.add(2);
        stackBasedQueue.add(3);

        System.out.println("First element of queue is " + stackBasedQueue.remove().data);

        stackBasedQueue.add(4);
        stackBasedQueue.add(5);
        System.out.println("Second element of queue is " + stackBasedQueue.remove().data);
    }
}

