package org.example;

public class Admin {
    private Book[] books = new Book[100];
    private int bookCount = 0;
    public void addBook(Book book){
        if (bookCount < books.length){
            books[bookCount++] = book;
            System.out.println("Added: " + book.getTitle());
        }else {
            System.out.println("Library is full!");
        }
    }
    public void removeBook(String title){
        for (int i = 0; i < bookCount; i++){
            if (books[i].getTitle().equalsIgnoreCase(title)){
                for (int j = 0; j < bookCount - 1; j++){
                    books[j] = books[j + 1];
                }
                bookCount--;
                System.out.println("Removed: " + title);
                return;
            }
        }
        System.out.println("Book not found!");
    }
    public Book[] getBooks(){
        Book[] result = new Book[bookCount];
        for (int i = 0; i < bookCount; i++){
            result[i] = books[i];
        }
        return result;
    }
}
