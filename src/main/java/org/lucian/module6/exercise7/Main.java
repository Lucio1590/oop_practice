package org.lucian.module6.exercise7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // File path in resources
        String filePath = "src/main/resources/module6/exercise7/books.ser";
        List<Book> books = Arrays.asList(
            new Book("Clean Code", "Robert C. Martin", 2008),
            new Book("Effective Java", "Joshua Bloch", 2018),
            new Book("The Pragmatic Programmer", "Andrew Hunt & David Thomas", 1999)
        );

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

        // Serialize the list of books
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(books);
            System.out.println("Book list serialized to file: " + filePath);
        } catch (Exception e) {
            System.err.println("Error serializing books: " + e.getMessage());
            return;
        }

        // Deserialize the list of books
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            @SuppressWarnings("unchecked")
            List<Book> readBooks = (List<Book>) ois.readObject();
            System.out.println("Book list deserialized from file:");
            for (Book book : readBooks) {
                System.out.println(book);
            }
        } catch (Exception e) {
            System.err.println("Error deserializing books: " + e.getMessage());
        }
    }
}
