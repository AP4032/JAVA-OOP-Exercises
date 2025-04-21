public class Admin {
    private Library library;

    public Admin(Library library) {
        this.library = library;
    }

    public void addBook(Book book) {
        library.addBook(book);
        System.out.println("Added book: " + book.getTitle());
    }

    public void removeBook(Book book) {
        library.removeBook(book);
        System.out.println("Removed book: " + book.getTitle());
    }
}
