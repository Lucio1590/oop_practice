package org.lucian.module5.exercise12;

import java.util.Optional;

public class Order {
    private final Optional<Customer> customer;

    public Order(Optional<Customer> customer) {
        this.customer = customer;
    }
    public Optional<Customer> getCustomer() {
        return customer;
    }
    @Override
    public String toString() {
        return "Order{customer=" + customer.orElse(null) + "}";
    }
}
