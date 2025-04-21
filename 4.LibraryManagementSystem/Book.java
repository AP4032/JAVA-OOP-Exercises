import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    private boolean isAvailable;
    private LocalDate borrowingDate;
    private LocalDate mustReturnDate;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public LocalDate getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(LocalDate borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public LocalDate getMustReturnDate() {
        return mustReturnDate;
    }

    public void setMustReturnDate(LocalDate mustReturnDate) {
        this.mustReturnDate = mustReturnDate;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
        }
    }

    public void returnBook() {
        isAvailable = true;
    }
    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", author=" + author + ", isAvailable=" + isAvailable + '}';
    }
}