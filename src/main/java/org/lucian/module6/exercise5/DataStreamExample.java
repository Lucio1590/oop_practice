package org.lucian.module6.exercise5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This class provides methods to write and read int, double, and String values to/from a binary file using DataOutputStream and DataInputStream.
 */
public class DataStreamExample {
    /**
     * Writes an int, a double, and a String to a binary file.
     * @param filePath the path to the binary file
     * @param intValue the int value to write
     * @param doubleValue the double value to write
     * @param stringValue the String value to write
     */
    public void writeData(String filePath, int intValue, double doubleValue, String stringValue) {
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
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            dos.writeInt(intValue);
            dos.writeDouble(doubleValue);
            dos.writeUTF(stringValue);
            System.out.println("Data written to file: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing data: " + e.getMessage());
        }
    }

    /**
     * Reads an int, a double, and a String from a binary file and prints them.
     * @param filePath the path to the binary file
     */
    public void readData(String filePath) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            int intValue = dis.readInt();
            double doubleValue = dis.readDouble();
            String stringValue = dis.readUTF();
            System.out.println("Read values from file:");
            System.out.println("Int: " + intValue);
            System.out.println("Double: " + doubleValue);
            System.out.println("String: " + stringValue);
        } catch (IOException e) {
            System.err.println("Error reading data: " + e.getMessage());
        }
    }
}
