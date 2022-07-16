package _16_threadsandlocks.fundamentals;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    private static class LockedATM {
        private Lock lock;
        private int balance = 100;

        public LockedATM() {
            this.lock = new ReentrantLock();
        }

        public int withdraw(int value) {
            lock.lock();
            int temp = balance;
            try {
                Thread.sleep(100);
                temp = temp - value;
                Thread.sleep(100);
                balance = temp;
            } catch (InterruptedException e) {
            }
            lock.unlock();
            return temp;
        }

        public int deposit(int value) {
            lock.lock();
            int temp = balance;
            try {
                Thread.sleep(1000);
                temp = temp + value;
                Thread.sleep(1000);
                balance = temp;
            } catch (InterruptedException e) {
            }
            lock.unlock();
            return temp;
        }
    }

    public static void main(String[] args) {
        LockedATM lockedATM = new LockedATM();
        int balance;
        balance = lockedATM.deposit(10);
        System.out.println(balance);
        balance = lockedATM.withdraw(10);
        System.out.println(balance);
    }
}
