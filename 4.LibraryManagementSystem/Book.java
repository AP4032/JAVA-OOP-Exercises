public class Book {
    private String name;
    private String author;
    private boolean isAvailable;

    public Book(String name,String author){
        this.name = name;
        this.author = author;
        this.isAvailable = true;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrowBook(){
        isAvailable = false;
    }

    public void returnBook(){
        isAvailable = true;
    }
}
