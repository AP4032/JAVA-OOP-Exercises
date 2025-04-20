import java.util.ArrayList;
import java.util.List;


public class Admin {
    private List<Book> books;
    private List<User> users;


    public Admin() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void printbooks (){
        for (Book book : books) {
            String x ;
            if (book.isAvailable()) {
                x = " " ;
            }
            else {
                x = " not " ;
            }
            System.out.println("title : " + book.getTitle() + "   " + "author : " + book.getauthor() + "   "  +  "is"+x+"available");
            System.out.println("--------------------------------------------------------");
        }
    }

    public void adduser(String name) {
        User user = new User(name);
        users.add(user);
        System.out.println("Added user : " + user.getname());

    }
    public List<User> getusers(){
        return users ;
    }

    public void printplayers() {
        for(User user : users) {
            System.out.println("player name : " + user.getname() + "     " + "borrowed books : ");
            for(Book book : user.getborrowedbooks()) {
                System.out.println(book.getTitle() + " from " +  book.getauthor());
            }

            System.out.println("--------------------------------------------------------");
        }
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
}