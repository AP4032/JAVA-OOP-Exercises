public class Library {
    private Book[] books;
    private int count;

    public Library(int size) {
        books = new Book[size];
        count = 0;
    }

    public void addBook(Book book) {
        if (count < books.length) {
            books[count] = book;
            count++;
        }
    }

    public Book[] searchBooks(String search) {
        Book[] foundBooks = new Book[count];
        int foundCount = 0;

        for (int i = 0; i < count; i++) {
            if (books[i].getBookName().equalsIgnoreCase(search) ||
                    books[i].getAuthorName().equalsIgnoreCase(search)) {
                foundBooks[foundCount] = books[i];
                foundCount++;
            }
        }

        Book[] result = new Book[foundCount];
        for (int i = 0; i < foundCount; i++) {
            result[i] = foundBooks[i];
        }
        return result;
    }
}