public class Book {

    private String name;

    private boolean isAvailable;

    public Book (String name){
        this.name = name;
        this.isAvailable = true;

    }

    public String getName() {
        return name;

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

    @Override
    public String toString() {
        return" Name: " + name + " isAvailable: " + (isAvailable ? "Yes" : "No");
    }
}