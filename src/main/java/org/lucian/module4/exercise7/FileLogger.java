package org.lucian.module4.exercise7;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// FileLogger - handles WARNING level messages by writing to a file
public class FileLogger extends Logger {
    private final String fileName;
    
    public FileLogger(String fileName) {
        super(LogLevel.WARNING);
        this.fileName = fileName;
    }
    
    @Override
    protected void write(String message) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.write("[FILE WARNING " + timestamp + "] " + message + "\n");
            System.out.println("Warning logged to file: " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
}
