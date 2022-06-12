package _7_bitmanipulation.fundamentals;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BitManipulationTest {
    @Test
    public void testMaskCreation() {
        assertEquals(1 << 0, 1);
        assertEquals(-1 >>> 0, -1);
        //01000 --> 10111
        //01001 --> 00110 --> 00111 --> 10111
        assertEquals(~8, -9);
    }
}
