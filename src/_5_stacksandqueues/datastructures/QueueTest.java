package _5_stacksandqueues.datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {
    @Test
    public void testQueue() {
        Queue<String> myQueue = new Queue<>();
        assertTrue(myQueue.isEmpty());

        myQueue.add("USA");
        myQueue.add("Nepal");

        assertEquals(myQueue.peek().data, "USA");
        assertEquals(myQueue.remove().data, "USA");

        assertFalse(myQueue.isEmpty());
    }
}
