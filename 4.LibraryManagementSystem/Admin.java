import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Admin {
    int Num = 1;
    Map<Integer, Book> map;
    String Red = "\033[31m";
    String Green = "\033[32m";
    String Reset = "\033[0m";
    private final List<Book> BookList;
    private final List<User> UserList;

    public Admin() {
        BookList = new ArrayList<>();
        UserList = new ArrayList<>();
        map = new HashMap<>();
    }

    public List<Book> getBookList() {
        return BookList;
    }

    public List<User> getUserList() {
        return UserList;
    }

    public void AddBook(Book book) {
        BookList.add(book);
        map.put(Num++, book);

    }

    public void AddUser(User user) {
        UserList.add(user);
    }

    public boolean GetUser(String user) {
        for (User user1 : UserList) {
            if (user1.getName().equals(user)) {
                return true;
            }
        }
        return false;
    }

    public void GetAllBooks() {
//     int number=1;
//     for (int book : map) {
//         System.out.println(number+"."+book.getBookName());
//         number++;
//     }
        for (int i = 1; i < Num; i++) {
            System.out.println(i + "." + map.get(i).getBookName()+" : "+map.get(i).getBookAuther()+" | Avaliable:"+map.get(i).getAvaliable());
        }
    }

    public User SetUserr(String name) {
        for (User user : UserList) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public Boolean BorrowBook(int number) {
        if (number >= Num || number <= 0) {
            System.out.println(Red + "The number you sent is incorrect, please try again" + Reset);
            return false;
        } else {
            if (map.get(number).borrowBook()) {
//           System.out.println("The court has been booked successfully");
                return true;
            } else {
                System.out.println(Red + "The borrow has already been made" + Reset);
                return false;
            }
        }
    }

    public void GetAllUsers() {
        int num = 1;
        for (User user : UserList) {
            System.out.println(num + "." + user.getName());
            num++;
        }

    }

}
