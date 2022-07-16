package _16_threadsandlocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Running below code may lead to deadlock if every philosopher has a left chopstick and waiting for the right one
public class Example3_1 {
    private static class Chopstick {
        private Lock lock;

        public Chopstick() {
            lock = new ReentrantLock();
        }

        public void pickUp() {
            lock.lock();
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
