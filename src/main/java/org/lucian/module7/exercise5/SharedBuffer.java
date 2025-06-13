package org.lucian.module7.exercise5;

import java.util.LinkedList;
import java.util.List;

/**
 * SharedBuffer implements a simple producer-consumer buffer with wait/notify.
 */
public class SharedBuffer {
    private final List<Integer> buffer = new LinkedList<>();
    private int nextValue = 1;

    public synchronized void produce() throws InterruptedException {
        buffer.add(nextValue);
        System.out.println("[Producer] Produced: " + nextValue + " | Buffer: " + buffer);
        nextValue++;
        notify(); // Wake up consumer if waiting
    }

    public synchronized void consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            System.out.println("[Consumer] Buffer empty, waiting...");
            wait();
        }
        int value = buffer.remove(0);
        System.out.println("[Consumer] Consumed: " + value + " | Buffer: " + buffer);
    }
}
