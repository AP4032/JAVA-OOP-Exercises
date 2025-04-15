public class User {
    private final String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void borrowBook(String bookName, Library library) {
        Book book = library.getLibrary().get(bookName);
        if (book.isAvailable()) {
            System.out.println("book " + bookName + " was successfully borrowed.");
            book.canBorrow();
        } else {
            System.out.println("book " + bookName + " is already borrowed.");
        }
    }

    public void returnBook(String bookName, Library library) {
        Book book = library.getLibrary().get(bookName);
        if (!book.isAvailable()) {
            System.out.println("book " + bookName + " was successfully returned.");
            book.canBorrow();
        } else {
            System.out.println("book " + bookName + " is not borrowed to be returned.");
        }
    }
}
