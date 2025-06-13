package org.lucian.module4.exercise7;

// Realistic scenario testing for the logging framework
public class RealisticScenarioTest {
    
    // Simulate a database logger
    static class DatabaseLogger extends Logger {
        private String tableName;
        
        public DatabaseLogger(String tableName) {
            super(LogLevel.ERROR);
            this.tableName = tableName;
        }
        
        @Override
        protected void write(String message) {
            System.out.println("[DATABASE] Inserting into " + tableName + ": " + message);
            // In real implementation: INSERT INTO logs (level, message, timestamp) VALUES (...)
        }
    }
    
    // Simulate a Slack notification logger
    static class SlackLogger extends Logger {
        private String channel;
        
        public SlackLogger(String channel) {
            super(LogLevel.ERROR);
            this.channel = channel;
        }
        
        @Override
        protected void write(String message) {
            System.out.println("[SLACK] Posting to #" + channel + ": 🚨 " + message);
        }
    }
    
    // Logger with filtering capabilities
    static class FilteringLogger extends Logger {
        private String keyword;
        
        public FilteringLogger(LogLevel level, String keyword) {
            super(level);
            this.keyword = keyword;
        }
        
        @Override
        public void logMessage(LogLevel level, String message) {
            // Only process messages containing the keyword
            if (this.logLevel == level && message.toLowerCase().contains(keyword.toLowerCase())) {
                write(message);
            }
            
            // Continue the chain
            if (nextLogger != null) {
                nextLogger.logMessage(level, message);
            }
        }
        
        @Override
        protected void write(String message) {
            System.out.println("[FILTERED " + logLevel + "] Keyword '" + keyword + "' found: " + message);
        }
    }
    
    private static Logger createProductionLoggerChain() {
        // Console logger for all INFO messages
        Logger consoleLogger = new ConsoleLogger();
        
        // File logger for warnings
        Logger fileLogger = new FileLogger("production.log");
        
        // Database logger for errors
        Logger dbLogger = new DatabaseLogger("error_logs");
        
        // Slack notifications for critical errors
        Logger slackLogger = new SlackLogger("alerts");
        
        // Email for high-priority errors
        Logger emailLogger = new EmailLogger("devops@company.com");
        
        // Security-specific filtering logger
        Logger securityLogger = new FilteringLogger(LogLevel.WARNING, "security");
        
        // Chain setup: console -> security filter -> file -> database -> slack -> email
        consoleLogger.setNextLogger(securityLogger);
        securityLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(dbLogger);
        dbLogger.setNextLogger(slackLogger);
        slackLogger.setNextLogger(emailLogger);
        
        return consoleLogger;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Realistic Production Logging Scenario ===\n");
        
        Logger productionLogger = createProductionLoggerChain();
        
        System.out.println("1. Application startup message:");
        productionLogger.logMessage(LogLevel.INFO, "Application server started on port 8080");
        System.out.println();
        
        System.out.println("2. Security warning (should trigger security filter):");
        productionLogger.logMessage(LogLevel.WARNING, "Security: Failed login attempt from IP 192.168.1.100");
        System.out.println();
        
        System.out.println("3. Regular warning:");
        productionLogger.logMessage(LogLevel.WARNING, "High memory usage detected: 89%");
        System.out.println();
        
        System.out.println("4. Critical database error:");
        productionLogger.logMessage(LogLevel.ERROR, "Database connection pool exhausted - unable to serve requests");
        System.out.println();
        
        System.out.println("5. Security error:");
        productionLogger.logMessage(LogLevel.ERROR, "Security breach detected: unauthorized access attempt");
        System.out.println();
        
        System.out.println("=== Production Logging Features ===");
        System.out.println("✓ Multi-channel logging (console, file, database, Slack, email)");
        System.out.println("✓ Keyword-based filtering for security events");
        System.out.println("✓ Escalation chain for different severity levels");
        System.out.println("✓ Easy to add new logging destinations");
        System.out.println("✓ Configurable without code changes");
    }
}
