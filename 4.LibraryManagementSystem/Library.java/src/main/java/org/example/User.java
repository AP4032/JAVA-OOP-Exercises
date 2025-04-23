package org.example;
public class User {
    private String name;
    private String username;
    private String password;

    public User(String username , String password) {
        this.name = username;
        this.username = username;
        this.password = password;
    }

    public boolean login(String inputUsername , String inputPassword){
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    public String getUsername(){
        return username;
    }
    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.borrowBook();
            System.out.println(name + " borrowed the book: " + book.getTitle());
        } else {
            System.out.println("Sorry, this book is already borrowed.");
        }
    }

    public void returnBook(Book book) {
        book.returnBook();
        System.out.println(name + " returned the book: " + book.getTitle());
    }
    public void searchBook(Book[] books , String search){
        boolean found = false;
        for (Book book : books){
            if (book.getTitle().equalsIgnoreCase(search) || book.getAuthor().equalsIgnoreCase(search)){
                found = true;
                System.out.println("Found: " + book.getTitle() + " by " + book.getAuthor());
            }
        }
        if (!found){
            System.out.println("No books found!");
        }
    }
}