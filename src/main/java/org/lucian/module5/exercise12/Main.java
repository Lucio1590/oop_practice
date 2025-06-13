package org.lucian.module5.exercise12;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
            new Order(Optional.of(new Customer(Optional.of("alice@email.com")))),
            new Order(Optional.of(new Customer(Optional.empty()))),
            new Order(Optional.empty()),
            new Order(Optional.of(new Customer(Optional.of("bob@email.com")))),
            new Order(Optional.of(new Customer(Optional.of("charlie@email.com")))),
            new Order(Optional.of(new Customer(Optional.empty())))
        );

        // Extract all present email addresses using streams
        List<String> emails = orders.stream()
            .map(Order::getCustomer)
            .flatMap(optCust -> optCust.map(Stream::of).orElseGet(Stream::empty))
            .map(Customer::getEmail)
            .flatMap(optEmail -> optEmail.map(Stream::of).orElseGet(Stream::empty))
            .collect(Collectors.toList());

        System.out.println("Present email addresses:");
        emails.forEach(System.out::println);
    }
}
