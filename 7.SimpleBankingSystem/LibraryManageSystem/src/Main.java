import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("******** LIBRARY MANAGEMENT SYSTEM ********");

        ArrayList<Book> books = new ArrayList<>();
        Admin admin = new Admin(books);
        User user = new User(books);
        boolean isRunning= true;

        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.println("*** MENU ***");
            System.out.println("1.Add book");
            System.out.println("2.Remove book");
            System.out.println("3.Borrow book");
            System.out.println("4.Return book");
            System.out.println("5.Available Books");
            System.out.println("6.Exit");

            System.out.println("Enter your choice :");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter the name of the book :");
                    String bookName = scanner.nextLine();
                    admin.addBook(bookName);
                    break;
                case 2 :
                    System.out.println("Enter the name of the book :");
                    String removeBookName = scanner.nextLine();
                    admin.removeBook(removeBookName);
                    break;
                case 3:
                    System.out.println("Enter the name of the book :");
                    String borrowBookName = scanner.nextLine();
                    user.borrowBook(borrowBookName);
                    break;
                case 4:
                    System.out.println("Enter the name of the book :");
                    String returnBookName = scanner.nextLine();
                    user.returnBook(returnBookName);
                    break;
                case 5:
                    admin.listOfBooks();
                    break;
                case 6:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice");

            }
        }
        scanner.close();
    }
}
