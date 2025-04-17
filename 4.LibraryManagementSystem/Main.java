import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Admin admin = new Admin();
        int choice;
        System.out.println("Welcome to Library Management System!");
        do
        {
            System.out.println("Who are you?");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            switch (choice)
            {
                case 1:
                    do
                    {
                        System.out.println("Choose an option:");
                        System.out.println("1. Add Book");
                        System.out.println("2. Delete Book");
                        System.out.println("3. Show All Books");
                        System.out.println("4. Exit");
                        choice = input.nextInt();
                        String temp = input.nextLine();
                        switch (choice)
                        {
                            case 1:
                                System.out.println("Enter the title:");
                                String addTitle = input.nextLine();
                                System.out.println("Enter the author:");
                                String addAuthor = input.nextLine();
                                Book book = new Book(addTitle, addAuthor);
                                admin.addBook(book);
                                break;
                            case 2:
                                System.out.println("Enter the title:");
                                String removeTitle = input.nextLine();
                                System.out.println("Enter the author:");
                                String removeAuthor = input.nextLine();
                                Book delBook = new Book(removeTitle, removeAuthor);
                                admin.removeBook(delBook);
                                break;
                            case 3:
                                admin.getBooks();
                                break;
                            case 4:
                                System.out.println("Exiting Library Manage System...\nGoodbye!");
                                break;
                            default:
                                System.out.println("Invalid choice");
                                break;
                        }
                    }while (choice != 4);
                    break;
                case 2:
                    System.out.println("What's your name?");
                    String name = input.next();
                    User user = new User(name);
                    do
                    {
                        System.out.println("Choose an option:");
                        System.out.println("1. Borrow Book");
                        System.out.println("2. Return Book");
                        System.out.println("3. Show All Books");
                        System.out.println("4. Exit");
                        choice = input.nextInt();
                        String temp = input.nextLine();
                        switch (choice)
                        {
                            case 1:
                                System.out.println("Enter the title:");
                                String borrowTitle = input.nextLine();
                                System.out.println("Enter the author:");
                                String borrowAuthor = input.nextLine();
                                Book borrowBook = new Book(borrowTitle, borrowAuthor);
                                user.borrowBook(borrowBook);
                                break;
                            case 2:
                                System.out.println("Enter the title:");
                                String returnTitle = input.nextLine();
                                System.out.println("Enter the author:");
                                String returnAuthor = input.nextLine();
                                Book returnBook = new Book(returnTitle, returnAuthor);
                                user.returnBook(returnBook);
                                break;
                            case 3:
                                admin.getBooks();
                                break;
                            default:
                                System.out.println("Invalid choice");
                        }
                    }while (choice != 4);
                    break;
                    case 3:
                        System.out.println("Exiting Library Management System...\nGoodbye!");
                        break;
                    default:
                    System.out.println("Invalid option!");
            }
        }while(choice != 3);

    }
}
