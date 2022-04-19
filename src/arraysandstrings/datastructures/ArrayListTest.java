package arraysandstrings.datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest {
    @Test
    public void testArrayList() {
        ArrayList<String> myList = new ArrayList<>();
        myList.add("USA");
        myList.add("Nepal");
        myList.add("India");
        myList.add("Australia");
        myList.add("Germany");

        assertNotNull(myList);
        assertEquals(5, myList.size());
        assertEquals(8, myList.capacity());
        assertEquals("Nepal", myList.get(1));
        assertEquals("Australia", myList.get(3));
        assertEquals("Germany", myList.get(4));
    }
}
