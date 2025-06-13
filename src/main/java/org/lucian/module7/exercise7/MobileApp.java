package org.lucian.module7.exercise7;

/**
 * MobileApp observer: receives stock price updates via mobile notification.
 */
public class MobileApp implements StockObserver {
    private final String username;
    public MobileApp(String username) {
        this.username = username;
    }
    @Override
    public void update(double price) {
        System.out.println("[MobileApp] Notification to " + username + ": Stock price updated to " + price);
    }
}
