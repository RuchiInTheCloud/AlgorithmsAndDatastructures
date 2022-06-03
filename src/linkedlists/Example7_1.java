package linkedlists;

import linkedlists.datastructures.LinkedList;

//Find intersecting node, if two lists intersect
//Example: 3 -> 1 -> 5 -> 9 -> 7 -> 2 -> 1
//                   4 -> 6 -> |
//Example: null, 3 -> 1 -> 5 -> 9 -> 7 -> 2 -> 1
//Brute force:
//node findIntersection(node, node)
// if node1 || node2 is null return false
// len1, tail = length(node1)
// len2, tail = length(node2)
// if tails not equal return false
// len1 > len2: move pointer by len1 - len2 nodes in list node1
// len1 <= len2: move pointer by len2 - len1 nodes in list node2
// while (node1 != node2) move both pointers to the next elem
// return node1
//Complexity: O(A + B) in time
//Optimize: BCR
//Test: Complexity is wrong the difference in list size not taken into account
//Check your conditionals
//Adding a linkedlist to another list, may cause circular references
public class Example7_1 {
    static class Result {
        LinkedList.Node<Integer> tail;
        int length;

        Result(LinkedList.Node<Integer> tail, int length) {
            this.tail = tail;
            this.length = length;
        }
    }

    static LinkedList.Node<Integer> findIntersection(LinkedList.Node<Integer> node1, LinkedList.Node<Integer> node2) {
        if (node1 == null || node2 == null) {
            return null;
        }
        Result result1 = length(node1);
        Result result2 = length(node2);

        LinkedList.Node<Integer> smaller = result1.length < result2.length ? node1 : node2;
        LinkedList.Node<Integer> larger = result1.length >= result2.length ? node1 : node2;

        larger = getKthNode(larger, Math.abs(result1.length - result2.length));

        while (smaller != larger) {
            smaller = smaller.next;
            larger = larger.next;
        }

        return smaller;
    }

    private static LinkedList.Node<Integer> getKthNode(LinkedList.Node<Integer> node, int k) {
        for (int i = 0; i < k; i++) {
            node = node.next;
        }
        return node;
    }

    private static Result length(LinkedList.Node<Integer> node) {
        int length = 1;
        while (node.next != null) {
            length++;
            node = node.next;
        }
        return new Result(node, length);
    }

    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.appendToTail(3);
        list1.appendToTail(1);
        list1.appendToTail(5);
        list1.appendToTail(9);
        list1.appendToTail(7);
        list1.appendToTail(2);
        list1.appendToTail(1);

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.appendToTail(4);
        list2.appendToTail(6);
        list2.appendToTail(list1.head.next.next.next.next);

        LinkedList<Integer> intersection = new LinkedList<>();
        intersection.head = findIntersection(list1.head, list2.head);

        System.out.println("Intersecting node is: " + intersection.head.data);
    }
}
