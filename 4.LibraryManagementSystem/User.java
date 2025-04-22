import java.util.List;
import java.util.ArrayList;
public class User {
    private String name;
    private boolean borrowedBook;
    private List<Book> userBooks;

    public User(String name){
        this.name = name;
        userBooks = new ArrayList<>();
    }

    public void borrowBook(Book book){
        if(book.isAvailable()){
            book.borrowBook();
            userBooks.add(book);
            borrowedBook = true;
            System.out.println(name + " borrowed the book : " + book.getName() + " by " + book.getAuthor());
        }else{
            System.out.println("You can not borrow this book.");
        }
    }

    public void returnBook(Book book){
        book.returnBook();
        userBooks.remove(book);
        if(userBooks.isEmpty()){
            borrowedBook = false;
        }
        System.out.println(name + " returned the book: " + book.getName());
    }

    public String getName() {
        return name;
    }

    public boolean isBorrowedBook() {
        return borrowedBook;
    }

    public List<Book> getUserBooks() {
        return userBooks;
    }
}
