package org.lucian.module4.exercise6;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        try {
            lib.doSomethingWithThirdParty();
            System.out.println("Operation completed successfully.");
        } catch (LibraryException e) {
            // The caller only sees LibraryException, not the underlying unchecked exception
            System.out.println("Library error: " + e.getMessage());
            // Optionally, you can log or print the cause for debugging:
            // e.getCause().printStackTrace();
        }
    }
}
