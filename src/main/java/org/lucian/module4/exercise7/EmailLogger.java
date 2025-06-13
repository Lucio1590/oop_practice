package org.lucian.module4.exercise7;

// EmailLogger - handles ERROR level messages by simulating email sending
public class EmailLogger extends Logger {
    private final String emailAddress;
    
    public EmailLogger(String emailAddress) {
        super(LogLevel.ERROR);
        this.emailAddress = emailAddress;
    }
    
    @Override
    protected void write(String message) {
        // Simulate sending email (in real application, you would use JavaMail API)
        System.out.println("[EMAIL ERROR] Sending email to " + emailAddress);
        System.out.println("Subject: Critical Error Alert");
        System.out.println("Body: " + message);
        System.out.println("Email sent successfully!");
    }
}
