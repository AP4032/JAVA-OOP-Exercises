# Library Management System 📚

## Overview
This is a **Library Management System** built using **OOP principles in Java**. It allows users to borrow and return books, and enables an admin to manage the library collection.

## Features
- Users can borrow and return books.
- Admin can add/remove books.
- Track availability of books.

## Classes & Structure
```plaintext
LibraryManagementSystem
 ├── Book
 ├── User
 ├── Admin
 ├── Library
 ├── Main (Runner)
```

## Implementation

### `Book.java`
```java
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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
        }
    }

    public void returnBook() {
        isAvailable = true;
    }
}
```

### `User.java`
```java
public class User {
    private String name;

    public User(String name) {
        this.name = name;
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
}
```

### `Admin.java`
```java
import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Book> books;

    public Admin() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added book: " + book.getTitle());
    }

    public void removeBook(Book book) {
        books.remove(book);
        System.out.println("Removed book: " + book.getTitle());
    }

    public List<Book> getBooks() {
        return books;
    }
}
```

### `Main.java`
```java
public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        Book book1 = new Book("1984", "George Orwell");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");

        admin.addBook(book1);
        admin.addBook(book2);

        User user = new User("Alice");
        user.borrowBook(book1);
        user.returnBook(book1);
    }
}
```

## How to Run
1. If you use new versions of java you can compile and run your code with this command in the terminal that is in your folder path:
   ```bash
   java fileName.java
   ```

## Future Enhancements
- Implement a search system for books.
- Add user authentication.
- Implement overdue book tracking.

---
📖 **Manage your library with ease!** 🎓
