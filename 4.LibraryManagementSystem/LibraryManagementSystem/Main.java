import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name:");
        String name = scanner.next();
        System.out.println("Dear " + name + " welcome to library");
        while (true) {

            System.out.println("*======Menu=====*");
            System.out.println("1.List of books");
            System.out.println("2.Add a book");
            System.out.println("3.Removed book");
            System.out.println("4.Exit");
            System.out.print("Enter your choice: ");
            Scanner choice = new Scanner(System.in);
            int number = scanner.nextInt();
            scanner.nextLine();
            switch (number) {
                case 1:
                    Admin admin = new Admin();
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.print("Enter your choice: ");
                    int Number = scanner1.nextInt();
                    for (int i = 1; i < 8; i++) {
                        List<Book> books = admin.getBooks();


                        if (i == Number) {
                            System.out.println((books.get(i).isAvailable() ? "Yes" : "No"));

                            System.out.println("the book " + books.get(i).getTitle() + " given to " + name);

                        }

                    }

                    System.out.println("  ===Please note that you can only borrow the book for 2 years===  ");
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.print("Please write the year you received the book:");
                    int year = scanner2.nextInt();
                    System.out.println("**You can keep the book until " + (2 + year) + " date**");
                    Library library = new Library();

                    break;
                case 2:
Admin admin1 = new Admin();
                    Scanner scanner3 = new Scanner(System.in);
                    System.out.println("Enter book name:");
                    String bookName = scanner3.next();

                    Scanner scanner4 = new Scanner(System.in);
                    System.out.println("Enter author name:");
                    String authorName = scanner3.next();
Book book = new Book( bookName,authorName);
                    admin1.addBook(book);
                    break;
                case 3 :
                    Admin admin2 = new Admin();
                    Scanner scanner5 = new Scanner(System.in);
                    System.out.println("Enter the name of the book you want to remove:");
                    String bookName2 = scanner5.next();

                    Scanner scanner6 = new Scanner(System.in);
                    System.out.println("Enter the name of the author of the book you want to remove:");
                    String authorName2 = scanner6.next();
                    Book book2 = new Book( bookName2,authorName2);
                    admin2.removeBook(book2);
                    break;
                case 4:
                    System.out.println("Exiting....");
                    return;
            }

        }
    }
}
