public class User {
    private String name;
    private int id;
    private static int idCounter = 1;

    public User(String name) {
        this.name = name;
        this.id = idCounter++;
    }

    public void borrowBook(Admin admin, Book book) {
        if (book.isAvailable()) {
            book.borrowBook();
            System.out.println(name + " borrowed the book: " + book.getTitle());
            admin.addToBorrowList(this.getName(), book.getTitle());
        } else {
            System.out.println("Sorry, this book is already borrowed.");
        }
    }

    public void returnBook(Book book) {
        book.returnBook();
        System.out.println(name + " returned the book: " + book.getTitle());
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}