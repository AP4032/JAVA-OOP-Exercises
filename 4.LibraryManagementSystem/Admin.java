import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Admin {
    private List<Book> books;
    private List<User> users;
    private Map<String, String> borrowList;

    public Admin() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.borrowList = new HashMap<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added book: " + book.getTitle());
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("Added User: " + user.getName());
    }

    public void removeBook(Book book) {
        books.remove(book);
        System.out.println("Removed book: " + book.getTitle());
    }

    public void removeUser(User user) {
        users.remove(user);
        System.out.println("Removed user: " + user.getName());
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }

    public void addToBorrowList(String userName, String bookTitle) {
        borrowList.put(userName, bookTitle);
        System.out.println(bookTitle + " borrowed by " + userName);
    }

    public void removeFromBorrowList(String userName, String bookTitle) {
        borrowList.remove(userName, bookTitle);
        System.out.println(bookTitle + " returned from " + userName);
    }
}