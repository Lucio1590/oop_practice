package org.lucian.module4.exercise4;

import java.util.Scanner;

// Custom exception for login failures
class LoginException extends Exception {
    public LoginException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        // Hardcoded valid credentials for demonstration
        final String VALID_USERNAME = "user";
        final String VALID_PASSWORD = "pass123";
        int attempts = 0;
        final int MAX_ATTEMPTS = 3;
        // Try up to 3 times
        try (Scanner scanner = new Scanner(System.in)) {
            // Try up to 3 times
            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                try {
                    login(username, password, VALID_USERNAME, VALID_PASSWORD);
                    System.out.println("Login successful! Welcome, " + username + ".");
                    break; // Exit loop on success
                } catch (LoginException e) {
                    attempts++;
                    System.out.println(e.getMessage());
                    if (attempts < MAX_ATTEMPTS) {
                        System.out.println("Try again. Attempts left: " + (MAX_ATTEMPTS - attempts));
                    } else {
                        System.out.println("Too many failed attempts. Access denied.");
                    }
                }
            }
        }
    }

    // Method to check credentials and throw exception if wrong
    public static void login(String username, String password, String validUser, String validPass) throws LoginException {
        if (!username.equals(validUser) || !password.equals(validPass)) {
            throw new LoginException("Invalid username or password.");
        }
    }
}
