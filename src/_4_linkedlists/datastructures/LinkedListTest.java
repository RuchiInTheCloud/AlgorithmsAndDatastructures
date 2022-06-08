package _4_linkedlists.datastructures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedListTest {
    @Test
    public void testLinkedList() {
        LinkedList<String> myLinkedList = new LinkedList<>();
        myLinkedList.addLast("USA");
        myLinkedList.addLast("Nepal");
        assertEquals(myLinkedList.string(), "USA Nepal ");

        myLinkedList.removeNode("USA");
        assertEquals(myLinkedList.string(), "Nepal ");
    }
}
