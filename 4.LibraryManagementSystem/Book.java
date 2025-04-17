public class Book {
    private String title;
    private String author;
    private static int Bid = 1000;
    private int bookID;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.bookID = Bid++;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public int getBookID() {
        return bookID;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
        }
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println("The Book has been returned successfully.");
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
