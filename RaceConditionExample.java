public class RaceConditionExample {

    private static int sharedCounter = 0; // Shared variable

    public static void main(String[] args) {
        // Create two threads to increment the counter

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                sharedCounter++; // Increment operation
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                sharedCounter++; // Increment operation
            }
        });

        // Start the threads
        thread1.start();
        thread2.start();

        try {
            // Wait for threads to complete
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final value of the counter
        System.out.println("Final Counter Value: " + sharedCounter);
    }
}
