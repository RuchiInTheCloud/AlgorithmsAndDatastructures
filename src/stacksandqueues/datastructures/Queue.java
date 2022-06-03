package stacksandqueues.datastructures;

import java.util.EmptyStackException;

public class Queue<T> {
    public static class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public Node<T> first;
    public Node<T> last;

    public void add(T data) {
        Node<T> node = new Node<>(data);

        if (last == null) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;
    }

    public Node<T> remove() {
        if (first == null) {
            throw new EmptyStackException();
        }

        Node<T> node = first;
        first = first.next;

        if (first == null) {
            last = null;
        }

        return node;
    }

    public Node<T> peek() {
        if (first == null) {
            throw new EmptyStackException();
        }
        return first;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
