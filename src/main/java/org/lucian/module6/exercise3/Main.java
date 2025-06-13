package org.lucian.module6.exercise3;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Example usage: read and count words from a file in resources
        String filePath = "src/main/resources/module6/exercise3/example.txt";
        WordCounter counter = new WordCounter();
        Map<String, Integer> wordCounts = counter.countWordsInFile(filePath);
        System.out.println("Word counts:");
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
