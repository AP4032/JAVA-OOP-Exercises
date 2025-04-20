import java.util.Scanner;
import java.util.List;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.io.PrintStream;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Library library = new Library();

    public static void main(String[] args) {
        // تنظیم encoding برای پشتیبانی از فارسی
        try {
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
        } catch (UnsupportedEncodingException e) {
            System.err.println("خطا در تنظیم encoding: " + e.getMessage());
        }

        showMainMenu();
    }

    private static void showMainMenu() {
        while (true) {
            System.out.println("\n=== سیستم مدیریت کتابخانه ===");
            System.out.println("1. ورود به سیستم");
            System.out.println("2. ثبت نام کاربر جدید");
            System.out.println("3. خروج");
            System.out.print("لطفاً گزینه مورد نظر را انتخاب کنید: ");

            int choice = getIntInput(1, 3);

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    System.out.println("\nبا تشکر از استفاده شما. خداحافظ!");
                    System.exit(0);
            }
        }
    }

    private static void register() {
        System.out.println("\n=== ثبت نام کاربر جدید ===");

        String username = getNonEmptyInput("نام کاربری: ");

        // بررسی تکراری نبودن نام کاربری
        if (library.getUsers().stream().anyMatch(u -> u.getUsername().equals(username))) {
            System.out.println("\nاین نام کاربری قبلاً ثبت شده است.");
            return;
        }

        String password = getNonEmptyInput("رمز عبور (حداقل 6 کاراکتر): ");
        if (password.length() < 6) {
            System.out.println("\nرمز عبور باید حداقل 6 کاراکتر باشد.");
            return;
        }

        String fullName = getNonEmptyInput("نام کامل: ");
        String phoneNumber = getNonEmptyInput("شماره تلفن (11 رقمی با 09 شروع شود): ");
        if (!phoneNumber.matches("09\\d{9}")) {
            System.out.println("\nشماره تلفن نامعتبر است!");
            return;
        }

        User newUser = new User(username, password, fullName, phoneNumber, false);
        if (library.addUser(newUser)) {
            System.out.println("\nثبت نام با موفقیت انجام شد. اکنون می‌توانید وارد سیستم شوید.");
        } else {
            System.out.println("\nخطا در ثبت نام کاربر.");
        }
    }

    private static void login() {
        System.out.print("\nنام کاربری: ");
        String username = scanner.nextLine().trim();
        System.out.print("رمز عبور: ");
        String password = scanner.nextLine().trim();

        User user = library.login(username, password);
        if (user != null) {
            library.setCurrentUser(user);
            System.out.println("\nخوش آمدید، " + user.getFullName() + "!");
            if (user.isAdmin()) {
                showAdminMenu();
            } else {
                showUserMenu();
            }
        } else {
            System.out.println("\nنام کاربری یا رمز عبور اشتباه است!");
        }
    }

    private static void showAdminMenu() {
        while (library.getCurrentUser() != null) {
            System.out.println("\n=== منوی مدیریت ===");
            System.out.println("1. مدیریت کتاب‌ها");
            System.out.println("2. مدیریت کاربران");
            System.out.println("3. نمایش گزارشات");
            System.out.println("0. خروج از حساب کاربری");
            System.out.print("لطفاً گزینه مورد نظر را انتخاب کنید: ");

            int choice = getIntInput(0, 3);

            switch (choice) {
                case 1:
                    manageBooks();
                    break;
                case 2:
                    manageUsers();
                    break;
                case 3:
                    showReports();
                    break;
                case 0:
                    library.logout();
                    System.out.println("\nبا موفقیت از حساب کاربری خارج شدید.");
                    return;
            }
        }
    }

    private static void showUserMenu() {
        while (library.getCurrentUser() != null) {
            System.out.println("\n=== منوی کاربری ===");
            System.out.println("1. جستجوی کتاب");
            System.out.println("2. نمایش کتاب‌های امانت گرفته شده");
            System.out.println("3. امانت گرفتن کتاب");
            System.out.println("4. بازگرداندن کتاب");
            System.out.println("0. خروج از حساب کاربری");
            System.out.print("لطفاً گزینه مورد نظر را انتخاب کنید: ");

            int choice = getIntInput(0, 4);

            switch (choice) {
                case 1:
                    searchBooks();
                    break;
                case 2:
                    library.getCurrentUser().displayBorrowedBooks();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 0:
                    library.logout();
                    System.out.println("\nبا موفقیت از حساب کاربری خارج شدید.");
                    return;
            }
        }
    }

    private static void manageBooks() {
        while (true) {
            System.out.println("\n=== مدیریت کتاب‌ها ===");
            System.out.println("1. افزودن کتاب جدید");
            System.out.println("2. حذف کتاب");
            System.out.println("3. نمایش تمام کتاب‌ها");
            System.out.println("4. جستجوی کتاب");
            System.out.println("0. بازگشت به منوی قبلی");
            System.out.print("لطفاً گزینه مورد نظر را انتخاب کنید: ");

            int choice = getIntInput(0, 4);

            switch (choice) {
                case 1:
                    addNewBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    displayAllBooks();
                    break;
                case 4:
                    searchBooks();
                    break;
                case 0:
                    return;
            }
        }
    }

    private static void manageUsers() {
        while (true) {
            System.out.println("\n=== مدیریت کاربران ===");
            System.out.println("1. افزودن کاربر جدید");
            System.out.println("2. نمایش تمام کاربران");
            System.out.println("3. حذف کاربر");
            System.out.println("0. بازگشت به منوی قبلی");
            System.out.print("لطفاً گزینه مورد نظر را انتخاب کنید: ");

            int choice = getIntInput(0, 3);

            switch (choice) {
                case 1:
                    addNewUser();
                    break;
                case 2:
                    displayAllUsers();
                    break;
                case 3:
                    removeUser();
                    break;
                case 0:
                    return;
            }
        }
    }

    private static void showReports() {
        List<Book> books = library.getBooks();
        List<User> users = library.getUsers();

        long availableBooks = books.stream().filter(Book::isAvailable).count();
        long borrowedBooks = books.size() - availableBooks;

        System.out.println("\n=== گزارشات کتابخانه ===");
        System.out.println("تعداد کل کتاب‌ها: " + books.size());
        System.out.println("تعداد کتاب‌های موجود: " + availableBooks);
        System.out.println("تعداد کتاب‌های امانت داده شده: " + borrowedBooks);
        System.out.println("تعداد کاربران: " + users.size());
        System.out.println("تعداد مدیران: " + users.stream().filter(User::isAdmin).count());
    }

    private static void addNewBook() {
        System.out.println("\n=== افزودن کتاب جدید ===");

        String title = getNonEmptyInput("عنوان کتاب: ");
        String author = getNonEmptyInput("نویسنده: ");
        String isbn = getNonEmptyInput("شابک: ");

        Book newBook = new Book(title, author, isbn);
        if (library.addBook(newBook)) {
            System.out.println("\nکتاب با موفقیت اضافه شد.");
        } else {
            System.out.println("\nخطا در افزودن کتاب (کتابی با این شابک قبلاً وجود دارد).");
        }
    }

    private static void removeBook() {
        List<Book> books = library.getBooks();
        if (books.isEmpty()) {
            System.out.println("\nهیچ کتابی در کتابخانه وجود ندارد.");
            return;
        }

        displayAllBooks();
        System.out.print("\nشماره کتاب مورد نظر برای حذف (0 برای انصراف): ");
        int index = getIntInput(0, books.size());

        if (index == 0) return;

        Book bookToRemove = books.get(index - 1);
        if (library.removeBook(bookToRemove)) {
            System.out.println("\nکتاب با موفقیت حذف شد.");
        } else if (!bookToRemove.isAvailable()) {
            System.out.println("\nاین کتاب هم اکنون امانت داده شده و نمی‌توان آن را حذف کرد.");
        } else {
            System.out.println("\nخطا در حذف کتاب.");
        }
    }

    private static void displayAllBooks() {
        List<Book> books = library.getBooks();
        if (books.isEmpty()) {
            System.out.println("\nهیچ کتابی در کتابخانه وجود ندارد.");
            return;
        }

        System.out.println("\n=== فهرست کتاب‌ها ===");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    private static void searchBooks() {
        String keyword = getNonEmptyInput("\nعبارت جستجو (عنوان، نویسنده یا شابک): ");
        List<Book> results = library.searchBooks(keyword);

        if (results.isEmpty()) {
            System.out.println("\nهیچ کتابی با این مشخصات یافت نشد.");
        } else {
            System.out.println("\n=== نتایج جستجو ===");
            for (int i = 0; i < results.size(); i++) {
                System.out.println((i + 1) + ". " + results.get(i));
            }
        }
    }

    private static void addNewUser() {
        System.out.println("\n=== افزودن کاربر جدید ===");

        String username = getNonEmptyInput("نام کاربری: ");
        String password = getNonEmptyInput("رمز عبور (حداقل 6 کاراکتر): ");
        String fullName = getNonEmptyInput("نام کامل: ");
        String phoneNumber = getNonEmptyInput("شماره تلفن (11 رقمی با 09 شروع شود): ");

        System.out.print("آیا مدیر است؟ (y/n): ");
        boolean isAdmin = scanner.nextLine().trim().equalsIgnoreCase("y");

        User newUser = new User(username, password, fullName, phoneNumber, isAdmin);
        if (library.addUser(newUser)) {
            System.out.println("\nکاربر با موفقیت اضافه شد.");
        } else {
            System.out.println("\nخطا در افزودن کاربر (کاربری با این نام کاربری قبلاً وجود دارد).");
        }
    }

    private static void displayAllUsers() {
        List<User> users = library.getUsers();
        if (users.isEmpty()) {
            System.out.println("\nهیچ کاربری ثبت نشده است.");
            return;
        }

        System.out.println("\n=== فهرست کاربران ===");
        for (int i = 0; i < users.size(); i++) {
            System.out.println((i + 1) + ". " + users.get(i));
        }
    }

    private static void removeUser() {
        List<User> users = library.getUsers();
        if (users.isEmpty()) {
            System.out.println("\nهیچ کاربری ثبت نشده است.");
            return;
        }

        displayAllUsers();
        System.out.print("\nشماره کاربر مورد نظر برای حذف (0 برای انصراف): ");
        int index = getIntInput(0, users.size());

        if (index == 0) return;

        User userToRemove = users.get(index - 1);
        if (library.removeUser(userToRemove)) {
            System.out.println("\nکاربر با موفقیت حذف شد.");
        } else if (userToRemove.equals(library.getCurrentUser())) {
            System.out.println("\nنمی‌توانید حساب خود را حذف کنید!");
        } else {
            System.out.println("\nخطا در حذف کاربر.");
        }
    }

    private static void borrowBook() {
        String keyword = getNonEmptyInput("\nعبارت جستجو برای کتاب مورد نظر: ");
        List<Book> results = library.searchBooks(keyword);

        if (results.isEmpty()) {
            System.out.println("\nهیچ کتابی با این مشخصات یافت نشد.");
            return;
        }

        System.out.println("\n=== نتایج جستجو ===");
        for (int i = 0; i < results.size(); i++) {
            System.out.println((i + 1) + ". " + results.get(i));
        }

        System.out.print("\nشماره کتاب مورد نظر برای امانت (0 برای انصراف): ");
        int index = getIntInput(0, results.size());

        if (index == 0) return;

        Book selectedBook = results.get(index - 1);
        if (library.getCurrentUser().borrowBook(selectedBook)) {
            System.out.println("\nکتاب با موفقیت امانت گرفته شد.");
        } else {
            System.out.println("\nامکان امانت گرفتن این کتاب وجود ندارد.");
        }
    }

    private static void returnBook() {
        User currentUser = library.getCurrentUser();
        List<Book> borrowedBooks = currentUser.getBorrowedBooks();

        if (borrowedBooks.isEmpty()) {
            System.out.println("\nشما هیچ کتابی امانت نگرفته‌اید.");
            return;
        }

        currentUser.displayBorrowedBooks();
        System.out.print("\nشماره کتاب مورد نظر برای بازگرداندن (0 برای انصراف): ");
        int index = getIntInput(0, borrowedBooks.size());

        if (index == 0) return;

        Book bookToReturn = borrowedBooks.get(index - 1);
        if (currentUser.returnBook(bookToReturn)) {
            System.out.println("\nکتاب با موفقیت بازگردانده شد.");
        } else {
            System.out.println("\nخطا در بازگرداندن کتاب.");
        }
    }

    // Helper methods
    private static int getIntInput(int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.printf("لطفاً عددی بین %d تا %d وارد کنید: ", min, max);
            } catch (NumberFormatException e) {
                System.out.print("ورودی نامعتبر! لطفاً یک عدد وارد کنید: ");
            }
        }
    }

    private static String getNonEmptyInput(String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("این فیلد نمی‌تواند خالی باشد!");
            }
        } while (input.isEmpty());
        return input;
    }
}