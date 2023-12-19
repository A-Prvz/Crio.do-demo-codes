import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadOverheadDemo {
    private static final int ARRAY_SIZE = 100000000; // 100 million elements
    private static final int THREAD_POOL_SIZE = Runtime.getRuntime().availableProcessors();
    // Use available CPU cores

    private static int[] array = new int[ARRAY_SIZE];

    public static void main(String[] args) {
        // Initialize the array with random values
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = i;
        }

        // Measure execution time with optimal thread count
        long optimalStartTime = System.currentTimeMillis();
        calculateSumWithThreads(THREAD_POOL_SIZE);
        long optimalExecutionTime = System.currentTimeMillis() - optimalStartTime;

        // Measure execution time with excessive thread count
        int excessiveThreadCount = THREAD_POOL_SIZE * 4; // Using 4x the available cores
        long excessiveStartTime = System.currentTimeMillis();
        calculateSumWithThreads(excessiveThreadCount);
        long excessiveExecutionTime = System.currentTimeMillis() - excessiveStartTime;

        // Print results
        System.out.println("Optimal Thread Count Execution Time: " + optimalExecutionTime + " milliseconds");
        System.out.println("Excessive Thread Count Execution Time: " + excessiveExecutionTime + " milliseconds");
    }

    private static void calculateSumWithThreads(int threadCount) {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        int segmentSize = ARRAY_SIZE / threadCount;

        try {
            for (int i = 0; i < threadCount; i++) {
                int startIndex = i * segmentSize;
                int endIndex = (i == threadCount - 1) ? ARRAY_SIZE : (i + 1) * segmentSize;

                executorService.submit(() -> {
                    int localSum = 0;
                    for (int j = startIndex; j < endIndex; j++) {
                        localSum += array[j];
                    }
                    // In a real application, we can aggregate the local sums appropriately.
                });
            }
        } finally {
            executorService.shutdown();
        }
    }
}
