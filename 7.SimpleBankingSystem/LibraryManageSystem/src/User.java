import java.util.ArrayList;

public class User {
    private ArrayList<Book> books;

    public User (ArrayList<Book> books){
        this.books = books;
    }

    public void borrowBook(String name){
        for(Book book : books){
            if(book.getName().equals(name) && book.isAvailable()){
                book.borrowBook();
                return;
            }
        }
        System.out.println("Book not found");
    }
    public void returnBook(String name){
        for (Book book : books) {
            if(book.getName().equals(name) && !book.isAvailable()){
                book.returnBook();
                return;
            }
        }
        System.out.println("Book not found");
    }
}
