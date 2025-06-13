package org.lucian.module7.exercise4;

/**
 * Counter with a synchronized increment method for thread safety.
 */
public class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
