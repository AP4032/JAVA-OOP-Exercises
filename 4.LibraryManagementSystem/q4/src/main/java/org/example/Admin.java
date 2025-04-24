package org.example;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    private String name;
    private List<Book> managedBooks;

    public Admin(String name) {
        this.name = name;
        this.managedBooks = new ArrayList<>();
    }

    public void addBook(Book book) {
        managedBooks.add(book);
        System.out.println("Admin added: " + book.getTitle());
    }

    public void removeBook(Book book) {
        managedBooks.remove(book);
        System.out.println("Admin removed: " + book.getTitle());
    }

    public List<Book> getManagedBooks() {
        return managedBooks;
    }
}