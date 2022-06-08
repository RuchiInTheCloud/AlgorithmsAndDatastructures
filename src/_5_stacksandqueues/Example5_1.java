package _5_stacksandqueues;

import _5_stacksandqueues.datastructures.SortedStack;
import _5_stacksandqueues.datastructures.Stack;

//Sort a stack using an additional stack
//If original stack is s, sortedStack is sortS
//Pop an element from s, save in temp variable
//Pop elements from sortS until top(sortS) > temp, push the popped elements into s
//Repeat above two steps until s is empty
public class Example5_1 {
    public static void main(String[] args) {
        SortedStack stack = new SortedStack(10);
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println("Stack before sorting: " + stack);

        Stack<Integer> sortedStack = stack.sort();

        System.out.println("Stack after sorting: " + sortedStack);
    }
}
