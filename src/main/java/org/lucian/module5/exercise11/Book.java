package org.lucian.module5.exercise11;

public class Book {
    private final String title;
    private final String author;
    private final int yearPublished;
    private final double price;

    public Book(String title, String author, int yearPublished, double price) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.price = price;
    }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYearPublished() { return yearPublished; }
    public double getPrice() { return price; }
    @Override
    public String toString() {
        return String.format("Book{title='%s', author='%s', year=%d, price=%.2f}", title, author, yearPublished, price);
    }
}
