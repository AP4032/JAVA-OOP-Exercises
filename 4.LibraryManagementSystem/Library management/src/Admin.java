import java.util.ArrayList;

public class Admin {

    private ArrayList<Book> books;

    public Admin(ArrayList<Book> books) {
        this.books = books;
    }

    public void addBook(String name){
        books.add(new Book(name));
    }

    public void removeBook(String name){
        for(Book book : books){
            if(book.getName().equals(name)){
                books.remove(book);
                return;
            }
        }
        System.out.println("Book not found");
    }
    public void listOfBooks(){
        for(Book book : books){
            System.out.println(book);
        }
    }
}