
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();
        Admin admin = new Admin();
        String title ;
        String author;

        boolean running = true ;
        while(running) {
            System.out.println("======== Library Management System ========");
            System.out.println("1. Add an user");
            System.out.println("2. Add Book");
            System.out.println("3. remove Book");
            System.out.println("4. borrow book");
            System.out.println("5. return book");
            System.out.println("6. list of books");
            System.out.println("7. list of users");
            System.out.println("8. search book");
            System.out.println("9. exit");
            System.out.println("enter your choice :");
            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("enter the name of user :");
                    input.nextLine();
                    String name = input.nextLine();
                    admin.adduser(name);
                    break;

                case 2:
                    System.out.println("Enter book title :");
                    input.nextLine();
                    title = input.nextLine();
                    System.out.println("Enter book author :");

                    author = input.nextLine();
                    Book book = new Book(title, author);
                    admin.addBook(book);
                    break;

                case 3:
                    System.out.println("Enter book title :");
                    input.nextLine();
                    title = input.nextLine();
                    System.out.println("Enter book author :");
                    author = input.nextLine();
                    Book bookremover = null ;
                    for(Book removebook : admin.getBooks()){
                        if(title.equals(removebook.getTitle()) && author.equals(removebook.getauthor())){
                            bookremover = removebook;
                        }
                    }
                    if(bookremover == null){
                        System.out.println("Book not found");
                    }
                    else{
                        admin.removeBook(bookremover);
                    }

                    break;

                case 4:
                    System.out.println("enter user name :");
                    input.nextLine();
                    String userborrowername =  input.nextLine();
                    User userborrower = null;

                    for(User userss : admin.getusers()) {
                        if(userss.getname().equals(userborrowername)) {
                            userborrower = userss;
                        }
                    }
                    if(userborrower == null) {
                        System.out.println("user not found");
                    }
                    else {
                        System.out.println("Enter book title :");
                        //   input.nextLine();
                        title = input.nextLine();
                        System.out.println("Enter book author :");
                        author = input.nextLine();
                        Book bookborrower = null ;
                        for(Book borrowbookk : admin.getBooks()){
                            if(title.equals(borrowbookk.getTitle()) && author.equals(borrowbookk.getauthor())){
                                bookborrower = borrowbookk;
                            }
                        }
                        if(bookborrower == null){
                            System.out.println("Book not found");
                        }
                        else{
                            bookborrower.borrowBook(bookborrower );
                            userborrower.addbookborrow(bookborrower);
                            System.out.println("user" +  userborrower.getname() + " borrowed "+ bookborrower.getTitle());
                        }

                    }

                    break;

                case 5:
                    System.out.println("enter user name :");
                    input.nextLine();
                    String userreturnername =  input.nextLine();
                    User userreturner = null;

                    for(User userss : admin.getusers()) {
                        if(userss.getname().equals(userreturnername)) {
                            userreturner = userss;
                        }
                    }
                    if(userreturner == null) {
                        System.out.println("user not found");
                    }
                    else {
                        System.out.println("Enter book title :");
                        input.nextLine();
                        title = input.nextLine();
                        System.out.println("Enter book author :");
                        author = input.nextLine();
                        Book bookreturner = null ;
                        for(Book returnbookk : admin.getBooks()){
                            if(title.equals(returnbookk.getTitle()) && author.equals(returnbookk.getauthor())){
                                bookreturner = returnbookk;
                            }
                        }
                        if(bookreturner == null){
                            System.out.println("Book not found");
                        }
                        else{
                            bookreturner.returnBook(bookreturner);
                            userreturner.removebookreturner(bookreturner);
                            System.out.println("user" +  userreturner.getname() + " returned "+ bookreturner.getTitle());
                        }

                    }
                    break;
                case 6:
                    admin.printbooks();
                    break;
                case 7:
                    admin.printplayers();
                    break;

                case 8 :
                    System.out.println("Enter book title :");
                    input.nextLine();
                    title = input.nextLine();
                    System.out.println("Enter book author :");
                    author = input.nextLine();
                    Book booksearcher = null ;
                    for(Book searchbook : admin.getBooks()){
                        if(title.equals(searchbook.getTitle()) && author.equals(searchbook.getauthor())){
                            booksearcher = searchbook;
                        }
                    }
                    if(booksearcher == null){
                        System.out.println("Book not found");
                    }
                    else{
                        String x = " ";
                        if(booksearcher.isAvailable()==false){
                            x = " not " ;
                        }
                        System.out.println(title + " from "+ author + "is" + x +"available");
                        booksearcher.borrowBook(booksearcher);
                    }
                    break;
                case 9:
                    running = false;
                    System.out.println("Exiting... Goodbye!");
                    break;


                default:
                    System.out.println("Invalid choice");
            }

        }
    }
}