import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        Library library = new Library();

        User loggedInUser = null;

        System.out.println("=== Library Management System ===");

        boolean running = true;
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add User (Admin Only)");
            System.out.println("2. Add Book (Admin Only)");
            System.out.println("3. Remove Book (Admin Only)");
            System.out.println("4. Login");
            System.out.println("5. View All Books");
            System.out.println("6. Borrow Book");
            System.out.println("7. Return Book");
            System.out.println("8. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter First Name: ");
                    String fName = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lName = scanner.nextLine();
                    System.out.print("Enter Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String password = scanner.nextLine();

                    User newUser = new User(fName, lName, username, password);
                    admin.addUser(newUser);
                    library.addUser(newUser);
                    System.out.println("User added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Book Name: ");
                    String bookName = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();

                    Book book = new Book(bookName, author);
                    admin.addBook(book);
                    library.addBook(book);
                    System.out.println("Book added successfully.");
                    break;

                case 3:
                    System.out.print("Enter Book Name to Remove: ");
                    String removeBookName = scanner.nextLine();
                    Book bookToRemove = library.searchBook(removeBookName);
                    if (bookToRemove != null) {
                        admin.removeBook(bookToRemove);
                        System.out.println("Book removed.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Username: ");
                    String uname = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String pwd = scanner.nextLine();

                    loggedInUser = library.userAuthentication(uname, pwd);
                    break;

                case 5:
                    System.out.println("--- All Books ---");
                    admin.viewBooks();
                    break;

                case 6:
                    if (loggedInUser != null) {
                        System.out.print("Enter book name to borrow: ");
                        String bookToBorrowName = scanner.nextLine();
                        Book bookToBorrow = library.searchBook(bookToBorrowName);
                        if (bookToBorrow != null) {
                            System.out.print("Enter borrow date (yyyy-MM-dd): ");
                            String borrowDateStr = scanner.nextLine();
                            loggedInUser.borrowBook(bookToBorrow, borrowDateStr);
                        } else {
                            System.out.println("Book not found.");
                        }
                    } else {
                        System.out.println("Please log in first.");
                    }
                    break;


                case 7:
                    if (loggedInUser != null) {
                        System.out.print("Enter book name to return: ");
                        String bookToReturnName = scanner.nextLine();
                        Book bookToReturn = library.searchBook(bookToReturnName);
                        if (bookToReturn != null) {
                            loggedInUser.returnBook(bookToReturn);
                        } else {
                            System.out.println("Book not found.");
                        }
                    } else {
                        System.out.println("Please log in first.");
                    }
                    break;

                case 8:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}
