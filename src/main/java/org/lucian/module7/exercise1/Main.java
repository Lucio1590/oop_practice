package org.lucian.module7.exercise1;

public class Main {
    public static void main(String[] args) {
        NumberPrinter t1 = new NumberPrinter("Thread-1");
        NumberPrinter t2 = new NumberPrinter("Thread-2");

        // Start both threads in parallel
        t1.start();
        t2.start();

        // Uncomment the following lines to see what happens if you call run() instead of start()
        // t1.run();
        // t2.run();
    }
}
