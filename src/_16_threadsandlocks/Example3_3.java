package _16_threadsandlocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Chopsticks 0 1 2 3 ... N-1 <-> 0
//Philosopher picks left(smaller) before right(larger)
//Except last philosopher who picks right(=0 lower) before left(=N-1 larger)
//A philosopher with this approach can never hold a larger chopstick without holding the smaller one
//cycle means higher chopstick points to a lower one
public class Example3_3 {
    private static class Chopstick {
        private Lock lock;
        private int number;

        public Chopstick(int n) {
            lock = new ReentrantLock();
            number = n;
        }

        public void pickUp() {
            lock.lock();
        }

        public void putDown() {
            lock.unlock();
        }

        public int getNumber() {
            return number;
        }
    }

    private static class Philosopher extends Thread {
        private int bites = 10;
        private Chopstick lower, higher;
        private int index;

        public Philosopher(int i, Chopstick left, Chopstick right) {
            index = i;
            if (left.getNumber() < right.getNumber()) {
                this.lower = left;
                this.higher = right;
            } else {
                this.lower = right;
                this.higher = left;
            }
        }

        public void eat() {
            pickUp();
            chew();
            putdown();
        }

        public void pickUp() {
            lower.pickUp();
            higher.pickUp();
        }

        public void chew() {
        }

        public void putdown() {
            higher.putDown();
            lower.putDown();
        }

        public void run() {
            for (int i = 0; i < bites; i++) {
                eat();
            }
        }
    }
}
