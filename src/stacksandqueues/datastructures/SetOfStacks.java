package stacksandqueues.datastructures;

import arraysandstrings.datastructures.ArrayList;

import java.util.EmptyStackException;

public class SetOfStacks {
    private ArrayList<Stack<Integer>> stacks = new ArrayList<>();
    private int capacity;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public void push(Integer data) {
        Stack<Integer> stack = getLastStack();
        if (stack == null || stack.isFull()) {
            stack = new Stack<>(capacity);
            stacks.add(stack);
        }
        stack.push(data);
    }

    public Stack.Node<Integer> pop() {
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

    public Stack.Node<Integer> popAt(int index) {
        return leftShift(index, true);
    }

    public Stack.Node<Integer> peek() {
        Stack<Integer> stack = getLastStack();
        if (stack == null || stack.isEmpty()) {
            throw new EmptyStackException();
        }

        return stack.peek();
    }

    public boolean isEmpty() {
        Stack<Integer> stack = getLastStack();
        return stack == null || stack.isEmpty();
    }

    public int getStackCount() {
        return stacks.size();
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

    private Stack<Integer> getLastStack() {
        if (stacks.size() == 0) {
            return null;
        }
        return stacks.get(stacks.size() - 1);
    }
}
