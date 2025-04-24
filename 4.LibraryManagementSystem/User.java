import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class User {
    private String name;
    private int userID;
    private List<Book> books;
    private long fineAmount;
    private long lateDays;

    private LocalDate returningDate;

    public User(String name) {
        Random random = new Random();
        this.name = name;
        this.userID = random.nextInt(10000);
        this.fineAmount =0;
        this.lateDays = 0;
        this.books = new ArrayList<Book>();
    }

    public void setFineAmount(long fineAmount) {
        this.fineAmount = fineAmount;
    }

    public long getFineAmount() {
        return fineAmount;
    }

    public long getLateDays() {
        return lateDays;
    }


    public LocalDate getReturningDate() {
        return returningDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public List<Book> getBooks() {
        return books;
    }
    public void addBook(Book book) {
        books.add(book);
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.borrowBook();
            System.out.println(name + " borrowed the book: " + book.getTitle());
            books.add(book);
            book.setBorrowingDate(LocalDate.now());
            book.setMustReturnDate(book.getBorrowingDate().plusDays(14));
        } else {
            System.out.println("Sorry, this book is already borrowed.");
        }
    }

    public void returnBook(Book book) {
        book.returnBook();
        System.out.println(name + " returned the book: " + book.getTitle());
        books.remove(book);
        returningDate = LocalDate.now();
        if (returningDate.isAfter(book.getMustReturnDate())){
            Period LateDate = Period.between(book.getMustReturnDate(),returningDate);
            lateDays = LateDate.getDays()+(LateDate.getMonths()* 30L)+(LateDate.getYears()*365L);
            fineAmount=lateDays*2L;
            System.out.println("You were fined, the amount of the fine: "+fineAmount+"$");
            System.out.println("please pay the fine.");
        }
    }
}