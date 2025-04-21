import java.util.Scanner;

public class LibraryApp {
    private Library library;
    private Admin admin;
    private Scanner scanner;
    private User user;

    public LibraryApp() {
        library = new Library();
        admin = new Admin(library);
        scanner = new Scanner(System.in);
        user = new User("Alice");

        // نمونه کتاب اولیه
        library.addBook(new Book("1984", "George Orwell"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));
    }

    public void start() {
        while (true) {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. View Available Books");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Add a Book (Admin)");
            System.out.println("5. Remove a Book (Admin)");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    viewBooks();
                    break;
                case 2 : borrowBook();
                break;
                case 3 : returnBook();
                break;
                case 4 : addBook();
                break;
                case 5 : removeBook();
                break;
                case 6 :
                    System.out.println("Goodbye!");
                    System.exit(0);


                default: System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void viewBooks() {
        System.out.println("\nAvailable books:");
        for (Book book : library.getAvailableBooks()) {
            System.out.println("- " + book.getTitle());
        }
    }

    private void borrowBook() {
        System.out.print("Enter book title to borrow: ");
        String title = scanner.nextLine();
        Book book = library.searchByTitle(title);
        if (book != null) {
            user.borrowBook(book);
        } else {
            System.out.println("Book not found.");
        }
    }

    private void returnBook() {
        System.out.print("Enter book title to return: ");
        String title = scanner.nextLine();
        Book book = library.searchByTitle(title);
        if (book != null) {
            user.returnBook(book);
        } else {
            System.out.println("Book not found.");
        }
    }

    private void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        Book book = new Book(title, author);
        admin.addBook(book);
    }

    private void removeBook() {
        System.out.print("Enter book title to remove: ");
        String title = scanner.nextLine();
        Book book = library.searchByTitle(title);
        if (book != null) {
            admin.removeBook(book);
        } else {
            System.out.println("Book not found.");
        }
    }
}
