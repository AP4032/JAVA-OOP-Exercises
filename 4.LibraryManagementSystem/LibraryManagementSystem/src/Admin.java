public class Admin {
    private Book[] books;
    private int bookCount;

    public Admin() {
        this.books = new Book[100];
        this.bookCount = 0;
    }

    public void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount] = book;
            bookCount++;
            System.out.println("Added book: " + book.getTitle());
        } else {
            System.out.println("Cannot add more books, library is full.");
        }
    }

    public void removeBook(Book book) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].equals(book)) {

                books[i] = books[bookCount - 1];
                books[bookCount - 1] = null;
                bookCount--;
                System.out.println("Removed book: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not found: " + book.getTitle());
    }

    public Book[] getBooks() {
        Book[] availableBooks = new Book[bookCount];
        for (int i = 0; i < bookCount; i++) {
            availableBooks[i] = books[i];
        }
        return availableBooks;
    }

    public Book[] getBooks(String search) {
        return new Book[0];
    }
}