package _16_threadsandlocks.fundamentals;

public class ThreadTest {
    private static class ThreadExample extends Thread {
        public int count = 0;

        @Override
        public void run() {
            System.out.println("Thread starting.");
            try {
                while (count < 5) {
                    Thread.sleep(500);
                    count++;
                }
            } catch (InterruptedException ex) {
                System.out.println("Thread interrupted.");
            }
            System.out.println("Thread terminating.");
        }
    }

    public static void main(String[] args) {
        ThreadExample instance = new ThreadExample();
        instance.start();

        while (instance.count != 5) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }
    }
}
