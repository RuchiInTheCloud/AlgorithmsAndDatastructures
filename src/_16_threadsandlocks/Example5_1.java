package _16_threadsandlocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Consider the FooBad class below
//The same instance of this class is passed to three different threads. ThreadA will call first
//ThreadB will call second, Thread C will call third
//Design a mechanism to ensure that first is called before second that is called before third.
//The code below does not work due to lock ownership.
//"""One thread is performing the lock while different threads attempt to unlock the locks"""
//This is not allowed and your code will raise an exception
//A lock in java is owned by the thread which locked it
//Instead we can replicate this behavior with Semaphores
public class Example5_1 {
    private static class FooBad {
        public int pauseTime = 1000;
        public Lock lock1, lock2;

        public FooBad() {
            try {
                lock1 = new ReentrantLock();
                lock2 = new ReentrantLock();

                lock1.lock();
                lock2.lock();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        public void first() {
            try {
                System.out.println("Started Executing 1");
                Thread.sleep(pauseTime);
                System.out.println("Finished Executing 1");
                lock1.unlock();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        public void second() {
            try {
                lock1.lock();
                lock1.unlock();
                System.out.println("Started Executing 2");
                Thread.sleep(pauseTime);
                System.out.println("Finished Executing 2");
                lock2.unlock();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        public void third() {
            try {
                lock2.lock();
                lock2.unlock();
                System.out.println("Started Executing 3");
                Thread.sleep(pauseTime);
                System.out.println("Finished Executing 3");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private static class MyThread extends Thread {
        private String method;
        private FooBad foo;

        public MyThread(FooBad foo, String method) {
            this.method = method;
            this.foo = foo;
        }

        public void run() {
            if (method == "first") {
                foo.first();
            } else if (method == "second") {
                foo.second();
            } else if (method == "third") {
                foo.third();
            }
        }
    }

    public static void main(String[] args) {
        FooBad foo = new FooBad();

        MyThread thread1 = new MyThread(foo, "first");
        MyThread thread2 = new MyThread(foo, "second");
        MyThread thread3 = new MyThread(foo, "third");

        thread3.start();
        thread2.start();
        thread1.start();
    }
}
