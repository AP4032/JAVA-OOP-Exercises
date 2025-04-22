public class User {
    private String name;
    private int password;
    public User(String name,int password) {
        this.name = name;
        this.password = password;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.borrowBook();
            System.out.println(name + " borrowed the book: " + book.getTitle());
        } else {
            System.out.println("Sorry, this book is already borrowed.");
        }
    }
public String getname(){
        return name;
}
public int getpassword(){
        return password;
}
    public void returnBook(Book book) {
        book.returnBook();
        System.out.println(name + " returned the book: " + book.getTitle());
    }
}
