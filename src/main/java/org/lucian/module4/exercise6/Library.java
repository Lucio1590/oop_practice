package org.lucian.module4.exercise6;

// Simulates a library class that calls third-party code
public class Library {
    // Method that calls third-party code and shields the caller from unchecked exceptions
    public void doSomethingWithThirdParty() throws LibraryException {
        try {
            // Simulate third-party code that may throw an unchecked exception
            thirdPartyMethod();
        } catch (RuntimeException e) {
            // Catch unchecked exception and rethrow as a controlled, custom exception
            throw new LibraryException("An error occurred in the library operation.", e);
        }
    }

    // Simulated third-party method (could throw any unchecked exception)
    private void thirdPartyMethod() {
        // For demonstration, always throw an unchecked exception
        throw new IllegalArgumentException("Simulated third-party failure");
    }
}
