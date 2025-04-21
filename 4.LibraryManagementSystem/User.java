import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class User {
    private String name;
    public ArrayList<Book> books;
    public String password;

    static Scanner input = new Scanner(System.in);
    static Scanner inputs = new Scanner(System.in);
    static Admin admin = new Admin("123");

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName(){
        return this.name;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.borrowBook();
            books.add(book);
            System.out.println(name + " borrowed the book: " + book.getTitle());
        } else {
            System.out.println("Sorry, this book is already borrowed.");
        }
    }

    public void returnBook(Book book) {
        book.returnBook();
        books.remove(book);
        System.out.println(name + " returned the book: " + book.getTitle());
    }

    public void login(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String pass = input.next();
        if(this.password.equals(pass)){
            System.out.println("Welcome to the library");
            userMenu();
        }
    }

    public void userMenu(){
        System.out.println("--- user menu ---");
        System.out.println("1. your books");
        System.out.println("2. library books");

        Scanner input = new Scanner(System.in);
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
                userBooksMenu();
                userMenu();
                return;
            case 2:
                libraryBooks();
                userMenu();
                return;
            default:
                System.out.println("Wrong input!");
                userMenu();
                return;
        }
    }

    public void userBooksMenu(){
        int count = 1;
        for(Book book : books){
            System.out.println(count + ". " + book.getTitle());
            count++;
        }

        if(books.isEmpty()){
            System.out.println("there is no book");
            System.out.println("press Enter");
            input.nextLine();
            userMenu();
            return;
        }
        else{
            System.out.println("choose one of the books");
            System.out.println("or...");
            System.out.println("Enter 0 for going back to user menu");
        }

        boolean validInput = false;
        int choice = 0;
        while (!validInput) {
            try {
                System.out.print("Enter your choice: ");
                choice = input.nextInt();
                if(choice > 0 && choice < books.size()){
                    validInput = true;
                } else if (choice == 0) {
                    userMenu();
                    return;
                }
            } catch (InputMismatchException e) {
                System.out.println("wrong input!");
                input.next();
            }
        }

        System.out.println("name of book: " + books.get(choice-1).getTitle());
        System.out.println("author: " + books.get(choice-1).getTitle());
        System.out.print("wanna return this book? (y/n) ");

        String s = input.nextLine();
        if(s.equals("y")){
            returnBook(books.get(choice-1));
        }
        else{
            userMenu();
            return;
        }

    }

    public void libraryBooks(){
        int count = 1;
        for(Book book : admin.getBooks()){
            if(book.isAvailable()) {
                System.out.println(count + ". " + book.getTitle());
                count++;
            }
        }

        if(count == 1){
            System.out.println("there is no book");
            System.out.println("press Enter");
            input.nextLine();
            userMenu();
            return;
        }
        else{
            System.out.println("choose one of the books");
            System.out.println("or...");
            System.out.println("Enter 0 for going back to user menu");
        }

        boolean validInput = false;
        int choice = 0;
        while (!validInput) {
            try {
                System.out.print("Enter your choice: ");
                choice = input.nextInt();
                if(choice > 0 && choice < count){
                    validInput = true;
                } else if (choice == 0) {
                    userMenu();
                    return;
                }
            } catch (InputMismatchException e) {
                System.out.println("wrong input!");
                input.next();
            }
        }
        int n = choice;
        for(int i = 0; n > 1; i++){
            if(admin.getBooks().get(i).isAvailable()){
                n--;
                choice = i;
            }
        }

        System.out.println("name of book: " + books.get(choice).getTitle());
        System.out.println("author: " + books.get(choice).getTitle());
        System.out.print("wanna borrow this book? (y/n) ");

        String s = input.nextLine();
        if(s.equals("y")){
            borrowBook(books.get(choice));
        }
        else{
            userMenu();
            return;
        }
    }


}