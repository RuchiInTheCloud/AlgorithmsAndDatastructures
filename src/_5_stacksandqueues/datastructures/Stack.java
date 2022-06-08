package _5_stacksandqueues.datastructures;

import java.util.EmptyStackException;

public class Stack<T> {
    public static class Node<T> {
        public T data;
        public Node<T> below;
        public Node<T> above;

        public Node(T data) {
            this.data = data;
        }
    }

    public Node<T> top;
    public Node<T> bottom;

    protected int capacity;
    protected int size = 0;

    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public boolean push(T data) {
        if (size == capacity) {
            return false;
        }

        Node<T> node = new Node<>(data);

        if (top == null) {
            bottom = node;
        } else {
            top.above = node;
            node.below = top;
        }

        top = node;
        size++;

        return true;
    }

    public Node<T> peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top;
    }

    public Node<T> pop() {
        if (top == null) {
            throw new EmptyStackException();
        }

        Node<T> node = top;
        top = top.below;

        if (top == null) {
            bottom = null;
        } else {
            top.above = null;
            node.below = null;
        }

        size--;
        return node;
    }

    public Node<T> removeBottom() {
        if (bottom == null) {
            return null;
        }

        Node<T> node = bottom;
        bottom = bottom.above;

        if (bottom != null) {
            bottom.below = null;
        } else {
            top = null;
        }

        size--;

        return node;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        Stack.Node<T> current = top;
        while (current != null) {
            string.append(current.data.toString()).append(" ");
            current = current.below;
        }
        return string.toString();
    }
}
