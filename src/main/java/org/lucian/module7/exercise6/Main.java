package org.lucian.module7.exercise6;

class Printer {
    void print(String message) {
        System.out.println(message);
    }
}

class ScannerResource {
    void scan(String message) {
        System.out.println(message);
    }
}

class PrintScanTask implements Runnable {
    private final Printer printer;
    private final ScannerResource scanner;
    private final boolean lockPrinterFirst;
    public PrintScanTask(Printer printer, ScannerResource scanner, boolean lockPrinterFirst) {
        this.printer = printer;
        this.scanner = scanner;
        this.lockPrinterFirst = lockPrinterFirst;
    }
    @Override
    public void run() {
        if (lockPrinterFirst) {
            synchronized (printer) {
                printer.print(Thread.currentThread().getName() + " acquired Printer");
                try { Thread.sleep(200); } catch (InterruptedException ignored) {}
                synchronized (scanner) {
                    scanner.scan(Thread.currentThread().getName() + " acquired Scanner");
                }
            }
        } else {
            synchronized (scanner) {
                scanner.scan(Thread.currentThread().getName() + " acquired Scanner");
                try { Thread.sleep(200); } catch (InterruptedException ignored) {}
                synchronized (printer) {
                    printer.print(Thread.currentThread().getName() + " acquired Printer");
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Printer printer = new Printer();
        ScannerResource scanner = new ScannerResource();
        Thread t1 = new Thread(new PrintScanTask(printer, scanner, true), "Thread-1");
        Thread t2 = new Thread(new PrintScanTask(printer, scanner, false), "Thread-2");
        t1.start();
        t2.start();
        t1.join(1000);
        t2.join(1000);
        System.out.println("If the program hangs, a deadlock occurred!\nNow let's prevent it with lock ordering or timeout.");

        // --- Deadlock prevention: lock ordering ---
        Thread t3 = new Thread(() -> {
            synchronized (printer) {
                printer.print("Thread-3 acquired Printer");
                try { Thread.sleep(200); } catch (InterruptedException ignored) {}
                synchronized (scanner) {
                    scanner.scan("Thread-3 acquired Scanner");
                }
            }
        }, "Thread-3");
        Thread t4 = new Thread(() -> {
            synchronized (printer) { // Always lock Printer first
                printer.print("Thread-4 acquired Printer");
                try { Thread.sleep(200); } catch (InterruptedException ignored) {}
                synchronized (scanner) {
                    scanner.scan("Thread-4 acquired Scanner");
                }
            }
        }, "Thread-4");
        t3.start();
        t4.start();
        t3.join();
        t4.join();
        System.out.println("No deadlock: both threads finished using lock ordering.");
    }
}
