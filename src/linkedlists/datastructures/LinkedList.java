package linkedlists.datastructures;

// LinkedList of integer or string
public class LinkedList<T> {
    public class Node {
        public T data;
        public Node next;

        public Node(T data) {
            this.data = data;
        }
    }

    public Node head;

    public void appendToTail(T data) {
        Node end = new Node(data);
        if (head == null) {
            head = end;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = end;
        }
    }

    //Example data located on head, tail or middle
    public Node deleteNode(T data) {
        if (head == null) {
            return null;
        }

        Node current = head;
        if (head.data == data) {
            head = head.next;
            return current;
        }

        Node prev = head;
        current = head.next;
        while (current.next != null) {
            if (current.data == data) {
                prev.next = current.next;
                return current;
            }
            prev = current;
            current = current.next;
        }

        if (current.data == data) {
            prev.next = current.next;
            return current;
        }

        return null;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        Node current = head;
        while (current != null) {
            string.append(current.data + " ");
            current = current.next;
        }
        return string.toString();
    }
}
