package _16_threadsandlocks.fundamentals;

public class RunnableTest {
    private static class RunnableThreadExample implements Runnable {
        public int count = 0;

        @Override
        public void run() {
            System.out.println("Runnable thread starting.");
            try {
                while (count < 5) {
                    Thread.sleep(500);
                    count++;
                }
            } catch (InterruptedException ex) {
                System.out.println("Runnable Thread interrupted.");
            }
            System.out.println("Runnable Thread terminating.");
        }
    }

    public static void main(String[] args) {
        RunnableThreadExample instance = new RunnableThreadExample();
        Thread thread = new Thread(instance);
        thread.start();

        while (instance.count != 5) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }
    }
}
