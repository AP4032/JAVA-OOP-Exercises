import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public Book searchBook(String bookName) {
        for (Book book : books) {
            if (book.getName().equals(bookName)) {
                return book;
            }
        }
        System.out.println("No result for book named: " + bookName);
        return null;
    }
    public User userAuthentication(String username, String password) {
        for (User user : users) {
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                System.out.println("User " + user.getFName() + " " + user.getLName() + " logged in successfully.");
                return user;
            }
        }
        System.out.println("Authentication failed. Incorrect username or password.");
        return null;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }
}
