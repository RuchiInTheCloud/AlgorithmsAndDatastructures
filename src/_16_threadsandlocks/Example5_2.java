package _16_threadsandlocks;

import java.util.concurrent.Semaphore;

public class Example5_2 {
    private static class FooBad {
        public int pauseTime = 1000;

        public Semaphore sem1, sem2;

        public FooBad() {
            sem1 = new Semaphore(1);
            sem2 = new Semaphore(1);
            try {
                sem1.acquire();
                sem2.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public void first() {
            try {
                System.out.println("Started Executing 1");
                Thread.sleep(pauseTime);
                System.out.println("Finished Executing 1");

                sem1.release();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        public void second() {
            try {
                sem1.acquire();
                sem1.release();

                System.out.println("Started Executing 2");
                Thread.sleep(pauseTime);
                System.out.println("Finished Executing 2");

                sem2.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public void third() {
            try {
                sem2.acquire();
                sem2.release();

                System.out.println("Started Executing 3");
                Thread.sleep(pauseTime);
                System.out.println("Finished Executing 3");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
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
