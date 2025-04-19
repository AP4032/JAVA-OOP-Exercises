import java.util.ArrayList;

public class Library {
    ArrayList<Book> books;
    ArrayList<User> users;

    public Library(){
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void initializeLibraryData() {
        books.add(new Book("1984", "George Orwell"));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Book("Pride and Prejudice", "Jane Austen"));
        books.add(new Book("The Catcher in the Rye", "J.D. Salinger"));

        users.add(new User("Alice"));
        users.add(new User("Bob"));
        users.add(new User("Charlie"));
        users.add(new User("Diana"));
    }

    public ArrayList<User> getUsers() {
        return users;
    }
    public ArrayList<Book> getBooks() {
        return books;
    }

    public void listOfAvailableBooks(){
       for (Book b : books){
           if (b.isAvailable()){
               System.out.println("Book :" + b.getTitle() + " ,Author :" + b.getAuthor());
           }
       }
    }
}
