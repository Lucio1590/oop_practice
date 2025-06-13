package org.lucian.module6.exercise8;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        // Path to the old serialized file (from exercise 6)
        String oldFilePath = "src/main/resources/module6/exercise6/user.ser";
        // Path to the new serialized file (for version 2)
        String newFilePath = "src/main/resources/module6/exercise8/user_v2.ser";

        // 1. Try to deserialize the old file with the new User class
        System.out.println("Attempting to deserialize old user.ser with new User class (with phoneNumber)...");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(oldFilePath))) {
            User user = (User) ois.readObject();
            System.out.println("Deserialized user from old file: " + user);
            if (user.getPhoneNumber() == null) {
                System.out.println("Compatibility result: phoneNumber is null (as expected for new field). Data from previous fields is preserved.");
            } else {
                System.out.println("Compatibility result: phoneNumber is not null (unexpected).");
            }
        } catch (Exception e) {
            System.err.println("Error deserializing old user.ser: " + e.getMessage());
        }

        // 2. Serialize a new User object with the new field
        User newUser = new User("Bob", "bob@example.com", 28, "+39-123456789");
        // Ensure directory exists
        File file = new java.io.File(newFilePath);
        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            boolean created = parentDir.mkdirs();
            if (!created) {
                System.err.println("Could not create directory: " + parentDir.getAbsolutePath());
                return;
            }
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new java.io.FileOutputStream(newFilePath))) {
            oos.writeObject(newUser);
            System.out.println("New User object written to file: " + newFilePath);
        } catch (Exception e) {
            System.err.println("Error writing new user: " + e.getMessage());
        }

        // 3. Read back the new file to verify all fields
        try (ObjectInputStream ois = new ObjectInputStream(new java.io.FileInputStream(newFilePath))) {
            User user = (User) ois.readObject();
            System.out.println("Deserialized user from new file: " + user);
            if (user.getPhoneNumber() != null) {
                System.out.println("Data integrity verified: phoneNumber field is present and correct.");
            } else {
                System.out.println("Data integrity check failed: phoneNumber is null.");
            }
        } catch (Exception e) {
            System.err.println("Error reading new user: " + e.getMessage());
        }
    }
}
