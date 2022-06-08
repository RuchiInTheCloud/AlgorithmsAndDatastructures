package _4_linkedlists.datastructures;

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

    public void addFront(Node<T> node) {
        node.next = head;
        head = node;
        size++;
    }

    public void addLast(T data) {
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

    public void addLast(Node<T> node) {
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

    public void addAll(LinkedList<T> list) {
        Node<T> current = list.head;

        while (current != null) {
            Node<T> node = new Node<>(current.data);
            this.addLast(node);

            current = current.next;
        }
    }

    public Node<T> removeFront() {
        if (head == null) {
            return null;
        }

        Node<T> current = head;
        head = head.next;
        size--;
        return current;
    }

    public Node<T> removeLast() {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            Node<T> current = head;
            head = head.next;
            size--;
            return current;
        } else {
            Node<T> prev = head;
            Node<T> current = head.next;
            while (current.next != null) {
                prev = current;
                current = current.next;
            }
            prev.next = current.next;
            size--;
            return current;
        }
    }

    //Example data located on head, tail or middle
    public Node<T> removeNode(T data) {
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
            string.append(current.data.toString()).append(" ");
            current = current.next;
        }
        return string.toString();
    }

    public int size() {
        return size;
    }
}
