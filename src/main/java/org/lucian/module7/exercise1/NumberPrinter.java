package org.lucian.module7.exercise1;

/**
 * NumberPrinter extends Thread and prints numbers from 1 to 10 with a delay.
 */
public class NumberPrinter extends Thread {
    private final String threadName;

    public NumberPrinter(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(threadName + ": " + i);
            try {
                int delay = 100 + (int)(Math.random() * 401); // random between 100 and 500 ms
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.err.println(threadName + " interrupted");
            }
        }
    }
}
