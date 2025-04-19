import java.util.ArrayList;
import java.util.Random;

public class User {
    private final String name;
    private final int ID;
    ArrayList<Book> borrowedBooks = new ArrayList<>();

    public User(String name){
        Random rand = new Random();
        this.name = name;
        this.ID = rand.nextInt(50001) + 10000;
    }

    public void returnBook(ArrayList<Book> libraryBooks, String bookName){
        for (Book b: borrowedBooks){
            if (b.getTitle().equalsIgnoreCase(bookName)){
                borrowedBooks.remove(b);
                b.setAvailable(true);
                System.out.println("book "+ b.getTitle() + " returned to library.");
            }
        }
    }
    public void borrowBook(ArrayList<Book> Books, String title) {
        for (Book b: Books){
            if (b.getTitle().equalsIgnoreCase(title)){
                borrowedBooks.add(b);
                b.setAvailable(false);
                System.out.println("Book :" + b.getTitle() + ",added you your list.");
            }
        }
    }

    public String getName(){
        return name;
    }

    public void showBorrowedBooks(){
        if (borrowedBooks.isEmpty()) {
            System.out.println("You haven't borrowed any books yet.");
        } else {
            System.out.println("Books you've borrowed:");
            for (Book b : borrowedBooks) {
                System.out.println(" * " + b.getTitle() + " by " + b.getAuthor());
            }
        }
    }
}
