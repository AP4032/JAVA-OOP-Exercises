public class Book {
    private String bookTitle;
    private String author;
    private boolean isAvailable;

    public Book(String bookName, String author){
       this.bookTitle = bookName;
       this.author = author;
       this.isAvailable = true;
    }

    public void setAvailable(boolean available){
        this.isAvailable = available;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    public String getTitle(){
       return bookTitle;
    }
    public String getAuthor(){
        return author;
    }

    public String toString() {
        return "Book :" + bookTitle + " ,Author :" + author + " Available :" + isAvailable;
    }
}
