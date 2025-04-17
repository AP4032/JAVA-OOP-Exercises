import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner numScanner = new Scanner(System.in);
        Scanner strScanner = new Scanner(System.in);
        Admin4 admin = new Admin4();

        System.out.println("=== Library Management System ===");

        boolean running = true;
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Delete Book");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Show All Books");
            System.out.println("7. Show All Users");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = numScanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter book name: ");
                    String bookAddName = strScanner.nextLine();
                    System.out.print("Enter author name: ");
                    String authorAddName = strScanner.nextLine();
                    Book book = new Book(bookAddName, authorAddName);
                    admin.addBook(book);
                    admin.setBooksFromID(book.getBookID(), book);
                    System.out.println("Book created with ID: " + book.getBookID());
                    break;

                case 2:
                    System.out.print("Enter user name: ");
                    String userName = strScanner.nextLine();
                    User user = new User(userName);
                    admin.addUser(user);
                    System.out.println("User created with ID: " + user.getUserID());
                    break;

                case 3:
                    System.out.print("Enter book ID: ");
                    int bookID = numScanner.nextInt();
                    Book BookD = admin.getBookFromID(bookID);
                    admin.removeBook(BookD);
                    admin.removeBooksFromID(bookID);
                    break;

                case 4:
                    System.out.print("Enter User ID: ");
                    int userBoID = numScanner.nextInt();
                    User userBo = findUserFromID(admin, userBoID);
                    if (userBo == null) {
                        System.out.println("User not found with ID: " + userBoID);
                    }
                    else {
                        System.out.print("Enter Book ID: ");
                        int bookBoID = numScanner.nextInt();
                        Book bookBo = findBookFromID(admin, bookBoID);
                        if (bookBo == null) {
                            System.out.println("Book not found with ID: " + bookBoID);
                        }
                        else {
                            userBo.borrowBook(bookBo);
                        }
                    }
                    break;

                case 5:
                    System.out.print("Enter Book ID: ");
                    int bookReID = numScanner.nextInt();
                    Book bookRe = findBookFromID(admin, bookReID);
                    if (bookRe == null) {
                        System.out.println("Book not found with ID: " + bookReID);
                    }
                    else {
                        if (bookRe.isAvailable())
                            System.out.println("This Book is available");
                        else
                            bookRe.returnBook();

                    }
                    break;

                case 6:
                    showAllBooks(admin);
                    break;

                case 7:
                    showAllUsers(admin);
                    break;

                case 8:
                    running = false;
                    System.out.println("Exiting...See you next time!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        numScanner.close();
        strScanner.close();
    }

    public static User findUserFromID(Admin4 admin, int userID) {
        for (User user : admin.getUsers()) {
            if (user.getUserID() == userID) {
                return user;
            }
        }
        return null;
    }

    public static Book findBookFromID(Admin4 admin, int bookID) {
        for (Book book : admin.getBooks()) {
            if (book.getBookID() == bookID) {
                return book;
            }
        }
        return null;
    }

    public static void showAllBooks(Admin4 admin) {
        System.out.println("--- List of Books ---");
        if (admin.getBooks().isEmpty()) {
            System.out.println("No books found");
        }
        else {
            for (Book book : admin.getBooks()) {
                if (book.isAvailable()) {
                    System.out.println("Name: " + book.getTitle() + " | ID: " + book.getBookID() +
                            " | Status: Available");
                }
                else {
                    System.out.println("Name: " + book.getTitle() + " | ID: " + book.getBookID() +
                            " | Status: Borrowed");
                }
            }
        }
    }

    public static void showAllUsers(Admin4 admin) {
        System.out.println("--- List of Users ---");
        if (admin.getUsers().isEmpty()) {
            System.out.println("No users found");
        }
        else {
            for (User user : admin.getUsers()) {
                System.out.println("Name: " + user.getName() + " | ID: " + user.getUserID());
            }
        }
    }
}
