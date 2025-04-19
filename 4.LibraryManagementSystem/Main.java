import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.initializeLibraryData(); // <- don't forget this!

        ArrayList<Book> booksList = library.getBooks();
        ArrayList<User> users = library.getUsers();

        Scanner sc = new Scanner(System.in);
        boolean keepGoing = true;

        System.out.println("::  Welcome to NIT Library  ::");
        while (keepGoing) {
            showMenu();
            int userChoice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (userChoice) {
                case 1 -> handleBookBorrowing(sc, users, booksList, library);
                case 2 -> handleReturningBook(sc, users, booksList);
                case 3 -> library.listOfAvailableBooks();
                case 4 -> addBookToLibrary(sc, booksList, library);
                case 5 -> removeBookFromLibrary(sc , booksList);
                case 6 -> {
                    System.out.println("Exiting the system. Goodbye!");
                    keepGoing = false;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
        sc.close();
    }

    public static void showMenu() {
        System.out.println("\n---- Menu ----\n");
        System.out.println("1. Borrow a Book");
        System.out.println("2. Return a book");
        System.out.println("3. Available books");
        System.out.println("4. Add a book (Admin)");
        System.out.println("5. Remove a book (Admin)");
        System.out.println("6. Exit");
        System.out.print("\nChoose an option: ");
    }

    public static void handleBookBorrowing(Scanner sc, ArrayList<User> users, ArrayList<Book> books, Library library) {
        System.out.print("Enter your name: ");
        String name = sc.nextLine().trim();

        User user = findMemberByName(name, users);
        if (user == null) {
            user = new User(name); // <-- FIXED
            users.add(user);
            System.out.println("You are now a part of our community :>");
        } else {
            System.out.println("Welcome back " + user.getName());
        }

        System.out.println("\nAvailable books:");
        library.listOfAvailableBooks();

        System.out.print("\nEnter the title of the book you want to borrow: ");
        String title = sc.nextLine().trim();

        Book book = findBookByTitle(title, books);
        if (book == null) {
            System.out.println("There is no book by this title :/");
        } else if (!book.isAvailable()) {
            System.out.println("Sorry, that book is already borrowed.");
        } else {
            user.borrowBook(books, title);
        }

        user.showBorrowedBooks();
    }

    public static void removeBookFromLibrary(Scanner sc, ArrayList<Book> books) {
        if (books.isEmpty()) {
            System.out.println("The library is already empty :/");
            return;
        }

        System.out.print("Enter the name of the book you want to remove: ");
        String bookTitle = sc.nextLine().trim();

        int indexToRemove = -1;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(bookTitle)) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            Book removedBook = books.remove(indexToRemove);
            System.out.println("Removed book: " + removedBook.getTitle() + " by " + removedBook.getAuthor());
        } else {
            System.out.println("No book found with that title.");
        }
    }

    public static void addBookToLibrary(Scanner sc, ArrayList<Book> books, Library lib) {
        Admin admin = new Admin("john");
        System.out.print("Enter The name of the book :");
        String bookTitle = sc.nextLine().toLowerCase();

        System.out.print("Enter The author of the book :");
        String bookAuthor = sc.nextLine().toLowerCase();

        admin.addBook(books, new Book(bookTitle, bookAuthor));
        lib.listOfAvailableBooks();
    }

    public static void handleReturningBook(Scanner sc, ArrayList<User> users, ArrayList<Book> books) {
        System.out.print("Enter your name: ");
        String name = sc.nextLine().trim();

        User user = findMemberByName(name, users);
        if (user == null) {
            System.out.println("There is no user by this name :<");
        } else {
            user.showBorrowedBooks();
            System.out.print("Enter the name of the book you want to return: ");
            String bookTitle = sc.nextLine().trim();
            user.returnBook(books, bookTitle);
        }
    }

    public static Book findBookByTitle(String title, ArrayList<Book> books) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    public static User findMemberByName(String inputName, ArrayList<User> users) {
        for (User u : users) {
            if (u.getName().equalsIgnoreCase(inputName)) {
                return u;
            }
        }
        return null;
    }
}
