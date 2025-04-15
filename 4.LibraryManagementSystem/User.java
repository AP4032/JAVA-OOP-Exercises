import java.util.HashMap;
import java.util.Map;

public class User {
    String Red = "\033[31m";
    String Green = "\033[32m";
    String Reset = "\033[0m";
    int Num = 1;
    private final String name;
    // private List<Book>BorrowBookList;
    private final Map<Integer, Book> BookList;

    public User(String name) {
        this.name = name;
//    BorrowBookList =new ArrayList<Book>();
        BookList = new HashMap<Integer, Book>();
    }

//    public List<Book> getBorrowBookList() {
//        return BorrowBookList;
//    }

    public String getName() {
        return name;
    }

    public void BorrowBook(Admin admin, int number) {
        Book book = admin.map.get(number);
        BookList.put(Num++, book);
        System.out.println(Green + getName() + "\n you were able to borrow the book." + book.getBookName() + Reset);
    }
    public void GetAllBooks() {

        for (int num=1 ; num < Num ; num++) {
            System.out.println(num + ". " + BookList.get(num).getBookName() );
        }

    }
    public Boolean ReturnBook(int number) {
        if (number >= Num || number <= 0) {
            System.out.println(Red + "The number you sent is incorrect, please try again" + Reset);
            return false;
        }
        return  true;
    }
    public void ReturnBook(Admin admin, int number) {
        Book book = BookList.get(number);
        book.returnBook();
        BookList.remove(number);
        System.out.println(Green + getName() + "\n you were able to return the book." + book.getBookName() + Reset);


    }


}
