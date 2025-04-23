package org.example;

import java.time.LocalDate;

public class Book {
    private String name;
    private String author;
    private boolean isAvailable;
    private LocalDate borrowDate;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
        this.isAvailable = true;
        this.borrowDate = null;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void borrowedBook(LocalDate borrowDate) {
        isAvailable = false;
        this.borrowDate = borrowDate;
    }

    public void returnedBook() {
        isAvailable = true;
        this.borrowDate = null;
    }
}
