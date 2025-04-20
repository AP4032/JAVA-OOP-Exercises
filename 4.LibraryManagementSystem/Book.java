public class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;

    }



    public String getTitle() {
        return title;
    }

    public String getauthor() {
        return author;
    }



    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            //  book.borrowBook();
            book.setAvailable(false);
        } else {
            System.out.println("Sorry, this book is already borrowed.");
        }
    }
    /*
        public void borrowBook() {
            if (isAvailable) {
                isAvailable = false;
            }
            else {
                System.out.println("Book is not available");
            }
        }
    */
    public void returnBook(Book book ) {
        if (book.isAvailable()) {
            System.out.println("the book was not lent ");
        } else {
            book.setAvailable(true);
        }    }
}