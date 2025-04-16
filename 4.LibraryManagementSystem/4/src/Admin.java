import java.util.ArrayList;
import java.util.List;
public class Admin {
    private List<User> users;
    private List<Book> books;
    public Admin() {
        users = new ArrayList<>();
        books = new ArrayList<>();
    }
    public List<Book> getBook(){
        return books;
    }

    public List<User> getUser(){
        return users;
    }

    public void printBooks(){
        for (Book book : books) {
            System.out.print(book.getTitle() + ":");
            System.out.println(book.getAuthor());
        }
    }

    public void printUsers(){
        for (User user : users) {
            System.out.print(user.getName()+": ");
            System.out.println(user.getId());
        }
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addBook(Book book) {
        books.add(book);
    }


}
