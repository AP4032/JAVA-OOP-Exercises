public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;
    private User borrowedBy;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
        this.borrowedBy = null;
    }

    // Getter methods
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isAvailable() { return isAvailable; }
    public User getBorrowedBy() { return borrowedBy; }

    // Setter methods
    public void setTitle(String title) {
        if (title != null && !title.trim().isEmpty()) {
            this.title = title.trim();
        }
    }

    public void setAuthor(String author) {
        if (author != null && !author.trim().isEmpty()) {
            this.author = author.trim();
        }
    }

    // Book operations
    public boolean borrowBook(User user) {
        if (isAvailable && user != null) {
            isAvailable = false;
            borrowedBy = user;
            return true;
        }
        return false;
    }

    public boolean returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            borrowedBy = null;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String status = isAvailable ? "موجود" :
                "امانت داده شده به: " + (borrowedBy != null ? borrowedBy.getFullName() : "نامشخص");
        return String.format("%s - %s (شابک: %s) | وضعیت: %s",
                title, author, isbn, status);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return isbn.equals(book.isbn);
    }

    @Override
    public int hashCode() {
        return isbn.hashCode();
    }
}