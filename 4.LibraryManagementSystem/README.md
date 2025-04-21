# Library Management System 📚

## Overview
This is a **Library Management System** built using **OOP principles in Java**. It allows users to borrow and return books, and enables an library to manage the library collection.

## Features
- Users can borrow and return books.
- Library can add/remove books.
- Track availability of books.

## Classes & Structure
```plaintext
LibraryManagementSystem
 ├── Manga
 ├── User
 ├── Library
 ├── Library
 ├── Main (Runner)
```

## Implementation

### `Manga.java`
```java
public class Manga {
    private String title;
    private String author;
    private boolean isAvailable;

    public Manga(String title, String author) {
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

   public void borrowBook(Manga manga) {
      if (manga.isAvailable()) {
         manga.borrowManga();
         System.out.println(name + " borrowed the manga: " + manga.getTitle());
      } else {
         System.out.println("Sorry, this manga is already borrowed.");
      }
   }

   public void returnBook(Manga manga) {
      manga.returnManga();
      System.out.println(name + " returned the manga: " + manga.getTitle());
   }
}
```

### `Library.java`

```java
import java.util.ArrayList;
import java.util.List;

public class Library {
   private List<Manga> mangas;

   public Library() {
      this.books = new ArrayList<>();
   }

   public void addBook(Manga manga) {
      books.add(manga);
      System.out.println("Added manga: " + manga.getTitle());
   }

   public void removeBook(Manga manga) {
      books.remove(manga);
      System.out.println("Removed manga: " + manga.getTitle());
   }

   public List<Manga> getBooks() {
      return books;
   }
}
```

### `Main.java`

```java
public class Main {
   public static void main(String[] args) {
      Library library = new Library();
      Manga manga1 = new Manga("1984", "George Orwell");
      Manga manga2 = new Manga("To Kill a Mockingbird", "Harper Lee");

      library.addManga(manga1);
      library.addManga(manga2);

      User user = new User("Alice");
      user.borrowManga(manga1);
      user.returnManga(manga1);
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
- Implement overdue manga tracking.

---
📖 **Manage your library with ease!** 🎓
