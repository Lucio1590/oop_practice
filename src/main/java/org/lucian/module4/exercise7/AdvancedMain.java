package org.lucian.module4.exercise7;

// Advanced example showing multiple handlers and conditional processing
public class AdvancedMain {
    
    // Method to create a more complex logger chain
    private static Logger getAdvancedLoggerChain() {
        // Create multiple instances of the same logger type for different purposes
        Logger consoleInfoLogger = new ConsoleLogger();
        Logger fileWarningLogger = new FileLogger("warnings.log");
        Logger fileErrorLogger = new FileLogger("errors.log");  // Different file for errors
        Logger emailCriticalLogger = new EmailLogger("critical@company.com");
        
        // Set up a more complex chain
        consoleInfoLogger.setNextLogger(fileWarningLogger);
        fileWarningLogger.setNextLogger(fileErrorLogger);
        fileErrorLogger.setNextLogger(emailCriticalLogger);
        
        return consoleInfoLogger;
    }
    
    // Custom logger that handles multiple levels
    static class MultiLevelLogger extends Logger {
        public MultiLevelLogger() {
            super(LogLevel.INFO); // Default level, but we'll override logMessage
        }
        
        @Override
        public void logMessage(LogLevel level, String message) {
            // This logger handles all levels
            write("[MULTI-LEVEL " + level + "] " + message);
            
            // Continue the chain
            if (nextLogger != null) {
                nextLogger.logMessage(level, message);
            }
        }
        
        @Override
        protected void write(String message) {
            System.out.println(message);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Advanced Chain of Responsibility Pattern ===\n");
        
        // Test the advanced chain
        Logger advancedChain = getAdvancedLoggerChain();
        
        System.out.println("1. Testing advanced logger chain:");
        advancedChain.logMessage(LogLevel.INFO, "System initialization complete");
        advancedChain.logMessage(LogLevel.WARNING, "Low disk space warning");
        advancedChain.logMessage(LogLevel.ERROR, "Service unavailable");
        System.out.println();
        
        // Create a chain with the multi-level logger
        Logger multiLevelLogger = new MultiLevelLogger();
        Logger consoleLogger = new ConsoleLogger();
        multiLevelLogger.setNextLogger(consoleLogger);
        
        System.out.println("2. Testing multi-level logger:");
        multiLevelLogger.logMessage(LogLevel.INFO, "Multi-level info message");
        multiLevelLogger.logMessage(LogLevel.WARNING, "Multi-level warning message");
        multiLevelLogger.logMessage(LogLevel.ERROR, "Multi-level error message");
        System.out.println();
        
        System.out.println("=== Advanced Features Demonstrated ===");
        System.out.println("✓ Multiple loggers of the same type with different configurations");
        System.out.println("✓ Custom loggers that handle multiple log levels");
        System.out.println("✓ Flexible chain construction for different scenarios");
        System.out.println("✓ Easy extension and customization of logging behavior");
    }
}
