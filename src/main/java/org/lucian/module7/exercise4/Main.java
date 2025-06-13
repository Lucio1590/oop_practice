package org.lucian.module7.exercise4;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread[] threads = new Thread[100];

        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
        }
        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();

        System.out.println("Final count (with synchronized): " + counter.getCount());

        // Uncomment below to test without synchronized (remove 'synchronized' from increment() in Counter)
        // Counter unsafeCounter = new Counter() {
        //     @Override
        //     public void increment() { count++; }
        // };
        // Thread[] threads2 = new Thread[100];
        // for (int i = 0; i < 100; i++) {
        //     threads2[i] = new Thread(() -> {
        //         for (int j = 0; j < 1000; j++) {
        //             unsafeCounter.increment();
        //         }
        //     });
        // }
        // for (Thread t : threads2) t.start();
        // for (Thread t : threads2) t.join();
        // System.out.println("Final count (without synchronized): " + unsafeCounter.getCount());
    }
}
