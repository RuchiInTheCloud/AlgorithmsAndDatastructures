package linkedlists.datastructures;

import java.util.EmptyStackException;

// LinkedList of integer or string
public class LinkedList<T> {
    public static class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public static <T> Node<T> createNode(T data) {
            return new Node<>(data);
        }
    }

    public Node<T> head;
    private int size = 0;

    public void appendToTail(T data) {
        Node<T> end = new Node<>(data);
        if (head == null) {
            head = end;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = end;
        }
        size++;
    }

    public void appendToTail(Node<T> node) {
        if (head == null) {
            head = node;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        size++;
    }

    //Example data located on head, tail or middle
    public Node<T> deleteNode(T data) {
        if (head == null) {
            return null;
        }

        Node<T> current = head;
        if (current.data == data) {
            head = head.next;
            size--;
            return current;
        }

        Node<T> prev = head;
        current = head.next;
        while (current != null) {
            if (current.data == data) {
                prev.next = current.next;
                size--;
                return current;
            }
            prev = current;
            current = current.next;
        }

        return null;
    }

    public Node<T> poll() {
        if (head == null) {
            throw new EmptyStackException();
        }

        Node<T> node = head;
        head = head.next;

        size--;
        return node;
    }

    public Node<T> peek() {
        if (head == null) {
            throw new EmptyStackException();
        }

        return head;
    }

    public String string() {
        StringBuilder string = new StringBuilder();
        Node<T> current = head;
        while (current != null) {
            string.append(current.data).append(" ");
            current = current.next;
        }
        return string.toString();
    }

    public int size() {
        return size;
    }
}
