import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    public Library() {
        this.books = new ArrayList<Book>();
    }
    public List<Book> getBooks() {
        return books;
    }
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books found");
            return;
        }
        int i=1;
        for (Book book : books) {
            System.out.println(i+". "+book);
            i++;
        }
    }
}
