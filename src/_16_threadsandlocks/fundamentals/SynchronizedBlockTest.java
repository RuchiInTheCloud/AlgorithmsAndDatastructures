package _16_threadsandlocks.fundamentals;

public class SynchronizedBlockTest {
    public static class MyClass extends Thread {
        private String name;
        private MyObject myObj;

        public MyClass(MyObject obj, String n) {
            this.name = n;
            this.myObj = obj;
        }

        @Override
        public void run() {
            myObj.foo(name);
        }
    }

    private static class MyObject {
        public void foo(String name) {
            synchronized (this) {
                try {
                    System.out.println("Thread " + name + ".foo(): starting");
                    Thread.sleep(3000);
                    System.out.println("Thread " + name + ".foo() ending.");
                } catch (InterruptedException exc) {
                    System.out.println("Thread " + name + ": interrupted.");
                }
            }
        }
    }

    private static void testSynchronization(MyObject obj1, MyObject obj2, String prefix) {
        MyClass thread1 = new MyClass(obj1, prefix + "1");
        MyClass thread2 = new MyClass(obj2, prefix + "2");
        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) {
        MyObject obj1 = new MyObject();
        MyObject obj2 = new MyObject();
        testSynchronization(obj1, obj2, "Different");

        MyObject obj = new MyObject();
        testSynchronization(obj, obj, "Same");
    }
}
