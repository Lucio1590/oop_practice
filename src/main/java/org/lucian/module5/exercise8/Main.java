package org.lucian.module5.exercise8;

import java.time.Instant;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
            new Transaction("Alice", 120.0, Instant.parse("2025-06-13T10:15:30.00Z")),
            new Transaction("Bob", 80.0, Instant.parse("2025-06-13T11:00:00.00Z")),
            new Transaction("Alice", 200.0, Instant.parse("2025-06-13T12:00:00.00Z")),
            new Transaction("Charlie", 300.0, Instant.parse("2025-06-13T13:00:00.00Z")),
            new Transaction("Bob", 150.0, Instant.parse("2025-06-13T14:00:00.00Z")),
            new Transaction("Diana", 50.0, Instant.parse("2025-06-13T15:00:00.00Z")),
            new Transaction("Charlie", 400.0, Instant.parse("2025-06-13T16:00:00.00Z")),
            new Transaction("Alice", 90.0, Instant.parse("2025-06-13T17:00:00.00Z"))
        );

        double minAmount = 100.0;

        // 1. Filter transactions above a certain amount
        List<Transaction> filtered = transactions.stream()
            .filter(t -> t.getAmount() > minAmount)
            .collect(Collectors.toList());
        System.out.println("Transactions above " + minAmount + ":");
        filtered.forEach(System.out::println);

        // 2. Group by user and calculate total spending
        Map<String, Double> totalByUser = transactions.stream()
            .collect(Collectors.groupingBy(
                Transaction::getUser,
                Collectors.summingDouble(Transaction::getAmount)
            ));
        System.out.println("\nTotal spending by user:");
        totalByUser.forEach((user, total) -> System.out.println(user + ": " + total));

        // 3. Find the top 3 spenders
        List<Map.Entry<String, Double>> top3 = totalByUser.entrySet().stream()
            .sorted(Map.Entry.<String, Double>comparingByValue(Comparator.reverseOrder()))
            .limit(3)
            .collect(Collectors.toList());
        System.out.println("\nTop 3 spenders:");
        top3.forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        // 4. Sort all transactions by date
        List<Transaction> sortedByDate = transactions.stream()
            .sorted(Comparator.comparing(Transaction::getTimestamp))
            .collect(Collectors.toList());
        System.out.println("\nAll transactions sorted by date:");
        sortedByDate.forEach(System.out::println);
    }
}
