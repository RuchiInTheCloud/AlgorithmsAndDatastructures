package stacksandqueues;

import arraysandstrings.datastructures.ArrayList;
import stacksandqueues.datastructures.Stack;

import java.util.EmptyStackException;

//Set of stacks: When capacity is reached for a stack, create a new stack
//push: When capacity reached in last stack or last stack is null, create a new stack and insert it into the stacklist. Push data into the last stack
//pop: If last stack is null or empty, throw ex. If after popping last stack is empty remove it from the list of stacks. Return value.
//popAt: Remove element from the top of stack, if next stacks are present remove element from bottom and pass on to caller. Put the element
// received from recursive call to the top of stack
//BCR: popAt: O(number of stacks)
public class Example3_1 {
    public static void main(String[] args) {
        SetOfStacks setOfStacks = new SetOfStacks(2);
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);

        System.out.println(setOfStacks.stacks.size());

        setOfStacks.popAt(0);
        System.out.println(setOfStacks.stacks.size());
    }
}

class SetOfStacks {
    ArrayList<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();
    int capacity;

    SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    void push(Integer data) {
        Stack<Integer> stack = getLastStack();
        if (stack == null || stack.isFull()) {
            stack = new Stack<>(capacity);
            stacks.add(stack);
        }
        stack.push(data);
    }

    Stack.Node<Integer> pop() {
        Stack<Integer> stack = getLastStack();
        if (stack == null || stack.isEmpty()) {
            throw new EmptyStackException();
        }

        Stack.Node<Integer> node = stack.pop();
        if (stack.isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }
        return node;
    }

    Stack.Node<Integer> popAt(int index) {
        return leftShift(index, true);
    }

    private Stack.Node<Integer> leftShift(int index, boolean removeTop) {
        Stack<Integer> stack = stacks.get(index);

        Stack.Node<Integer> node;
        if (removeTop) {
            node = stack.pop();
        } else {
            node = stack.removeBottom();
        }

        if (stack.isEmpty()) {
            stacks.remove(index);
        } else if (index + 1 < stacks.size()) {
            Stack.Node<Integer> nextNode = leftShift(index + 1, false);
            stack.push(nextNode.data);
        }

        return node;
    }

    Stack.Node<Integer> peek() {
        Stack<Integer> stack = getLastStack();
        if (stack == null || stack.isEmpty()) {
            throw new EmptyStackException();
        }

        return stack.peek();
    }

    boolean isEmpty() {
        Stack<Integer> stack = getLastStack();
        return stack == null || stack.isEmpty();
    }

    private Stack<Integer> getLastStack() {
        if (stacks.size() == 0) {
            return null;
        }
        return stacks.get(stacks.size() - 1);
    }
}

