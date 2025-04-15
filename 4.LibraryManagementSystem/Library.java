import java.util.HashMap;

public class Library {
    private static HashMap<String, Book> library;

    public Library() {
        library = new HashMap<>();
    }

    public HashMap<String, Book> getLibrary() {
        return library;
    }

    public void listAllBooks() {
        if (library.isEmpty()) {
            System.out.println("Library is empty");
        }else {
            for (Book book : library.values()) {
                System.out.println("Title: " + book.getTitle() + ",\tAuthor: " + book.getAuthor());
            }
        }
    }

    public void addBook(Book book) {
        library.put(book.getTitle(), book);
    }

    public void removeBook(String name) {
        library.remove(name);
    }

    public boolean containsBook(String title) {
        return library.containsKey(title);
    }
}
