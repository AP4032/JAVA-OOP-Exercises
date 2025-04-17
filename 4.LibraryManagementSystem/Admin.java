import java.util.ArrayList;
import java.util.List;

public class Admin
{
    private List<Book> books;

    public Admin()
    {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book)
    {
        books.add(book);
        System.out.println("Added book: " + book.getTitle());
    }

    public void removeBook(Book book)
    {
        books.remove(book);
        System.out.println("Removed book: " + book.getTitle());
    }

    public void getBooks()
    {
        if (books.isEmpty())
        {
            System.out.println("No books available.");
        }
        else
        {
            System.out.println("Current books:");
            int index = 1;
            for (Book book : books)
            {
                System.out.println(index++ + ". " + book.getTitle() + " by " + book.getAuthor());
            }
        }
    }
}