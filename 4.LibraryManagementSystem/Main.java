import java.util.Locale;
import java.util.Scanner;

public class Main {
//    public static void main(String[] args) {
//        Admin admin = new Admin();
//        Book book1 = new Book("1984", "George Orwell");
//        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");
//
//        admin.addBook(book1);
//        admin.addBook(book2);
//
//        User user = new User("Alice");
//        user.borrowBook(book1);
//        user.returnBook(book1);
//    }

    private static Scanner scanner = new Scanner(System.in);
    private static Admin admin= new Admin();
    public static void main(String[] args) {
        System.out.println("********** Welcome to Sports Court Booking System **********");
        mainMenu();
        System.out.println("Bye Bye .....");
    }
    private static void mainMenu(){
        System.out.println("-------* Main Menu *-------");
        System.out.println("1. Create account");
        System.out.println("2. Borrowing a Book");
        System.out.println("3. Return a Book");
        System.out.println("4. Pay the fine");
        System.out.println("5. Display your information");
        System.out.println("6. Add book");
        System.out.println("7. remove book");
        System.out.println("8. show all books");
        System.out.println("9. Exit");
        System.out.println("Enter your choice:");
        do {
            int choice=Utils.getNum();
            switch (choice) {
                case 1:
                    createAccount();
                    mainMenu();
                    return;
                case 2:
                    borrowingBook();
                    mainMenu();
                    return;
                case 3:
                    returningBook();
                    mainMenu();
                    return;
                case 4:
                    payFine();
                    mainMenu();
                    return;
                case 5:
                    displayInfo();
                    mainMenu();
                    return;
                case 6:
                    addBook();
                    mainMenu();
                    return;
                case 7:
                    removeBook();
                    mainMenu();
                    return;
                case 8:
                    showAllBooks();
                    mainMenu();
                    return;
                case 9:
                    return;
                default:
                    System.out.println("Invalid choice!, try again");
            }
        }while (true);
    }
    private static void createAccount() {
        System.out.println("********** Creat Account **********");
        System.out.println("Enter your name:");
        String name = Utils.getString();
        if (!(admin.getUsers().isEmpty())){
            for (User user : admin.getUsers()) {
                if(user.getName().equals(name) ){
                    System.out.println("This name already exists!");
                    return;
                }
            }
        }
        User user= new User(name);
        System.out.println("Your user ID :"+user.getUserID()+" please saved it and don't forget it.");
        admin.addUser(user);
    }
    private static void displayInfo(){
        System.out.println("********** Display your info **********");
        User user = Utils.getUserID(admin);
        System.out.println("-----------------------------------------");
        System.out.println("Your name: "+user.getName());
        System.out.println("Your user ID: "+user.getUserID());
        System.out.println("Late return fine: "+user.getFineAmount()+"$");
        if(!(user.getBooks().isEmpty())){
            for(Book book: user.getBooks()){
                System.out.println("the book you borrowed: "+book);
                System.out.println("Date of borrowing book :"+book.getBorrowingDate());
                System.out.println("The date you must return the book: "+book.getMustReturnDate());
            }
        }
        else {
            System.out.println("You didn't borrow a book..");
        }
        System.out.println("-------------------------------------------");
    }
    private static void borrowingBook(){
        System.out.println("********** Borrowing book **********");
        User user = Utils.getUserID(admin);
        if(user.getFineAmount()!=0){
            System.out.println("You were fined, the amount of the fine: "+user.getFineAmount()+"$");
            System.out.println("please pay the fine.");
            return;
        }
        System.out.println("Enter book name:");
        String bookName=Utils.getString();
        System.out.println("Enter book author:");
        String author=Utils.getString();
        Book borrowingBook=null;
        boolean found=false;
        for (Book book : admin.getBooks()) {
            if (book.getTitle().equals(bookName) && book.getAuthor().equals(author)) {
                borrowingBook = book;
                found=true;
                break;
            }
        }
        if(!found){
            System.out.println("That book is not available in the library.");
            return;
        }
        user.borrowBook(borrowingBook);
    }
    private static void returningBook(){
        System.out.println("********** Returning book **********");
        User user = Utils.getUserID(admin);
        System.out.println("Enter book name:");
        String bookName=Utils.getString();
        System.out.println("Enter book author:");
        String author=Utils.getString();
        Book returnBook=null;
        boolean found=false;
        for (Book book : admin.getBooks()) {
            if (book.getTitle().equals(bookName) && book.getAuthor().equals(author)) {
                if(book.isAvailable()){
                    System.out.println("That book is available, you cant return it.");
                    return;
                }
                else {
                    returnBook = book;
                    found=true;
                    break;
                }
            }
        }
        if(!found){
            System.out.println("That book is not available in the library.");
            return;
        }
        user.returnBook(returnBook);
    }
    private static void payFine(){
        System.out.println("********** Pay fine **********");
        User user = Utils.getUserID(admin);
        if(user.getFineAmount()==0){
            System.out.println("You were not fined");
            return;
        }
        System.out.println("Amount of fine: "+user.getFineAmount()+"$");
        do {
            System.out.println("Do you want to pay fine?(yes/no)");
            String choice = Utils.getString().toLowerCase();
            switch (choice) {
                case "yes":
                    System.out.println("you pay fine successfully!");
                    user.setFineAmount(0);
                    return;
                case "no":
                    System.out.println("The fine was not cleared");
                    return;
                default:
                    System.out.println("Invalid choice!, try again:");
            }
        }while (true);
    }
    private static void addBook(){
        System.out.println("********** Add Book **********");
        System.out.println("Enter book name:");
        String bookName=Utils.getString();
        System.out.println("Enter book author:");
        String author=Utils.getString();
        Book book=new Book(bookName,author);
        admin.addBook(book);
    }
    private static void removeBook(){
        System.out.println("********** Remove Book **********");
        System.out.println("Enter book name:");
        String bookName=Utils.getString();
        System.out.println("Enter book author:");
        String author=Utils.getString();
        Book book=new Book(bookName,author);
        admin.removeBook(book);
    }
    private static void showAllBooks(){
        System.out.println("***************************** Show all Books *****************************");
        admin.getLibrary().displayBooks();
        System.out.println("***************************************************************************");
    }
}