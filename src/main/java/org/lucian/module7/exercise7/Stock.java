package org.lucian.module7.exercise7;

import java.util.ArrayList;
import java.util.List;

/**
 * Observer interface for stock price updates.
 */
interface StockObserver {
    void update(double price);
}

/**
 * Stock class acts as the Subject in the Observer pattern.
 */
public class Stock {
    private final List<StockObserver> observers = new ArrayList<>();
    private double price;

    public void registerObserver(StockObserver observer) {
        observers.add(observer);
    }

    public void unregisterObserver(StockObserver observer) {
        observers.remove(observer);
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    private void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.update(price);
        }
    }
}
