package _8_mathandlogicpuzzles.fundamentals;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PrimesTest {
    @Test
    public void testPrimeNumberGenerator() {
        boolean[] flags = Primes.sieveOfEratosthenes(20);
        assertTrue(flags[2]);
        assertTrue(flags[3]);
        assertTrue(flags[5]);
        assertTrue(flags[7]);
        assertTrue(flags[11]);
        assertTrue(flags[13]);
        assertTrue(flags[17]);
        assertTrue(flags[19]);
    }
}
