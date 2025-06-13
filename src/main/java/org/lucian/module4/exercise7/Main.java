package org.lucian.module4.exercise7;

public class Main {
    
    // Method to create and configure the logger chain
    private static Logger getLoggerChain() {
        // Create logger instances
        Logger consoleLogger = new ConsoleLogger();
        Logger fileLogger = new FileLogger("warning.log");
        Logger emailLogger = new EmailLogger("admin@company.com");
        
        // Set up the chain: console -> file -> email
        consoleLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(emailLogger);
        
        // Return the first logger in the chain
        return consoleLogger;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Chain of Responsibility Pattern - Logging Framework ===\n");
        
        // Get the logger chain
        Logger loggerChain = getLoggerChain();
        
        System.out.println("Testing different log levels:\n");
        
        // Test INFO level - should be handled by ConsoleLogger only
        System.out.println("1. INFO level message:");
        loggerChain.logMessage(LogLevel.INFO, "Application started successfully");
        System.out.println();
        
        // Test WARNING level - should be handled by FileLogger only
        System.out.println("2. WARNING level message:");
        loggerChain.logMessage(LogLevel.WARNING, "Memory usage is getting high (85%)");
        System.out.println();
        
        // Test ERROR level - should be handled by EmailLogger only
        System.out.println("3. ERROR level message:");
        loggerChain.logMessage(LogLevel.ERROR, "Database connection failed - system critical error");
        System.out.println();
        
        System.out.println("=== Chain of Responsibility Pattern Demonstration ===");
        System.out.println("✓ Each logger in the chain handles only its designated log level");
        System.out.println("✓ Messages are passed through the entire chain");
        System.out.println("✓ New loggers can be easily added without modifying existing code");
        System.out.println("✓ The order of loggers in the chain can be changed dynamically");
    }
}
