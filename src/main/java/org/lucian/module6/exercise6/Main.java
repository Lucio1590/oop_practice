package org.lucian.module6.exercise6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        // File path in resources
        String filePath = "src/main/resources/module6/exercise6/user.ser";
        User user = new User("Alice", "alice@example.com", 30);

        // Ensure directory exists
        File file = new File(filePath);
        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            boolean created = parentDir.mkdirs();
            if (!created) {
                System.err.println("Could not create directory: " + parentDir.getAbsolutePath());
                return;
            }
        }

        // Write the user object to file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(user);
            System.out.println("User object written to file: " + filePath);
        } catch (Exception e) {
            System.err.println("Error writing user: " + e.getMessage());
            return;
        }

        // Read the user object back from file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            User readUser = (User) ois.readObject();
            System.out.println("User object read from file: " + readUser);
            // Verify data integrity
            if (user.getName().equals(readUser.getName()) &&
                user.getEmail().equals(readUser.getEmail()) &&
                user.getAge() == readUser.getAge()) {
                System.out.println("Data integrity verified: objects are equal.");
            } else {
                System.out.println("Data integrity check failed: objects are different.");
            }
        } catch (Exception e) {
            System.err.println("Error reading user: " + e.getMessage());
        }
    }
}
