import java.util.ArrayList;
import java.util.List;

public class Admin {
    private Library library;
    private List<User> users;
    public Admin() {
        library=new Library();
        this.users=new ArrayList<>();
    }

    public Library getLibrary() {
        return library;
    }

    public void addBook(Book book) {
        library.getBooks().add(book);
        System.out.println("Added book: " + book.getTitle());
    }

    public void removeBook(Book book) {
        library.getBooks().remove(book);
        System.out.println("Removed book: " + book.getTitle());
    }

    public List<Book> getBooks() {
        return library.getBooks();
    }
    public List<User> getUsers() {
        return users;
    }
    public void addUser(User user) {
        users.add(user);
    }
}