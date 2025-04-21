package org.example;

import java.util.Scanner;

public class Main {
    private static User[] users = new User[100];
    private static int userCount = 0;
    private static Admin admin = new Admin();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("--- Library Management System ---");
            System.out.println("1. Sign up");
            System.out.println("2. Log in");
            System.out.println("3. Exit");
            System.out.println("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Enter username: ");
                    String newUser = scanner.nextLine();
                    System.out.println("Enter password: ");
                    String newPass = scanner.nextLine();
                    boolean exists = false;
                    for (int i = 0; i < userCount; i++) {
                        if (users[i].getUsername().equals(newUser)) {
                            exists = true;
                            break;
                        }
                    }
                    if (exists) {
                        System.out.println("Username already exists!");
                    } else {
                        users[userCount++] = new User(newUser, newPass);
                        System.out.println("User registered successfully.");
                    }
                    break;
                case 2:
                    System.out.println("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.println("Enter password: ");
                    String password = scanner.nextLine();
                    boolean loggedIn = false;
                    for (int i = 0; i < userCount; i++) {
                        if (users[i].login(username, password)) {
                            loggedIn = true;
                            System.out.println("Login successful!");
                            userMenu(scanner, users[i]);
                            break;
                        }
                    }
                    if (!loggedIn) {
                        System.out.println("Invalid credentials!");
                    }
                    break;
                case 3:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
        scanner.close();
    }

    private static void userMenu(Scanner scanner, User user) {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("--- Library Management System ---");
            System.out.println("1. Add book");
            System.out.println("2. Remove book");
            System.out.println("3. Show books");
            System.out.println("4. Borrow book");
            System.out.println("5. Return book");
            System.out.println("6. Search book");
            System.out.println("7. Log out");
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Title: ");
                    String title = scanner.nextLine();
                    System.out.println("Author: ");
                    admin.addBook(new Book(title, scanner.nextLine()));
                    break;
                case 2:
                    System.out.println("Title to remove: ");
                    admin.removeBook(scanner.nextLine());
                    break;
                case 3:
                    System.out.println("Books: ");
                    if (admin.getBooks().length == 0) {
                        System.out.println("No books available.");
                    } else {
                        for (Book book : admin.getBooks()) {
                            String status = book.isAvailable() ? "Available" : "Borrowed";
                            System.out.println("- " + book.getTitle() + " by " + book.getAuthor() + " (" + status + ")");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Title to borrow: ");
                    String borrow = scanner.nextLine();
                    for (Book book : admin.getBooks()) {
                        if (book.getTitle().equalsIgnoreCase(borrow)) {
                            user.borrowBook(book);
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Title to return: ");
                    String returnTitle = scanner.nextLine();
                    for (Book book : admin.getBooks()) {
                        for (Book books : admin.getBooks()) {
                            if (book.getTitle().equalsIgnoreCase(returnTitle)) {
                                user.returnBook(books);
                                break;
                            }
                        }
                        break;
                    }
                case 6:
                    System.out.println("Enter title or author to search: ");
                    String search = scanner.nextLine();
                    user.searchBook(admin.getBooks(), search);
                    break;
                case 7:
                    loggedIn = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}