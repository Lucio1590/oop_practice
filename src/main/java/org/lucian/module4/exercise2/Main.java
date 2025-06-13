package org.lucian.module4.exercise2;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    // Create a Logger instance for this class
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        // Configure the logger to log to a file
        try {
            // FileHandler writes logs to a file (append = true)
            FileHandler fh = new FileHandler("sqrt.log", true);
            fh.setFormatter(new SimpleFormatter()); // Simple text format
            logger.addHandler(fh);
            logger.setUseParentHandlers(false); // Don't log to console
        } catch (IOException e) {
            System.out.println("Could not set up file logging: " + e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to calculate its square root: ");
        double input;
        try {
            input = scanner.nextDouble();
            logger.log(Level.INFO, "User input: {0}", input);
            if (input < 0) {
                logger.log(Level.WARNING, "Invalid input (negative number): {0}", input);
                System.out.println("Cannot calculate the square root of a negative number.");
            } else {
                double result = Math.sqrt(input);
                logger.log(Level.INFO, "Square root of {0} is: {1}", new Object[]{input, result});
                System.out.println("The square root of " + input + " is: " + result);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Invalid input: not a number", e);
            System.out.println("Please enter a valid number.");
        } finally {
            scanner.close();
        }
    }
}
