public class User {
    private static int counter = 100;
    int id;
    private String name;

    public User(String name) {
        this.name = name;
        this.id = counter++;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.borrowBook();
            System.out.println(name + " borrowed the book: " + book.getTitle());
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
