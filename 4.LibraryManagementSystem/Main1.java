import java.util.Scanner;
import java.util.InputMismatchException;

public class Main1 {
    static Scanner input = new Scanner(System.in);
    static Admin admin = new Admin("123");

    public static void main(String[] args) {
        Book book1 = new Book("1984", "George Orwell");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");

        admin.addBook(book1);
        admin.addBook(book2);
        mainMenu();
    }

    public static void mainMenu(){
        System.out.println("*** Main menu ***");
        System.out.println("1. login user");
        System.out.println("2. register user");


        boolean validInput = false;
        int choice = 0;
        while (!validInput) {
            try {
                System.out.print("Enter your choice: ");
                choice = input.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("wrong input!");
                input.next();
            }
        }

        switch (choice){
            case 1:
                login();
                mainMenu();
                return;
            case 2:
                registerUser();
                mainMenu();
                return;
            default:
                System.out.println("Wrong input!");
                mainMenu();
                return;
        }
    }

    public static void login(){
        System.out.print("Enter user name: ");
        String username = getString();
        for(User user : admin.getUsers()){
            if(username.equals(user.getName())){
                user.login();
                return;
            }
        }
        System.out.println("user name not found!");
    }

    public static String getString(){
        Scanner inputS = new Scanner(System.in);
        boolean isValid = true;
        while(true){
            String S = inputS.nextLine();
            for(int i = 0; i < S.length(); i++) {
                if (!(S.charAt(i) >= 'A' && S.charAt(i) <= 'Z')
                        && !(S.charAt(i) >= 'a' && S.charAt(i) <= 'z')
                        && S.charAt(i) != '_' && S.charAt(i) != '.') {
                    System.out.println("wrong input");
                    isValid = false;
                    break;
                }
            }
            if(isValid){
                return S;
            }
            System.out.print("please try again: ");
            isValid = true;
        }
    }

    public static void registerUser(){
        System.out.print("Enter user name: ");
        String username = getString();
        for(User user : admin.getUsers()){
            if(username.equals(user.getName())){
                System.out.println("invalid username, used by someone else.");;
                return;
            }
        }
        System.out.print("Enter your password: ");
        String password = input.nextLine();
        User user = new User(username, password);
        admin.addUser(user);
    }


}

