package org.lucian.module4.exercise6;

// Custom checked exception to shield the caller from implementation details
public class LibraryException extends Exception {
    public LibraryException(String message, Throwable cause) {
        super(message, cause);
    }
}
