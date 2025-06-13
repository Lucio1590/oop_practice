package org.lucian.module7.exercise7;

public class Main {
    public static void main(String[] args) {
        Stock stock = new Stock();
        EmailAlert email1 = new EmailAlert("alice@email.com");
        EmailAlert email2 = new EmailAlert("bob@email.com");
        MobileApp app1 = new MobileApp("lucio");

        // Register observers
        stock.registerObserver(email1);
        stock.registerObserver(email2);
        stock.registerObserver(app1);

        System.out.println("--- First price update ---");
        stock.setPrice(100.0);

        // Unregister one observer
        stock.unregisterObserver(email2);
        System.out.println("--- Second price update (after unregister) ---");
        stock.setPrice(105.5);

        // Register a new observer
        MobileApp app2 = new MobileApp("giulia");
        stock.registerObserver(app2);
        System.out.println("--- Third price update (new observer) ---");
        stock.setPrice(110.0);
    }
}
