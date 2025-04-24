package org.example;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;
    private List<Admin> admins;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.admins = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Library added: " + book.getTitle());
    }

    public void removeBook(Book book) {
        books.remove(book);
        System.out.println("Library removed: " + book.getTitle());
    }

    public void registerUser(User user) {
        users.add(user);
        System.out.println("User registered: " + user.getName());
    }

    public void registerAdmin(Admin admin) {
        admins.add(admin);
        System.out.println("Admin registered.");
    }

    public List<Book> getBooks() {
        return books;
    }

    public void listBooks() {
        if(books.isEmpty()){
            System.out.println("There is nothing to see.");
            return;
        }
        System.out.println("All books in library:");
        for (Book book : books) {
            System.out.println("- " + book.getTitle() + " by " + book.getAuthor() + " (Available: " + book.isAvailable() + ")");
        }
    }

    public List<Book> searchByTitle(String keyword) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    public List<Book> searchByAuthor(String keyword) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }
}