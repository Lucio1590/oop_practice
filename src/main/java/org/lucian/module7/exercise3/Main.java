package org.lucian.module7.exercise3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 1; i <= 5; i++) {
            executor.submit(new LightweightTask(i));
        }
        executor.shutdown();
        System.out.println("All tasks submitted. Waiting for completion...");
        try {
            if (!executor.awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS)) {
                System.out.println("Forcing shutdown...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
        System.out.println("Executor shutdown complete.");
    }
}
