public class Book {
    private final String bookName;
    private final String bookAuther;
    private Boolean Avaliable = true;

    public Book(String bookName, String bookAuther) {
        this.bookName = bookName;
        this.bookAuther = bookAuther;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookAuther() {
        return bookAuther;
    }

    public Boolean getAvaliable() {
        return Avaliable;
    }

    public void setAvaliable(Boolean Avaliable) {
        this.Avaliable = Avaliable;
    }

    public Boolean borrowBook() {
        if (Avaliable) {
            Avaliable = false;
            return true;
        }
        return false;
    }
    public  void returnBook() {
        if (!Avaliable) {
            Avaliable = true;
        }

    }

}
