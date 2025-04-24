package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        User currentUser = null;

        while (true) {
            System.out.println("1. Register user");
            System.out.println("2. Add book");
            System.out.println("3. Show all books");
            System.out.println("4. Borrow book");
            System.out.println("5. Return book");
            System.out.println("6. Search book by title");
            System.out.println("7. Search book by author");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            while(!scanner.hasNext()){
                System.out.println("Invalid input!");
                System.out.print("Choose an option: ");
                scanner.next();
            }
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    currentUser = new User(name);
                    library.registerUser(currentUser);
                    break;
                case 2:
                    System.out.print("Book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    Book book = new Book(title, author);
                    library.addBook(book);
                    break;
                case 3:
                    library.listBooks();
                    break;
                case 4:
                    if (currentUser == null) {
                        System.out.println("Please register first.");
                        break;
                    }
                    System.out.print("Enter book title to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    Book toBorrow = findBookByTitle(library, borrowTitle);
                    if (toBorrow != null) {
                        currentUser.borrowBook(toBorrow);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 5:
                    if (currentUser == null) {
                        System.out.println("Please register first.");
                        break;
                    }
                    System.out.print("Enter book title to return: ");
                    String returnTitle = scanner.nextLine();
                    Book toReturn = findBookByTitle(library, returnTitle);
                    if (toReturn != null) {
                        currentUser.returnBook(toReturn);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 6:
                    System.out.print("Enter title keyword: ");
                    String titleKey = scanner.nextLine();
                    List<Book> foundByTitle = library.searchByTitle(titleKey);
                    printSearchResults(foundByTitle);
                    break;
                case 7:
                    System.out.print("Enter author keyword: ");
                    String authorKey = scanner.nextLine();
                    List<Book> foundByAuthor = library.searchByAuthor(authorKey);
                    printSearchResults(foundByAuthor);
                    break;
                case 8:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }

    private static Book findBookByTitle(Library library, String title) {
        for (Book book : library.getBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    private static void printSearchResults(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            System.out.println("Search results:");
            for (Book book : books) {
                System.out.println("- " + book.getTitle() + " by " + book.getAuthor() + " (Available: " + book.isAvailable() + ")");
            }
        }
    }
}