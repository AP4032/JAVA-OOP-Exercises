public class Book {
    private final String title;
    private final String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void canBorrow() {
        isAvailable = !isAvailable;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
