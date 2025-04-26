import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Book> borrowedBooks;

    public User(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    // Borrow a book
    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            borrowedBooks.add(book);
            System.out.println(name + " borrowed the book '" + book.getTitle() + "'.");
        } else {
            System.out.println("Sorry, the book '" + book.getTitle() + "' is currently unavailable.");
        }
    }

    // Return a book
    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            book.setAvailable(true);
            borrowedBooks.remove(book);
            System.out.println(name + " returned the book '" + book.getTitle() + "'.");
        } else {
            System.out.println(name + " did not borrow the book '" + book.getTitle() + "'.");
        }
    }

    // View borrowed books
    public void viewBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println(name + " has no borrowed books.");
        } else {
            System.out.println(name + "'s borrowed books:");
            for (Book book : borrowedBooks) {
                System.out.println(book.getTitle());
            }
        }
    }

    // Get the user's name
    public String getName() {
        return name;
    }
}
