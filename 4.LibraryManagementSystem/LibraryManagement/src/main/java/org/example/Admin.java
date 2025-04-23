package org.example;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Book> books;
    private List<User> users;

    public Admin() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            int count = 1;
            for (Book book : books) {
                String availability = book.isAvailable() ? "Yes" : "No";
                System.out.println(count + ". Title: " + book.getName() + ", Author: " + book.getAuthor() +
                        ", Available: " + availability);
                count++;
            }
        }
    }

    public void addUser(User user) {
        users.add(user);
    }
}
