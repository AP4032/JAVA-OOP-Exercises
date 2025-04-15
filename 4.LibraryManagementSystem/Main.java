import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String Red = "\033[31m";
        String Green = "\033[32m";
        String Reset = "\033[0m";
        Admin admin = new Admin();
        while (true) {
            System.out.println("Welcome to Library Management System \n ");
            System.out.println("Please select the following options:");
            System.out.println("1.Add book to library");
            System.out.println("2.Register");
            System.out.println("3.borrow or return a book");
            System.out.println("4.List of books");
            System.out.println("5.List of users");
            System.out.println("0.EXIT");
            System.out.println("Enter your choice: ");
            String choice = input.nextLine();
            switch (choice) {
                case "0":
                    System.exit(0);

                case "1":
                    System.out.println("Please enter the book name: ");
                    String bookName = input.nextLine();
                    System.out.println("Please enter the book Auther: ");
                    String bookAuther = input.nextLine();
                    Book book = new Book(bookName, bookAuther);
                    admin.AddBook(book);
                    System.out.println(Green + "book added successfully" + Reset);

                    break;
                case "2":
                    System.out.println("Please enter your name:");
                    String userName = input.nextLine();
                    User user = new User(userName);
                    admin.AddUser(user);
                    System.out.println(Green + "You have successfully registered." + Reset);
                    break;
                case "3":
                    System.out.println("You must login\n First enter your user:");
                    String name = input.nextLine();
                    if (admin.GetUser(name)) {
                        System.out.println(Green + "You have successfully logged in.\n" + Reset);
                        User user1 = admin.SetUserr(name);
                        boolean stayInMenu  = true;
                        while (stayInMenu ) {
                            System.out.println("Select: " + Reset);
                            System.out.println("1.Get Borrowed Book");
                            System.out.println("2.Get Returned Book");
                            String Choice = input.nextLine();
                            switch (Choice) {
                                case "1":
                                    stayInMenu  = false;

                                    System.out.println("Please enter the book you want to borrow:");
                                    admin.GetAllBooks();
                                    int Number = input.nextInt();
                                    input.nextLine();
                                    if (admin.BorrowBook(Number)) {
                                        user1.BorrowBook(admin, Number);
                                    }
                                    else
                                    {
                                        System.out.println(Red + "The book you borrowed is incorrect." + Reset);
                                    }
                                    break;
                                    case "2":
                                        stayInMenu  = false;
                                        System.out.println("Please enter the book you want to return:");
                                        user1.GetAllBooks();
                                        int Number1 = input.nextInt();
                                        input.nextLine();
                                        if (user1.ReturnBook(Number1)) {
                                            user1.ReturnBook(admin, Number1);
                                        }
                                        break;
                                default:
                                    System.out.println(Red+"Invalid choice."+Reset);
                                    break;
                            }
                        }


                    } else {
                        System.out.println(Red + "Sorry, your username is incorrect." + Reset);
                    }
                    break;
                case "4":
                    admin.GetAllBooks();
                    break;

                case "5":
                    admin.GetAllUsers();
                    break;
                default:
                    System.out.println(Red + "INVALID CHOICE TRY AGAIN." + Reset);

            }
        }
    }


}