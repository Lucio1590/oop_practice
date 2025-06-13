package org.lucian.module6.exercise10;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Utility class to read a text file using FileChannel and ByteBuffer and print its content.
 */
public class FileChannelReader {
    /**
     * Reads a text file into memory using FileChannel and ByteBuffer and prints its content.
     * @param filePath the path to the text file
     */
    public void printFileContent(String filePath) {
        Path path = Paths.get(filePath);
        try (FileChannel channel = FileChannel.open(path, StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate((int) channel.size());
            channel.read(buffer);
            buffer.flip();
            String content = StandardCharsets.UTF_8.decode(buffer).toString();
            System.out.println(content);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
