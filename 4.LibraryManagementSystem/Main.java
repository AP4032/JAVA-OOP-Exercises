import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner1 = new Scanner(System.in);
    static Scanner scanner2 = new Scanner(System.in);
   static Admin admin = new Admin();
    public static ArrayList<Book> books  = new ArrayList<>();
    public static ArrayList<User> users = new ArrayList<>();
    public static void main(String[] args) {
        mainmenu();
    }
    public static void mainmenu(){
        System.out.println("Welcome to the Library Management System!");
        System.out.println("Choose an option:");
        System.out.println("1. Add Book");
        System.out.println("2. Add User");
        System.out.println("3. Borrow Book");
        System.out.println("4. Return Book");
        System.out.println("5. Delete Book");
        int option = scanner1.nextInt();
        switch (option) {
            case 1:
                addbook();
                break;
            case 2:
                adduser();
                break;
            case 3:
                borrowBook();
                break;
            case 4:
             returnBook();
                break;
                case 5:
                    deleteBook();
                    break;
        }
    }
    public static void addbook(){

        System.out.println("Please enter the name of the book: ");
        String name = scanner2.nextLine();
        System.out.println("Please enter the author of the book: ");
        String author = scanner2.nextLine();
books.add(new Book(name, author));
admin.addBook(books.getLast());
        mainmenu();
    }
    public static void adduser(){
        System.out.println("Please enter the name of the user: ");
        String name = scanner2.nextLine();
        System.out.println("Please enter the password of the user: ");
        int password = scanner1.nextInt();
        users.add(new User(name, password));

        mainmenu();
    }
    public static void borrowBook(){
        System.out.println("Please enter the name of the user: ");
        String name = scanner2.nextLine();

        for (User user : users) {
            if(user.getname().equals(name) ){
                System.out.println("Enter your password");
                int password = scanner1.nextInt();
                if(user.getpassword() == password) {
                    System.out.println("Hello  " + name);
                    for(int i = 0; i < books.size(); i++) {
                        System.out.println(books.get(i));
                    }
                    System.out.println("Enter name of the book: ");
                    String bookName = scanner2.nextLine();
                    for (Book book : books) {
                        if (book.getTitle().equals(bookName)) {
                            user.borrowBook(book);
                        }   else
                        {System.out.println("That book is not found");}
                    }

                }else {
                    System.out.println("Wrong password");
                }
            }else { System.out.println("User is not found");}
        }

        mainmenu();
    }
    public static void returnBook(){
        System.out.println("Please enter the name of the book: ");
        String name = scanner2.nextLine();
        for (Book book : books) {
            if (book.getTitle().equals(name)) {
                book.returnBook();
            }   else {System.out.println("Book is not found");}
        }

        mainmenu();
    }
    public static void deleteBook(){
        System.out.println("Please enter the name of the book for deletion: ");
        String name = scanner2.nextLine();
        for (Book book : books) {
            if (book.getTitle().equals(name)) {
                admin.removeBook(book);
            }    else{ System.out.println("That book is not found");}
        }

        mainmenu();
    }

}
