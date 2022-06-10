package _8_mathandlogicpuzzles.datastructures;

public class Primes {
    public static boolean[] sieveOfEratosthenes(int max) {
        boolean[] flags = new boolean[max + 1];
        init(flags);
        int prime = 2;
        while (prime <= Math.sqrt(max)) {
            crossOf(flags, prime);
            prime = getNextPrime(flags, prime);
        }
        return flags;
    }

    private static void crossOf(boolean[] flags, int prime) {
        for (int i = prime * prime; i < flags.length; i += prime) {
            flags[i] = false;
        }
    }

    private static int getNextPrime(boolean[] flags, int prime) {
        prime = prime + 1;
        while (prime < flags.length && !flags[prime]) {
            prime += 1;
        }
        return prime;
    }

    private static void init(boolean[] flags) {
        for (int i = 2; i < flags.length; i++) {
            flags[i] = true;
        }
    }
}
