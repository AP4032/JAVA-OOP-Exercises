import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String fName;
    private String lName;
    private String userName;
    private String password;
    private List<Book> books;

    public User(String fName, String lName, String userName, String password) {
        this.fName = fName;
        this.lName = lName;
        this.userName = userName;
        this.password = password;
        this.books = new ArrayList<>();
    }

    public String getFName() {
        return fName;
    }

    public String getLName() {
        return lName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void borrowBook(Book book, String borrowDateStr) {
        if (book.isAvailable()) {
            LocalDate borrowDate = LocalDate.parse(borrowDateStr);
            books.add(book);
            book.borrowedBook(borrowDate);
            System.out.println(fName + " " + lName + " borrowed the book: " + book.getName() + " on " + borrowDate);
            System.out.println("You need to return the book by: " + borrowDate.plusDays(15));
        } else {
            System.out.println("Book is not available.");
        }
    }

    public void returnBook(Book book) {
        books.remove(book);
        book.returnedBook();
        System.out.println(fName + " " + lName + " returned the book: " + book.getName());
    }

    public LocalDate dueDate(Book book) {
        if (book.getBorrowDate() != null) {
            return book.getBorrowDate().plusDays(15);
        }
        return null;
    }
}
