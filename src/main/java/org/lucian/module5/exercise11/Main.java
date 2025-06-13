package org.lucian.module5.exercise11;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("Effective Java", "Joshua Bloch", 2018, 45.0),
            new Book("Java Concurrency", "Brian Goetz", 2015, 55.0),
            new Book("Clean Code", "Robert C. Martin", 2008, 40.0),
            new Book("Modern Java", "John Smith", 2019, 35.0),
            new Book("Effective Java", "Joshua Bloch", 2021, 60.0), // duplicate title, higher price
            new Book("Spring in Action", "Craig Walls", 2016, 50.0),
            new Book("Java Puzzlers", "Joshua Bloch", 2011, 30.0),
            new Book("Java Puzzlers", "Joshua Bloch", 2012, 35.0) // duplicate title, higher price
        );

        // Filter books published after 2010 and collect into a map (title -> price), keeping the more expensive book for duplicates
        Map<String, Double> titleToPrice = books.stream()
            .filter(b -> b.getYearPublished() > 2010)
            .collect(Collectors.toMap(
                Book::getTitle,
                Book::getPrice,
                (price1, price2) -> Math.max(price1, price2)
            ));

        System.out.println("Books published after 2010 (title -> price, most expensive if duplicate):");
        titleToPrice.forEach((title, price) -> System.out.println(title + ": " + price));
    }
}
