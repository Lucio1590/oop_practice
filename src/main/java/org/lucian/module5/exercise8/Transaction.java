package org.lucian.module5.exercise8;

import java.time.Instant;

public class Transaction {
    private final String user;
    private final double amount;
    private final Instant timestamp;

    public Transaction(String user, double amount, Instant timestamp) {
        this.user = user;
        this.amount = amount;
        this.timestamp = timestamp;
    }
    public String getUser() { return user; }
    public double getAmount() { return amount; }
    public Instant getTimestamp() { return timestamp; }
    @Override
    public String toString() {
        return String.format("Transaction{user='%s', amount=%.2f, timestamp=%s}", user, amount, timestamp);
    }
}
