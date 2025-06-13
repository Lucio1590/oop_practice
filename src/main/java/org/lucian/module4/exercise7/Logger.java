package org.lucian.module4.exercise7;

// Abstract Logger class that implements Chain of Responsibility pattern
public abstract class Logger {
    // The log level this logger can handle
    protected LogLevel logLevel;
    
    // Reference to the next logger in the chain
    protected Logger nextLogger;
    
    // Constructor to set the log level
    public Logger(LogLevel logLevel) {
        this.logLevel = logLevel;
    }
    
    // Method to set the next logger in the chain
    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }
    
    // Main method to process log messages
    public void logMessage(LogLevel level, String message) {
        // If this logger can handle the message level, process it
        if (this.logLevel == level) {
            write(message);
        }
        
        // Pass the message to the next logger in the chain (if exists)
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }
    
    // Abstract method that concrete loggers must implement
    protected abstract void write(String message);
}
