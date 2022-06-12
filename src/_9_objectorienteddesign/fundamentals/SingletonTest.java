package _9_objectorienteddesign.fundamentals;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingletonTest {
    @Test
    public void testSingleton() {
        Restaurant restaurant1 = Restaurant.getInstance();
        Restaurant restaurant2 = Restaurant.getInstance();
        assertEquals(restaurant1, restaurant2);
    }
}