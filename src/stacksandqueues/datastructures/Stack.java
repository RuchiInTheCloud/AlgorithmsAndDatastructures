package stacksandqueues.datastructures;

import java.util.EmptyStackException;

public class Stack<T> {
    public static class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public Node<T> top;

    public void push(T data) {
        Node<T> node = new Node<>(data);
        node.next = top;
        top = node;
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
        top = top.next;
        return node;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
