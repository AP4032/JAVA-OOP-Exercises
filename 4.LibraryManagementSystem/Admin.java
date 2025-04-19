import java.util.ArrayList;

public class Admin extends User {

    public Admin(String name) {
        super(name);  // call the constructor of the parent class (User)
    }

    // You can add admin-specific methods here
    public void removeBook(ArrayList<Book> libraryBooks, String bookName) {
        for (Book b : libraryBooks) {
            if (b.getTitle().equalsIgnoreCase(bookName)) {
                libraryBooks.remove(b);
                System.out.println("Book " + bookName + " has been removed from the library by admin.");
                return;
            }
        }
        System.out.println("Book " + bookName + " not found.");
    }

    public void addBook(ArrayList<Book> libraryBooks, Book newBook) {
        libraryBooks.add(newBook);
        System.out.println("Book " + newBook.getTitle() + " added to library by admin.");
    }
}
