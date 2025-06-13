package org.lucian.module2.ECommerce;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Create customers
        Customer customer1 = new Customer(1, "Alice", "alice@email.com", LocalDate.of(2024, 6, 1));
        //Customer customer2 = new Customer(2, "Bob", "bob@email.com", LocalDate.of(2024, 6, 10));

        // Create products
        Product prod1 = new Product("P001", "Laptop", 1200.0, 5);
        Product prod2 = new Product("P002", "Smartphone", 800.0, 10);
        Product prod3 = new Product("P003", "Headphones", 150.0, 20);

        // Create cart for Alice
        Cart cart = new Cart(customer1);

        // Add products
        cart.addProduct(prod1, 1);
        cart.addProduct(prod2, 2);
        cart.addProduct(prod3, 3);
        // Try to add more than in stock
        cart.addProduct(prod1, 10);

        // Remove a product
        cart.removeProduct("P002");

        // Display cart details
        cart.printCartDetails();
    }
}
