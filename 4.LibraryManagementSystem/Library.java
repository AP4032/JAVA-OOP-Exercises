import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;
    private List<Admin> admins;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
        admins = new ArrayList<>();
    }

    // Add a book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book '" + book.getTitle() + "' added to the library.");
    }

    // Remove a book from the library
    public void removeBook(Book book) {
        books.remove(book);
        System.out.println("Book '" + book.getTitle() + "' removed from the library.");
    }

    // View all books in the library
    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            for (Book book : books) {
                book.displayBookInfo();
            }
        }
    }

    // Find a book by title
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // Return null if not found
    }

    // Add a user to the library
    public void addUser(User user) {
        users.add(user);
        System.out.println("User '" + user.getName() + "' added to the library.");
    }

    // Remove a user from the library
    public void removeUser(User user) {
        users.remove(user);
        System.out.println("User '" + user.getName() + "' removed from the library.");
    }

    // Add an admin to the library
    public void addAdmin(Admin admin) {
        admins.add(admin);
        System.out.println("Admin added to the library.");
    }

    // Remove an admin from the library
    public void removeAdmin(Admin admin) {
        admins.remove(admin);
        System.out.println("Admin removed from the library.");
    }

    // View all users in the library
    public void viewAllUsers() {
        if (users.isEmpty()) {
            System.out.println("No users in the library.");
        } else {
            for (User user : users) {
                System.out.println(user.getName());
            }
        }
    }

    // View all admins in the library
    public void viewAllAdmins() {
        if (admins.isEmpty()) {
            System.out.println("No admins in the library.");
        } else {
            for (Admin admin : admins) {
                System.out.println("Admin");
            }
        }
    }
}
