import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);
        Admin admin = new Admin();

        System.out.println("=== Library Management System ===");

        boolean running = true;
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add User");
            System.out.println("2. Add Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Show All Users");
            System.out.println("6. Show All Books");
            System.out.println("7. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter your name: ");
                    String name = scanner.nextLine();
                    User user = new User(name);
                    admin.addUser(user);
                    System.out.println("Added User. ID: " + user.getId());
                    break;

                case 2:
                    System.out.println("Enter title of the book: ");
                    String title = scanner.nextLine();

                    System.out.println("Enter author of the book: ");
                    String author = scanner.nextLine();

                    Book book = new Book(title, author);

                    admin.addBook(book);

                    System.out.println("Added Book");

                    break;

                case 3:

                    System.out.println("Enter year ID: ");
                    int IDOfUser = intScanner.nextInt();
                    User thisUser = null;
                    boolean idFound = false;
                    for(User user0 : admin.getUser() ){
                        if(user0.getId() == IDOfUser){
                            idFound = true;
                            thisUser = user0;
                        }
                    }
                    if(!idFound){
                        System.out.println("User not found");
                        break;
                    }
                    

                    System.out.println("Enter name of the book: ");
                    String nameOfBook = scanner.nextLine();
                    for(Book book1 : admin.getBook()){
                        if(book1.getTitle().equals(nameOfBook)){
                            thisUser.borrowBook(book1);
                        }
                    }
                    break;
                    
                case 4:
                    System.out.println("Enter year ID: ");
                    int IDOfUser2 = intScanner.nextInt();
                    User thisUser2 = null;
                    boolean idFound2 = false;
                    for(User user1 : admin.getUser() ){
                        if(user1.getId() == IDOfUser2){
                            idFound2 = true;
                            thisUser2 = user1;
                        }
                    }
                    if(!idFound2){
                        System.out.println("User not found");
                        break;
                    }


                    System.out.println("Enter name of the book: ");
                    String nameOfBook2 = scanner.nextLine();
                    for(Book book2 : admin.getBook()){
                        if(book2.getTitle().equals(nameOfBook2)){
                            thisUser2.returnBook(book2);
                        }
                    }
                    break;

                case 5:
                    admin.printUsers();
                    break;

                case 6:
                    admin.printBooks();
                    break;

                case 7:
                    running = false;
                    break;

            }
        }

    }
}