package org.lucian.module6.exercise4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This class provides a method to copy a binary file (like a .jpg) using FileInputStream and FileOutputStream with buffering for performance.
 */
public class BinaryFileCopier {
    /**
     * Copies a binary file from source to destination using a buffer for performance.
     * @param sourcePath the path to the source file
     * @param destPath the path to the destination file
     */
    public void copyFile(String sourcePath, String destPath) {
        // Buffer size (e.g., 4 KB)
        final int BUFFER_SIZE = 4096;
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead;
        try (FileInputStream fis = new FileInputStream(sourcePath);
             FileOutputStream fos = new FileOutputStream(destPath)) {
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("File copied successfully from " + sourcePath + " to " + destPath);
        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
    }
}
