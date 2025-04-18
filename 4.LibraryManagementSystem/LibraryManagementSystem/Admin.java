import java.util.ArrayList;
import java.util.List;

public class Admin {

    private List<Book> books;

    public Admin() {
        this.books = new ArrayList<>();
        books.add(new Book("Don Quijote de la Mancha","Miguel de Cervantes"));
        books.add(new Book("A tale of two cities","Charles John"));
        books.add(new Book("Harry Potter and the Philosopher's Stone","Joanne Rowling"));
        books.add(new Book("When Nietzsche Wept","rvin David"));
        books.add(new Book("Game of Thrones","George Raymond"));
        books.add(new Book("The Mousetrap","Dame Agatha"));
        books.add(new Book("Robinson Crusoe","Daniel Defoe"));

        for(int i = 0 ; i< books.size();i++){
Book TitleAuthor =books.get(i);


        System.out.println((i+1)+ "." + TitleAuthor.getTitle() + "| Author:"+TitleAuthor.getAuthor());
    }
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added book: " + book.getTitle() + "| Author:" + book.getAuthor());
        books.add(new Book("Don Quijote de la Mancha", "Miguel de Cervantes"));
        books.add(new Book("A tale of two cities", "Charles John"));
        books.add(new Book("Harry Potter and the Philosopher's Stone", "Joanne Rowling"));
        books.add(new Book("When Nietzsche Wept", "rvin David"));
        books.add(new Book("Game of Thrones", "George Raymond"));
        books.add(new Book("The Mousetrap", "Dame Agatha"));
        books.add(new Book("Robinson Crusoe", "Daniel Defoe"));
        books.add(new Book(book.getTitle(), book.getAuthor()));
        for (int i = 0; i < (books.size()-8); i++) {
            Book TitleAuthor = books.get(i);


            System.out.println((i + 1) + "." + TitleAuthor.getTitle() + "| Author:" + TitleAuthor.getAuthor());
        }
    }
    public void removeBook(Book book) {
        books.remove(book);
        System.out.println("Removed book: " + book.getTitle()+"| Author:" + book.getAuthor());
    }

    public List<Book> getBooks() {
        return books;
    }
}
