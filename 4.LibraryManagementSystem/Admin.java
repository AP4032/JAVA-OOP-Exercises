import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Book> books;
    private ArrayList<User> users = new ArrayList<>();
    private String password;

    public Admin(String password) {
        this.books = new ArrayList<>();
        this.password = password;
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added book: " + book.getTitle());
    }

    public void removeBook(Book book) {
        books.remove(book);
        System.out.println("Removed book: " + book.getTitle());
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addUser(User user){
        users.add(user);
        System.out.println("Added user: " + user.getName());
    }

    public void removeUser(User user){
        users.remove(user);
        System.out.println("Removed user: " + user.getName());
    }

    public ArrayList<User> getUsers(){
        return users;
    }
}