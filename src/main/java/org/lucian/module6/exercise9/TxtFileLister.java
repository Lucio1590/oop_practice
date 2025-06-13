package org.lucian.module6.exercise9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Utility class to list and print all .txt files in a directory, sorted alphabetically.
 */
public class TxtFileLister {
    /**
     * Prints all .txt files in the given directory, sorted alphabetically.
     * @param dirPath the path to the directory
     */
    public void printTxtFiles(String dirPath) {
        try (Stream<Path> files = Files.list(Paths.get(dirPath))) {
            files.filter(p -> p.getFileName().toString().endsWith(".txt"))
                 .sorted(Comparator.comparing(p -> p.getFileName().toString().toLowerCase()))
                 .forEach(p -> System.out.println(p.getFileName()));
        } catch (IOException e) {
            System.err.println("Error listing files: " + e.getMessage());
        }
    }
}
