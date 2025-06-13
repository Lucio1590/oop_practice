package org.lucian.module7.exercise7;

/**
 * EmailAlert observer: receives stock price updates via email.
 */
public class EmailAlert implements StockObserver {
    private final String email;
    public EmailAlert(String email) {
        this.email = email;
    }
    @Override
    public void update(double price) {
        System.out.println("[EmailAlert] Email to " + email + ": Stock price updated to " + price);
    }
}
