package org.lucian.module7.exercise5;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SharedBuffer buffer = new SharedBuffer();
        Thread producer = new Thread(new Producer(buffer));
        Thread consumer = new Thread(new Consumer(buffer));
        producer.start();
        consumer.start();
        // Let the simulation run for 10 seconds
        Thread.sleep(10000);
        producer.interrupt();
        consumer.interrupt();
        producer.join();
        consumer.join();
        System.out.println("Simulation finished.");
    }
}
