package org.lucian.module2.ECommerce;

import java.time.LocalDate;

public class Customer {
    private int id;
    private String name;
    private String email;
    private LocalDate registrationDate;

    public Customer(int id, String name, String email, LocalDate registrationDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.registrationDate = registrationDate;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public LocalDate getRegistrationDate() { return registrationDate; }

    @Override
    public String toString() {
        return "Customer ID: " + id + ", Name: " + name + ", Email: " + email + ", Registered: " + registrationDate;
    }
}
