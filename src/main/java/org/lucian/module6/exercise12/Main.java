package org.lucian.module6.exercise12;

public class Main {
    public static void main(String[] args) {
        // Example usage: process user input and write to file in resources
        String filePath = "src/main/resources/module6/exercise12/user_input.txt";
        UserInputProcessor processor = new UserInputProcessor();
        processor.processAndWriteInput(filePath);
    }
}
