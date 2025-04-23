import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();

        Book book1 = new Book("1984", "George Orwell");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");
        admin.addBook(book1);
        admin.addBook(book2);

        boolean running = true;

        System.out.println("=== Library Management System ===");

        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Show Available Books");
            System.out.println("6. Search Books");
            System.out.println("7. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    admin.addBook(new Book(title, author));
                    break;

                case 2:
                    System.out.print("Enter book title to remove: ");
                    String removeTitle = scanner.nextLine();
                    Book bookToRemove = findBookByTitle(admin, removeTitle);
                    if (bookToRemove != null) {
                        admin.removeBook(bookToRemove);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter your name: ");
                    String userName = scanner.nextLine();
                    User user = new User(userName);
                    System.out.print("Enter book title to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    Book bookToBorrow = findBookByTitle(admin, borrowTitle);
                    if (bookToBorrow != null) {
                        user.borrowBook(bookToBorrow);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter your name: ");
                    String returnUserName = scanner.nextLine();
                    User returnUser  = new User(returnUserName);
                    System.out.print("Enter book title to return: ");
                    String returnTitle = scanner.nextLine();
                    Book bookToReturn = findBookByTitle(admin, returnTitle);
                    if (bookToReturn != null) {
                        returnUser .returnBook(bookToReturn);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 5:
                    System.out.println("Available Books:");
                    for (Book book : admin.getBooks()) {
                        if (book.isAvailable()) {
                            System.out.println(book.getTitle() + " by " + book.getAuthor());
                        }
                    }
                    break;

                case 6:
                    System.out.print("Enter your search: ");
                    String search = scanner.nextLine();
                    Book[] foundBooks = admin.getBooks(search);
                    if (foundBooks.length > 0) {
                        System.out.println("Found Books:");
                        for (Book book : foundBooks) {
                            System.out.println(book.getTitle() + " by " + book.getAuthor());
                        }
                    } else {
                        System.out.println("Not found.");
                    }
                    break;

                case 7:
                    running = false;
                    System.out.println("Exiting... You exited.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static Book findBookByTitle(Admin admin, String title) {
        for (Book book : admin.getBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}