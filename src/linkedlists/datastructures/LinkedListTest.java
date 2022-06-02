package linkedlists.datastructures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedListTest {
    @Test
    public void testStringBuilder() {
        LinkedList myLinkedList = new LinkedList();
        myLinkedList.append("USA");
        myLinkedList.append("Nepal");

        assertEquals(myLinkedList.toString(), "USANepalIndiaAustraliaGermany");
    }
}
