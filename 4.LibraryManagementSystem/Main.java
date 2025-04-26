import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Library library = new Library(); // Initialize library
        Admin admin = new Admin(library); // Create admin instance
        User user1 = new User("John");
        User user2 = new User("Jane");

        library.addUser(user1);  // Add users to the library
        library.addUser(user2);

        Book book1 = new Book("Java Programming", "Author 1");
        library.addBook(book1);  // Add a book to the library

        while (true) {
            // Main menu
            System.out.println("Library Management System");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Admin menu
                    adminMenu(scanner, library, admin);
                    break;
                case 2:
                    // User menu
                    userMenu(scanner, library, user1); // Example with user1
                    break;
                case 3:
                    // Exit
                    System.out.println("Exiting the system...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void adminMenu(Scanner scanner, Library library, Admin admin) {
        while (true) {
            // Admin Menu
            System.out.println("\nAdmin Menu");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. View all books");
            System.out.println("4. Manage Users");
            System.out.println("5. View All Users");
            System.out.println("6. View All Admins");
            System.out.println("7. Exit Admin");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add a book
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    Book newBook = new Book(title, author);
                    admin.addBook(newBook);
                    break;
                case 2:
                    // Remove a book
                    System.out.print("Enter book title to remove: ");
                    title = scanner.nextLine();
                    Book bookToRemove = library.findBookByTitle(title);
                    if (bookToRemove != null) {
                        admin.removeBook(bookToRemove);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    // View all books
                    admin.viewBooks();
                    break;
                case 4:
                    // Manage users
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();
                    User userToManage = new User(userName);
                    System.out.print("Add user (yes/no)? ");
                    String action = scanner.nextLine();
                    admin.manageUsers(userToManage, action.equalsIgnoreCase("yes"));
                    break;
                case 5:
                    // View all users
                    admin.viewUsers();
                    break;
                case 6:
                    // View all admins
                    admin.viewAdmins();
                    break;
                case 7:
                    // Exit Admin menu
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void userMenu(Scanner scanner, Library library, User user) {
        while (true) {
            // User Menu
            System.out.println("\nUser Menu");
            System.out.println("1. View available books");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. Exit User");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // View available books
                    library.viewAllBooks();
                    break;
                case 2:
                    // Borrow a book
                    System.out.print("Enter book title to borrow: ");
                    String title = scanner.nextLine();
                    Book bookToBorrow = library.findBookByTitle(title);
                    if (bookToBorrow != null) {
                        user.borrowBook(bookToBorrow);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    // Return a book
                    System.out.print("Enter book title to return: ");
                    title = scanner.nextLine();
                    Book bookToReturn = library.findBookByTitle(title);
                    if (bookToReturn != null) {
                        user.returnBook(bookToReturn);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    // Exit User menu
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
