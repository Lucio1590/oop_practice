package org.lucian.module7.exercise5;

/**
 * Producer thread: adds items to the shared buffer every second.
 */
public class Producer implements Runnable {
    private final SharedBuffer buffer;
    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run() {
        try {
            while (true) {
                buffer.produce();
                Thread.sleep(1000); // Produce every second
            }
        } catch (InterruptedException e) {
            System.out.println("[Producer] Interrupted");
        }
    }
}
