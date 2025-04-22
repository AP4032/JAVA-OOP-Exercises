//Aria Razavi 

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        Admin admin = new Admin("Admin", 1);
        library.addUser(admin);

        User user1 = new User("Aria", 2);
        library.addUser(user1);

        library.addBook(new Book("Mabani", "Mirzaie", "111"));
        library.addBook(new Book("Math 1", "Bakhshande", "222"));

        boolean running = true;
        while (running) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Show all books");
            System.out.println("2. Search book");
            System.out.println("3. Borrow book");
            System.out.println("4. Return book");
            System.out.println("5. Admin: Add book");
            System.out.println("6. Admin: Remove book");
            System.out.println("7. Add user");
            System.out.println("8. Remove user");
            System.out.println("9. Show user borrowed books");
            System.out.println("10. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    library.showAllBooks();
                    break;
                case 2:
                    System.out.print("Enter title keyword: ");
                    String keyword = scanner.nextLine();
                    library.searchBook(keyword);
                    break;
                case 3:
                    System.out.print("User ID: ");
                    int uidBorrow = scanner.nextInt();
                    scanner.nextLine();
                    User borrower = library.getUserById(uidBorrow);
                    if (borrower != null) {
                        System.out.print("Book ISBN: ");
                        String isbn = scanner.nextLine();
                        Book book = Library.findBookByIsbn(library, isbn);
                        if (book != null) {
                            borrower.borrowBook(book);
                        } else {
                            System.out.println("Book not found.");
                        }
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case 4:
                    System.out.print("User ID: ");
                    int uidReturn = scanner.nextInt();
                    scanner.nextLine();
                    User returner = library.getUserById(uidReturn);
                    if (returner != null) {
                        System.out.print("Book ISBN: ");
                        String isbn = scanner.nextLine();
                        Book book = Library.findBookByIsbn(library, isbn);
                        if (book != null) {
                            returner.returnBook(book);
                        } else {
                            System.out.println("Book not found.");
                        }
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String newIsbn = scanner.nextLine();
                    Book newBook = new Book(title, author, newIsbn);
                    admin.addBook(library, newBook);
                    break;
                case 6:
                    System.out.print("Enter ISBN to remove: ");
                    String removeIsbn = scanner.nextLine();
                    Book bookToRemove = Library.findBookByIsbn(library, removeIsbn);
                    if (bookToRemove != null) {
                        admin.removeBook(library, bookToRemove);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 7:
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter user ID: ");
                    int newId = scanner.nextInt();
                    scanner.nextLine();
                    User newUser = new User(name, newId);
                    library.addUser(newUser);
                    break;
                case 8:
                    System.out.print("Enter user ID to remove: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine();
                    library.removeUser(removeId);
                    break;
                case 9:
                    System.out.print("Enter user ID to show borrowed books: ");
                    int viewId = scanner.nextInt();
                    scanner.nextLine();
                    User viewer = library.getUserById(viewId);
                    if (viewer != null) {
                        viewer.showBorrowedBooks();
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case 10:
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