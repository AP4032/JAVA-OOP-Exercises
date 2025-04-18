import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private String fullName;
    private String phoneNumber;
    private boolean isAdmin;
    private List<Book> borrowedBooks;

    public User(String username, String password, String fullName, String phoneNumber, boolean isAdmin) {
        setUsername(username);
        setPassword(password);
        setFullName(fullName);
        setPhoneNumber(phoneNumber);
        this.isAdmin = isAdmin;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getter methods
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getFullName() { return fullName; }
    public String getPhoneNumber() { return phoneNumber; }
    public boolean isAdmin() { return isAdmin; }
    public List<Book> getBorrowedBooks() { return new ArrayList<>(borrowedBooks); }

    // Setter methods with validation
    public void setUsername(String username) {
        if (username != null && !username.trim().isEmpty()) {
            this.username = username.trim().toLowerCase();
        }
    }

    public void setPassword(String password) {
        if (password != null && password.length() >= 6) {
            this.password = password;
        }
    }

    public void setFullName(String fullName) {
        if (fullName != null && !fullName.trim().isEmpty()) {
            this.fullName = fullName.trim();
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && phoneNumber.matches("09\\d{9}")) {
            this.phoneNumber = phoneNumber;
        }
    }

    // User operations
    public boolean borrowBook(Book book) {
        if (book != null && book.isAvailable() && !borrowedBooks.contains(book)) {
            if (book.borrowBook(this)) {
                borrowedBooks.add(book);
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(Book book) {
        if (book != null && borrowedBooks.contains(book)) {
            if (book.returnBook()) {
                borrowedBooks.remove(book);
                return true;
            }
        }
        return false;
    }

    public void displayBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("\nشما هیچ کتابی امانت نگرفته‌اید.");
            return;
        }

        System.out.println("\n--- کتاب‌های امانت گرفته شده توسط شما ---");
        for (int i = 0; i < borrowedBooks.size(); i++) {
            Book book = borrowedBooks.get(i);
            System.out.printf("%d. %s - %s (شابک: %s)%n",
                    i+1, book.getTitle(), book.getAuthor(), book.getIsbn());
        }
    }

    @Override
    public String toString() {
        return String.format("%s (%s) | تلفن: %s | نوع: %s",
                fullName, username, phoneNumber,
                isAdmin ? "مدیر" : "کاربر عادی");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }
}