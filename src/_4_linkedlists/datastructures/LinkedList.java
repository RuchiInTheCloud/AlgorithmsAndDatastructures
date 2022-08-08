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

        public static <T> Node createNode(T data) {
            return new Node(data);
        }
    }

    public Node<T> head;
    private int size = 0;

    public void addFront(T data) {
        Node<T> node = new Node(data);
        addFront(node);
    }

    public void addFront(Node<T> node) {
        node.next = head;
        head = node;
        size++;
    }

    public void addLast(T data) {
        Node<T> end = new Node(data);
        addLast(end);
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

    public void add(int index, T data) {
        Node<T> toInsert = new Node<>(data);

        if (index == 0) {
            toInsert.next = head;
            head = toInsert;
        } else {
            Node<T> current = head;
            int currentPosition = 0;
            while (currentPosition < index - 1) {
                current = current.next;
                currentPosition += 1;
            }
            toInsert.next = current.next;
            current.next = toInsert;
        }
        size++;
    }

    public T get(int index) {
        Node<T> current = head;
        int currentPosition = 0;
        while (currentPosition < index) {
            current = current.next;
            currentPosition += 1;
        }
        return current.data;
    }

    public Node<T> removeFront() {
        if (head == null) {
            throw new EmptyStackException();
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
            head = null;
            size--;
            return current;
        } else {
            Node<T> prev = head;
            Node<T> current = head;
            while (current.next != null) {
                prev = current;
                current = current.next;
            }
            prev.next = null;
            size--;
            return current;
        }
    }

    //Example data located on head, tail or middle <--- does not remove all occurences
    public Node<T> removeNode(T data) {
        if (head == null) {
            return null;
        }

        Node<T> returnValue = null;
        if (head.data == data) {
            returnValue = head;
            head = head.next;
            size--;
        }

        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                returnValue = current.next;
                returnValue.next = null;
                current.next = current.next.next;
                size--;
                break;
            } else {
                current = current.next;
            }
        }

        return returnValue;
    }

    public Node<T> poll() {
        return removeFront();
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

    public boolean isEmpty() {
        return head == null || size == 0;
    }
}
