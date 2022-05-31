package arraysandstrings.datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class HashTableTest {
    @Test
    public void testHashTable() {
        HashTable<String, String> myMap = new HashTable<>();
        myMap.put("USA", "Washington DC");
        myMap.put("Nepal", "Kathmandu");
        myMap.put("India", "New Delhi");
        myMap.put("Australia", "Sydney");
        myMap.put("Germany", "Berlin");

        assertNotNull(myMap);
        assertEquals(5, myMap.size());
        assertEquals(8, myMap.capacity());
        assertEquals("Kathmandu", myMap.get("Nepal"));
        assertEquals("Sydney", myMap.get("Australia"));
        assertEquals("Berlin", myMap.get("Germany"));
    }
}