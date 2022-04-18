package arraysandstrings;

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

        assertNotNull(myMap);
        assertEquals(4, myMap.size());
        assertEquals("Kathmandu", myMap.get("Nepal"));
        assertEquals("Sydney", myMap.get("Australia"));
    }
}