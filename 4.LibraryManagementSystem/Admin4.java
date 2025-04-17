import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Admin4 {
    private List<Book> books;
    private List<User> users;
    private Map<Integer, Book> booksFromID;

    public Admin4() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.booksFromID = new HashMap<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println(book.getTitle() + " has been added successfully.");
    }

    public void removeBook(Book book) {
        books.remove(book);
        System.out.println(book.getTitle() + " has been removed successfully.");
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println(user.getName() + " has been added successfully.");
    }

    public void setBooksFromID(int bookID, Book book) {
        booksFromID.put(bookID, book);
    }

    public Book getBookFromID(int bookID) {
        return booksFromID.get(bookID);
    }

    public void removeBooksFromID(int bookID) {
        booksFromID.remove(bookID);
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }
}
