package org.lucian.module7.exercise3;

/**
 * LightweightTask simulates a simple operation and prints the executing thread.
 */
public class LightweightTask implements Runnable {
    private final int taskId;

    public LightweightTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Task " + taskId + " is running on " + threadName);
        try {
            Thread.sleep(300 + (int)(Math.random() * 300)); // Simulate work
        } catch (InterruptedException e) {
            System.err.println("Task " + taskId + " interrupted");
        }
        System.out.println("Task " + taskId + " completed on " + threadName);
    }
}
