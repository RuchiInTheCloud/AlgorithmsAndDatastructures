package linkedlists.datastructures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedListTest {
    @Test
    public void testLinkedList() {
        LinkedList<String> myLinkedList = new LinkedList();
        myLinkedList.appendToTail("USA");
        myLinkedList.appendToTail("Nepal");
        assertEquals(myLinkedList.string(), "USA Nepal ");

        myLinkedList.deleteNode("USA");
        assertEquals(myLinkedList.string(), "Nepal ");
    }
}
