public class Admin extends User {
    public Admin(String name, int id) {
        super(name, id);
    }

    public void addBook(Library library, Book book) {
        library.addBook(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void removeBook(Library library, Book book) {
        if (library.removeBook(book)) {
            System.out.println("Book removed: " + book.getTitle());
        } else {
            System.out.println("Book not found.");
        }
    }
}