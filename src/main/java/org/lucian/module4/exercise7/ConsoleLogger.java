package org.lucian.module4.exercise7;

// ConsoleLogger - handles INFO level messages by printing to console
public class ConsoleLogger extends Logger {
    
    public ConsoleLogger() {
        super(LogLevel.INFO);
    }
    
    @Override
    protected void write(String message) {
        System.out.println("[CONSOLE INFO] " + message);
    }
}
