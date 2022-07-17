package _16_threadsandlocks;

import _16_threadsandlocks.example7_1.FizzBuzzThread;
import _16_threadsandlocks.example7_1.NumberThread;

public class Example7_2 {
    public static void main(String[] args) {
        int n = 100;
        Thread[] threads = {new FizzBuzzThread(true, true, n, "FizzBuzz"), new FizzBuzzThread(true, false, n, "Fizz"),
                new FizzBuzzThread(false, true, n, "Buzz"), new NumberThread(false, false, n)};
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
