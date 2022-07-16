package _16_threadsandlocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Put down left chopstick if right unavailable
public class Example3_2 {
    private static class Chopstick {
        private Lock lock;

        public Chopstick() {
            lock = new ReentrantLock();
        }

        public void pickUp() {
            lock.tryLock();
        }

        public void putDown() {
            lock.unlock();
        }
    }

    private static class Philosopher extends Thread {
        private int bites = 10;
        private Chopstick left, right;

        public Philosopher(Chopstick left, Chopstick right) {
            this.left = left;
            this.right = right;
        }

        public void eat() {
            pickUp();
            chew();
            putdown();
        }

        public void pickUp() {
            left.pickUp();
            right.pickUp();
        }

        public void chew() {
        }

        public void putdown() {
            right.putDown();
            left.putDown();
        }

        public void run() {
            for (int i = 0; i < bites; i++) {
                eat();
            }
        }
    }
}
