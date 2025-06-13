package org.lucian.module6.exercise2;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Example usage: write messages to a file in append mode
        String filePath = "src/main/resources/module6/exercise2/output.txt";
        List<String> messages = Arrays.asList(
            "Hello, world!",
            "This is a test message.",
            "Java OOP is powerful!"
        );
        MessageFileWriter writer = new MessageFileWriter();
        writer.appendMessagesToFile(filePath, messages);
        System.out.println("Messages written to file: " + filePath);
    }
}
