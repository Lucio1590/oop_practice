package org.lucian.module6.exercise10;

public class Main {
    public static void main(String[] args) {
        // Example usage: read and print a text file from resources using FileChannel and ByteBuffer
        String filePath = "src/main/resources/module6/exercise1/example.txt";
        FileChannelReader reader = new FileChannelReader();
        System.out.println("File content:");
        reader.printFileContent(filePath);
    }
}
