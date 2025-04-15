import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);
        System.out.println("Welcome to the Library Management System!");
        Library library = new Library();
        Admin admin = new Admin();
        System.out.println("enter your name:");
        String name = stringScanner.nextLine();
        User user = new User(name);
        while(true) {
            System.out.println("select an option:\n1.add a book\n2.remove a book\n3.list all books\n4.borrow a book\n5.return a book\n6.exit");
            int option = intScanner.nextInt();
            String title;
            switch (option) {
                case 1:
                    System.out.println("enter the title:");
                    title = stringScanner.nextLine();
                    System.out.println("enter the author:");
                    String author = stringScanner.nextLine();
                    admin.addBook(new Book(title, author), library);
                    break;
                case 2:
                    System.out.println("enter the title:");
                    title = stringScanner.nextLine();
                    admin.removeBook(title, library);
                    break;
                case 3:
                    library.listAllBooks();
                    break;
                case 4:
                    System.out.println("enter the title:");
                    title = stringScanner.nextLine();
                    user.borrowBook(title, library);
                    break;
                case 5:
                    System.out.println("enter the title:");
                    title = stringScanner.nextLine();
                    user.returnBook(title, library);
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}
