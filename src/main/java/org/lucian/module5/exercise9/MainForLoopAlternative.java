package org.lucian.module5.exercise9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainForLoopAlternative {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("iPhone", "Electronics", 999.99, 5000),
            new Product("Galaxy S", "Electronics", 899.99, 4000),
            new Product("MacBook", "Electronics", 1999.99, 2000),
            new Product("Banana", "Groceries", 0.99, 10000),
            new Product("Apple", "Groceries", 1.29, 8000),
            new Product("Bread", "Groceries", 2.49, 6000),
            new Product("T-shirt", "Clothing", 19.99, 3000),
            new Product("Jeans", "Clothing", 49.99, 2500),
            new Product("Jacket", "Clothing", 99.99, 1200)
        );

        // Group products by category (for-loop)
        Map<String, List<Product>> byCategory = new HashMap<>();
        for (Product p : products) {
            byCategory.computeIfAbsent(p.getCategory(), _ -> new ArrayList<>()).add(p);
        }
        System.out.println("Products grouped by category (for-loop):");
        for (Map.Entry<String, List<Product>> entry : byCategory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Find the top-selling product in each category (for-loop)
        Map<String, Product> topSellingByCategory = new HashMap<>();
        for (Map.Entry<String, List<Product>> entry : byCategory.entrySet()) {
            Product top = null;
            for (Product p : entry.getValue()) {
                if (top == null || p.getSales() > top.getSales()) {
                    top = p;
                }
            }
            topSellingByCategory.put(entry.getKey(), top);
        }
        System.out.println("\nTop-selling product in each category (for-loop):");
        for (Map.Entry<String, Product> entry : topSellingByCategory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
