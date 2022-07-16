package _16_threadsandlocks.fundamentals;

public class StaticSynchronizedMethodTest {
    public static class MyClass extends Thread {
        private String name;

        public MyClass(String n) {
            this.name = n;
        }

        @Override
        public void run() {
            if (name.equals("1")) {
                MyObject.foo(name);
            } else if (name.equals("2")) {
                MyObject.bar(name);
            }
        }
    }

    private static class MyObject {
        public static synchronized void foo(String name) {
            try {
                System.out.println("Thread " + name + ".foo(): starting");
                Thread.sleep(3000);
                System.out.println("Thread " + name + ".foo() ending.");
            } catch (InterruptedException exc) {
                System.out.println("Thread " + name + ": interrupted.");
            }
        }

        public static synchronized void bar(String name) {
            try {
                System.out.println("Thread " + name + ".bar(): starting");
                Thread.sleep(3000);
                System.out.println("Thread " + name + ".bar() ending.");
            } catch (InterruptedException exc) {
                System.out.println("Thread " + name + ": interrupted.");
            }
        }
    }

    public static void main(String[] args) {
        MyClass thread1 = new MyClass("1");
        MyClass thread2 = new MyClass("2");
        thread1.start();
        thread2.start();
    }
}
