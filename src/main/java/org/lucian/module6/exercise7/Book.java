package org.lucian.module6.exercise7;

import java.io.Serializable;

/**
 * Book class representing a book with title, author, and year. Implements Serializable for object serialization.
 */
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String title;
    private final String author;
    private final int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}
