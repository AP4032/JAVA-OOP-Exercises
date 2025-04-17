import java.util.List;
import java.util.Scanner;

public class Library {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();

        System.out.println("=== Library Management System ===");
        boolean running = true;
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add User");
            System.out.println("2. Add Book");
            System.out.println("3. Remove User");
            System.out.println("4. Remove Book");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Show Available Books");
            System.out.println("8. Show All Books");
            System.out.println("9. Show All Users");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter User Name: ");
                    String userName = scanner.nextLine();
                    User newUser = new User(userName);
                    admin.addUser(newUser);
                    break;

                case 2:
                    System.out.println("Enter Book Title: ");
                    String bookTitle = scanner.nextLine();
                    System.out.println("Enter Author: ");
                    String author = scanner.nextLine();
                    Book newBook = new Book(bookTitle, author);
                    admin.addBook(newBook);
                    break;

                case 3:
                    System.out.println("Enter User ID: ");
                    int userID = scanner.nextInt();
                    User userToRemove = findUserById(admin, userID);
                    if (userToRemove != null) {
                        admin.removeUser(userToRemove);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 4:
                    System.out.println("Enter Book Title: ");
                    String bookTitleToRemove = scanner.nextLine();
                    Book bookToRemove = findBookByTitle(admin, bookTitleToRemove);
                    if (bookToRemove != null) {
                        admin.removeBook(bookToRemove);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 5:
                    System.out.println("Enter Book Title: ");
                    String bookTitleToBorrow = scanner.nextLine();
                    System.out.println("Enter User ID: ");
                    int userIdToBorrow = scanner.nextInt();
                    Book bookToBorrow = findBookByTitle(admin, bookTitleToBorrow);
                    User userToBorrow = findUserById(admin, userIdToBorrow);
                    if (bookToBorrow != null) {
                        if (userToBorrow != null) {
                            if (bookToBorrow.isAvailable()) {
                                bookToBorrow.borrowBook();
                                admin.addToBorrowList(userToBorrow.getName(), bookToBorrow.getTitle());
                            } else {
                                System.out.println("Book Is Not Available!");
                            }
                        } else {
                            System.out.println("User not found!");
                        }
                    } else {
                        System.out.println("Book not found!");
                    }
                    break;

                case 6:
                    System.out.println("Enter Book Title: ");
                    String bookTitleToReturn = scanner.nextLine();
                    System.out.println("Enter User ID: ");
                    int userIdToReturn = scanner.nextInt();
                    Book bookToReturn = findBookByTitle(admin, bookTitleToReturn);
                    User userToReturn = findUserById(admin, userIdToReturn);

                    if (bookToReturn != null) {
                        if (userToReturn != null) {
                            if (!bookToReturn.isAvailable()) {
                                bookToReturn.returnBook();
                                admin.removeFromBorrowList(userToReturn.getName(), bookToReturn.getTitle());
                            } else {
                                System.out.println("Book Is Available!");
                            }
                        } else {
                            System.out.println("User not found!");
                        }
                    } else {
                        System.out.println("Book not found!");
                    }
                    break;

                case 7:
                    for (Book book : admin.getBooks()) {
                        if (book.isAvailable()) {
                            System.out.println(book.getTitle() + " By " + book.getAuthor());
                        }
                    }
                    break;
                case 8:
                    for (Book book : admin.getBooks()) {
                        System.out.println(book.getTitle() + " By " + book.getAuthor());
                    }

                    break;
                case 9:
                    for (User user : admin.getUsers()) {
                        System.out.println(user.getId() + ". " + user.getName());
                    }
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    public static User findUserById(Admin admin, int userID) {
        for (User user : admin.getUsers()) {
            if (user.getId() == userID) {
                return user;
            }
        }
        return null;
    }

    public static Book findBookByTitle(Admin admin, String title) {
        for (Book book : admin.getBooks()) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

}
