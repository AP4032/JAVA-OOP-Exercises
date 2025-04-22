import java.util.List;
import java.util.ArrayList;
public class Admin {
    private List<Book> books;
    private List<User> users;

    public Admin(){
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
        System.out.println(book.getName() + " added to library.");
    }

    public void removeBook(Book book){
        books.remove(book);
        System.out.println(book.getName() + " removed from library. ");
    }

    public void addUser(User user){
        users.add(user);
        System.out.println(user.getName() + " added.");
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }
}
