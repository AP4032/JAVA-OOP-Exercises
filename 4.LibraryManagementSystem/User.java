public class User {
    private String name;
    private static int Uid = 0;
    private int userID;

    public User (String name) {
        this.name = name;
        this.userID = Uid++;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.borrowBook();
            System.out.println(name + " borrowed the book: " + book.getTitle());
        }
        else {
            System.out.println("Sorry, this book is already borrowed.");
        }
    }

    public String getName() {
        return name;
    }

    public int getUserID() {
        return userID;
    }
}
