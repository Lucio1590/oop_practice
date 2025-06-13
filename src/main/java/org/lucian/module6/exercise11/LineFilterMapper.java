package org.lucian.module6.exercise11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class to filter, map, and collect lines from a text file using Java Streams.
 */
public class LineFilterMapper {
    /**
     * Filters lines containing a keyword, maps to uppercase, and writes to a new file.
     * @param inputPath path to the input file
     * @param outputPath path to the output file
     * @param keyword keyword to filter lines
     */
    public void filterMapAndWrite(String inputPath, String outputPath, String keyword) {
        Path in = Paths.get(inputPath);
        Path out = Paths.get(outputPath);
        try {
            // Ensure output directory exists
            if (out.getParent() != null && !Files.exists(out.getParent())) {
                Files.createDirectories(out.getParent());
            }
            List<String> result = Files.lines(in)
                .filter(line -> line.contains(keyword))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
            Files.write(out, result);
            System.out.println("Filtered and mapped lines written to: " + outputPath);
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}
