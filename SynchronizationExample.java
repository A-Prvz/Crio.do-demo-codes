class MyRunnable implements Runnable {
    private static int counter = 0;

    public void run() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                counter++;
                System.out.println(Thread.currentThread().getName() + " Counter: " + counter);
            }
        }

    }
}

public class SynchronizationExample {
    public static void main(String[] args) {
        {
            Runnable myRunnable = new MyRunnable();
            Thread thread1 = new Thread(myRunnable);
            Thread thread2 = new Thread(myRunnable);

            thread1.start();
            thread2.start();
        }
    }
}