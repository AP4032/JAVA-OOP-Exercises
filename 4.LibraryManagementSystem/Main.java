import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner strScanner = new Scanner(System.in);
        Scanner numScanner = new Scanner(System.in);

        Admin admin = new Admin();

        System.out.println("=== Library Management System ===");
        boolean run = true;

        while (run){
            System.out.println("--- Main Menu ---");
            System.out.println("1. Add a book.");
            System.out.println("2. Remove a book.");
            System.out.println("3. Add a user.");
            System.out.println("4. Borrow a book.");
            System.out.println("5. Return a book.");
            System.out.println("6. Show all borrowed books.");
            System.out.println("7. Show all available books.");
            System.out.println("8. Show all users.");
            System.out.println("9. Exit.");
            System.out.println("Choose an option: ");
            int choose = numScanner.nextInt();

            switch (choose){
                case 1:
                    System.out.println("Enter book title :");
                    String title = strScanner.nextLine();
                    System.out.println("Enter author name :");
                    String authorName = strScanner.nextLine();
                    Book book = new Book(title,authorName);
                    admin.addBook(book);
                    break;
                case 2:
                    System.out.println("Enter book title :");
                    String title1 = strScanner.nextLine();
                    Book book1 = findBook(admin,title1);
                    if(book1 != null && book1.isAvailable()){
                        admin.removeBook(book1);
                    }else{
                        System.out.println("The book was not found in the library.");
                    }
                    break;
                case 3:
                    System.out.println("Enter user name :");
                    String userName = strScanner.nextLine();
                    User user = new User(userName);
                    admin.addUser(user);
                    break;
                case 4:
                    System.out.println("Enter user name :");
                    String userName1 = strScanner.nextLine();
                    User user1 = findUser(admin,userName1);
                    if(user1 != null){
                        System.out.println("Enter book title :");
                        String title2 = strScanner.nextLine();
                        Book book2 = findBook(admin,title2);
                        if(book2 != null && book2.isAvailable()){
                            user1.borrowBook(book2);
                        }else{
                            System.out.println("The book was not found in the library.");
                        }
                    }else{
                        System.out.println("User not found.");
                    }
                    break;
                case 5:
                    System.out.println("Enter user name :");
                    String userName2 = strScanner.nextLine();
                    User user2 = findUser(admin,userName2);
                    if(user2 != null){
                        System.out.println("Enter book title :");
                        String title2 = strScanner.nextLine();
                        Book book2 = findBook(admin,title2);
                        if(book2 != null){
                            user2.returnBook(book2);
                        }else{
                            System.out.println("Book not found.");
                        }
                    }else{
                        System.out.println("User not found.");
                    }
                    break;
                case 6:
                    System.out.println("All borrowed books :");
                    for (User u : admin.getUsers()){
                        if(u.isBorrowedBook()){
                            System.out.println(u.getName() + " borrowed :");
                            for (Book b : u.getUserBooks()){
                                System.out.println(b.getName() + " by " + b.getAuthor());
                            }
                        }
                    }
                    break;
                case 7:
                    System.out.println("All available books :");
                    if(!(admin.getBooks().isEmpty())){
                        for(Book b : admin.getBooks()){
                            if(b.isAvailable()){
                                System.out.println(b.getName() + " by " + b.getAuthor());
                            }
                        }
                    }else{
                        System.out.println("No books have been added to the library yet.");
                    }
                    break;
                case 8:
                    System.out.println("All user name :");
                    if(!(admin.getUsers().isEmpty())){
                        for (User u : admin.getUsers()){
                            System.out.println(u.getName());
                        }
                    }else{
                        System.out.println("No users have been added to the library yet.");
                    }
                    break;
                case 9:
                    run = false;
                    System.out.println("Good bye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
    public static Book findBook(Admin admin,String title){
        for (Book b : admin.getBooks()){
            if (title.equals(b.getName())){
                return b;
            }
        }
        return null;
    }
    public static User findUser(Admin admin,String name){
        for (User u : admin.getUsers()){
            if(name.equals(u.getName())){
                return u;
            }
        }
        return null;
    }
}
