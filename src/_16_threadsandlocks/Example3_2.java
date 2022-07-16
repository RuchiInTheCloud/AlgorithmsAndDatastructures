package _16_threadsandlocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Put down left chopstick if right unavailable
//If all philosophers were perfectly synchronized, they could simultaneously pick up their left chopstick be unable to
//pickup the right one and put back down the left one. Only to have the process repeated again
public class Example3_2 {
    private static class Chopstick {
        private Lock lock;

        public Chopstick() {
            lock = new ReentrantLock();
        }

        public boolean pickUp() {
            return lock.tryLock();
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
            if (pickUp()) {
                chew();
                putdown();
            }
        }

        public boolean pickUp() {
            if (!left.pickUp()) {
                return false;
            }
            if (!right.pickUp()) {
                left.putDown();
                return false;
            }
            return true;
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
