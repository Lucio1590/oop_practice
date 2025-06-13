package org.lucian.module6.exercise11;

public class Main {
    public static void main(String[] args) {
        // Example usage: filter lines containing 'java', map to uppercase, write to new file
        String inputPath = "src/main/resources/module6/exercise11/example.txt";
        String outputPath = "src/main/resources/module6/exercise11/output.txt";
        String keyword = "java";
        LineFilterMapper processor = new LineFilterMapper();
        processor.filterMapAndWrite(inputPath, outputPath, keyword);
    }
}
