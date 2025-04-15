public class Admin {
    public void addBook(Book book, Library library) {
        if(library.containsBook(book.getTitle())) {
            System.out.println("Book already exists in the library");
        }else {
            library.addBook(book);
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " was successfully added to library");
        }
    }
    public void removeBook(String name, Library library) {
        if(library.containsBook(name)) {
            library.removeBook(name);
            System.out.println(name + "was successfully removed from library");
        }else System.out.println("Book does not exist in the library");
    }
}
