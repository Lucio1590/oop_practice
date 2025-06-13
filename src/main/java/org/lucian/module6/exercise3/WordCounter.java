package org.lucian.module6.exercise3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * This class provides a method to read a text file and count the occurrences of each word (case-insensitive, ignoring punctuation).
 */
public class WordCounter {
    /**
     * Reads a text file and counts how many times each word appears (ignoring case and punctuation).
     * @param filePath the path to the text file
     * @return a Map with words as keys and their counts as values
     */
    public Map<String, Integer> countWordsInFile(String filePath) {
        Map<String, Integer> wordCounts = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Remove punctuation and split by whitespace
                String[] words = line.replaceAll("[\\p{Punct}]", "").toLowerCase().split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return wordCounts;
    }
}
