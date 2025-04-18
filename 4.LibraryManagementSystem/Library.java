import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;
    private List<User> users;
    private User currentUser;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.currentUser = null;
        initializeSampleData();
    }

    private void initializeSampleData() {
        // افزودن کاربران نمونه
        addUser(new User("admin", "admin123", "مدیر سیستم", "09123456789", true));
        addUser(new User("user1", "pass123", "کاربر نمونه", "09129876543", false));

        // افزودن کتاب‌های نمونه
        addBook(new Book("1984", "جرج اورول", "978-964-5560-12-5"));
        addBook(new Book("کشتن مرغ مقلد", "هارپر لی", "978-964-5560-34-7"));
        addBook(new Book("شازده کوچولو", "آنتوان دوسنت اگزوپری", "978-964-5560-56-9"));
    }

    // Book operations
    public boolean addBook(Book book) {
        if (book != null && !books.contains(book)) {
            books.add(book);
            return true;
        }
        return false;
    }

    public boolean removeBook(Book book) {
        if (book != null && books.contains(book)) {
            if (!book.isAvailable()) {
                return false;
            }
            return books.remove(book);
        }
        return false;
    }

    public List<Book> searchBooks(String keyword) {
        String lowerKeyword = keyword.toLowerCase();
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(lowerKeyword) ||
                        book.getAuthor().toLowerCase().contains(lowerKeyword) ||
                        book.getIsbn().contains(lowerKeyword))
                .collect(Collectors.toList());
    }

    // User operations
    public User login(String username, String password) {
        if (username == null || password == null) return null;

        return users.stream()
                .filter(user -> user.getUsername().equals(username.toLowerCase()) &&
                        user.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    public void logout() {
        currentUser = null;
    }

    public boolean addUser(User user) {
        if (user != null && !users.contains(user)) {
            users.add(user);
            return true;
        }
        return false;
    }

    public boolean removeUser(User user) {
        if (user != null && users.contains(user) && !user.equals(currentUser)) {
            return users.remove(user);
        }
        return false;
    }

    // Getter methods
    public List<Book> getBooks() { return new ArrayList<>(books); }
    public List<User> getUsers() { return new ArrayList<>(users); }
    public User getCurrentUser() { return currentUser; }
    public void setCurrentUser(User user) { this.currentUser = user; }
}