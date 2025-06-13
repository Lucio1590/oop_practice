package org.lucian.module7.exercise8;

public class Main {
    public static void main(String[] args) {
        // Number of threads to test singleton behavior
        int numThreads = 5;

        Runnable task = () -> {
            // Each thread gets the singleton instance and prints its hashcode and settings
            AppConfig config = AppConfig.getInstance();
            System.out.println(Thread.currentThread().getName() + ": AppConfig instance hashCode = " + config.hashCode());
            System.out.println(Thread.currentThread().getName() + ": Settings: " + config.getAllSettings());
        };

        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(task, "Thread-" + (i + 1));
            threads[i].start();
        }

        // Wait for all threads to finish
        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
