package org.lucian.module6.exercise12;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Utility class to process user input, check for forbidden words, sanitize, and write to file.
 */
public class UserInputProcessor {
    private final List<String> forbiddenWords = Arrays.asList("badword", "forbidden", "secret"); // Example forbidden words

    /**
     * Processes user input: checks for forbidden words, trims and sanitizes spaces, writes to file if valid.
     * @param filePath the file to write to
     */
    public void processAndWriteInput(String filePath) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your input: ");
            String input = scanner.nextLine();
            String sanitized = sanitizeInput(input);
            if (containsForbiddenWord(sanitized)) {
                System.err.println("Error: Input contains forbidden words.");
                return;
            }
            if (sanitized.isEmpty()) {
                System.err.println("Error: Input is empty or invalid after sanitization.");
                return;
            }
            // Ensure the parent directory exists
            File file = new File(filePath);
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                boolean created = parentDir.mkdirs();
                if (!created) {
                    System.err.println("Could not create directory: " + parentDir.getAbsolutePath());
                    return;
                }
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                writer.write(sanitized);
                writer.newLine();
                System.out.println("Input written to file: " + filePath);
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }
        }
    }

    // Removes extra spaces and trims the input
    private String sanitizeInput(String input) {
        return input == null ? "" : input.trim().replaceAll("\\s+", " ");
    }

    // Checks if the input contains any forbidden word (case-insensitive)
    private boolean containsForbiddenWord(String input) {
        String lower = input.toLowerCase();
        for (String word : forbiddenWords) {
            if (lower.contains(word)) {
                return true;
            }
        }
        return false;
    }
}
