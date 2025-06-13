package org.lucian.module5.exercise7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Item {
    private final String name;
    private final double price;
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() { return name; }
    public double getPrice() { return price; }
    @Override
    public String toString() {
        return String.format("%s (%.2f)", name, price);
    }
}

public class Main {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Sword", 120.0));
        items.add(new Item("Shield", 80.0));
        items.add(new Item("Potion", 15.0));
        items.add(new Item("Helmet", 60.0));
        items.add(new Item("Boots", 40.0));

        double minPrice = 50.0;

        // Print all items using lambda and forEach
        System.out.println("All items:");
        items.forEach(item -> System.out.println(item));

        // Remove items below minPrice using removeIf
        items.removeIf(item -> item.getPrice() < minPrice);
        System.out.println("\nItems after filtering (price >= " + minPrice + "):");
        items.forEach(System.out::println);

        // Compute average price using Stream
        double avgPrice = items.stream()
            .mapToDouble(Item::getPrice)
            .average()
            .orElse(0.0);
        System.out.println("\nAverage price (Stream): " + avgPrice);

        // --- Traditional for-loop version ---
        // Print all items
        List<Item> items2 = new ArrayList<>();
        items2.add(new Item("Sword", 120.0));
        items2.add(new Item("Shield", 80.0));
        items2.add(new Item("Potion", 15.0));
        items2.add(new Item("Helmet", 60.0));
        items2.add(new Item("Boots", 40.0));

        System.out.println("\nAll items (for-loop):");
        for (Item item : items2) {
            System.out.println(item);
        }

        // Remove items below minPrice
        Iterator<Item> it = items2.iterator();
        while (it.hasNext()) {
            if (it.next().getPrice() < minPrice) {
                it.remove();
            }
        }
        System.out.println("\nItems after filtering (for-loop):");
        for (Item item : items2) {
            System.out.println(item);
        }

        // Compute average price
        double sum = 0.0;
        for (Item item : items2) {
            sum += item.getPrice();
        }
        double avg = items2.isEmpty() ? 0.0 : sum / items2.size();
        System.out.println("\nAverage price (for-loop): " + avg);
    }
}
