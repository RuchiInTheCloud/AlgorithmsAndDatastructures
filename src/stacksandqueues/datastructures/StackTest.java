package stacksandqueues.datastructures;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
    @Test
    public void testStack() {
        Stack<String> myStack = new Stack<>();
        assertTrue(myStack.isEmpty());

        myStack.push("USA");
        myStack.push("Nepal");

        assertEquals(myStack.peek().data, "Nepal");
        assertEquals(myStack.pop().data, "Nepal");

        assertFalse(myStack.isEmpty());
    }
}
