package org.lucian.module6.exercise1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class provides a method to read a text file and print each line to the console.
 */
public class TextFileReader {
    /**
     * Reads a text file line by line and prints each line to the console.
     * @param filePath the path to the text file
     */
    public void printFileLines(String filePath) {
        // Try-with-resources ensures the BufferedReader is closed automatically
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // Handle exceptions such as file not found or read errors
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
