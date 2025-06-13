package org.lucian.module6.exercise5;

public class Main {
    public static void main(String[] args) {
        // Example usage: write and read data from a binary file in resources
        String filePath = "src/main/resources/module6/exercise5/data.bin";
        DataStreamExample example = new DataStreamExample();
        // Write data
        example.writeData(filePath, 42, 3.14159, "Hello, Java!");
        // Read data
        example.readData(filePath);
    }
}
