package org.lucian.module6.exercise2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * This class provides a method to write a list of messages to a file, one per line, using BufferedWriter in append mode.
 */
public class MessageFileWriter {
    /**
     * Writes a list of messages to a file, appending each message on a new line.
     * @param filePath the path to the file
     * @param messages the list of messages to write
     */
    public void appendMessagesToFile(String filePath, List<String> messages) {
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
        // Try-with-resources ensures the BufferedWriter is closed automatically
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            for (String message : messages) {
                writer.write(message);
                writer.newLine();
            }
        } catch (IOException e) {
            // Handle exceptions such as file write errors
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
