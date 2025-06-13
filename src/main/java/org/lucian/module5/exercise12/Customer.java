package org.lucian.module5.exercise12;

import java.util.Optional;

public class Customer {
    private final Optional<String> email;

    public Customer(Optional<String> email) {
        this.email = email;
    }
    public Optional<String> getEmail() {
        return email;
    }
    @Override
    public String toString() {
        return "Customer{email=" + email.orElse("-") + "}";
    }
}
