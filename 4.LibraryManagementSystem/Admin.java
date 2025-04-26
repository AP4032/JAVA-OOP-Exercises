public class Admin {
    private Library library;

    public Admin(Library library) {
        this.library = library;
    }

    // Add a book to the library
    public void addBook(Book book) {
        library.addBook(book);
    }

    // Remove a book from the library
    public void removeBook(Book book) {
        library.removeBook(book);
    }

    // View all books in the library
    public void viewBooks() {
        library.viewAllBooks();
    }

    // Manage users (e.g., add/remove users)
    public void manageUsers(User user, boolean isAdding) {
        if (isAdding) {
            library.addUser(user);
        } else {
            library.removeUser(user);
        }
    }

    // View all users in the library
    public void viewUsers() {
        library.viewAllUsers();
    }

    // Add or remove admins
    public void manageAdmins(Admin admin, boolean isAdding) {
        if (isAdding) {
            library.addAdmin(admin);
        } else {
            library.removeAdmin(admin);
        }
    }

    // View all admins in the library
    public void viewAdmins() {
        library.viewAllAdmins();
    }
}
