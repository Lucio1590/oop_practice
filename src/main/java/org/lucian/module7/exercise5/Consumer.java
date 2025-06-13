package org.lucian.module7.exercise5;

/**
 * Consumer thread: removes items from the shared buffer if available.
 */
public class Consumer implements Runnable {
    private final SharedBuffer buffer;
    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run() {
        try {
            while (true) {
                buffer.consume();
                Thread.sleep(700); // Simulate processing time
            }
        } catch (InterruptedException e) {
            System.out.println("[Consumer] Interrupted");
        }
    }
}
