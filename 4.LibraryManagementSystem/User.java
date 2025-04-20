import java.util.ArrayList;
import java.util.List ;

public class User {
    private String name;
    List <Book> borrowedbooks ;

    public User(String name) {
        this.name = name;
        this.borrowedbooks = new ArrayList<Book>();
    }
    public List<Book>  getborrowedbooks() {
        return borrowedbooks;
    }
    public void addbookborrow(Book bookb) {
        borrowedbooks.add(bookb);
    }

    public void removebookreturner(Book bookb) {
        borrowedbooks.remove(bookb);
    }





    public String getname (){
        return name;
    }
/*
    public void returnBook(Book book) {
        book.returnBook(book);
        System.out.println(name + " returned the book: " + book.getTitle());
    }*/
}