import java.util.Scanner;
import java.util.Optional;
import java.util.List;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Store store = new Store();

    public static void main(String[] args) {
        showMainMenu();
    }

    private static void showMainMenu() {
        while (true) {
            System.out.println("\n=== فروشگاه اینترنتی ===");
            System.out.println("1. مشاهده محصولات");
            System.out.println("2. ثبت نام مشتری جدید");
            System.out.println("3. ورود مشتری");
            System.out.println("4. خروج");
            System.out.print("لطفاً گزینه مورد نظر را انتخاب کنید: ");

            int choice = getIntInput(1, 4);

            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    registerCustomer();
                    break;
                case 3:
                    loginCustomer();
                    break;
                case 4:
                    System.out.println("با تشکر از شما. خداحافظ!");
                    System.exit(0);
            }
        }
    }

    private static void displayProducts() {
        List<Product> products = store.getProducts();
        if (products.isEmpty()) {
            System.out.println("هیچ محصولی در فروشگاه موجود نیست.");
            return;
        }

        System.out.println("\n--- محصولات موجود ---");
        products.forEach(System.out::println);
    }

    private static void registerCustomer() {
        System.out.println("\n--- ثبت نام مشتری جدید ---");
        scanner.nextLine();

        System.out.print("نام: ");
        String name = scanner.nextLine();

        System.out.print("ایمیل: ");
        String email = scanner.nextLine();

        System.out.print("آدرس: ");
        String address = scanner.nextLine();

        int newId = store.getNextCustomerId();
        Customer newCustomer = new Customer(newId, name, email, address);

        if (store.registerCustomer(newCustomer)) {
            System.out.println("ثبت نام با موفقیت انجام شد! شماره مشتری شما: " + newId);
            store = new Store();
        } else {
            System.out.println("خطا در ثبت نام مشتری!");
        }
    }

    private static void loginCustomer() {
        System.out.print("\nلطفاً شماره مشتری خود را وارد کنید: ");
        int customerId = getIntInput(1, Integer.MAX_VALUE);

        Optional<Customer> customer = store.findCustomerById(customerId);
        if (customer.isPresent()) {
            showCustomerMenu(customer.get());
        } else {
            System.out.println("مشتری با این شماره یافت نشد!");
        }
    }

    private static void showCustomerMenu(Customer customer) {
        while (true) {
            System.out.println("\n=== خوش آمدید " + customer.getName() + " ===");
            System.out.println("1. مشاهده محصولات");
            System.out.println("2. افزودن به سبد خرید");
            System.out.println("3. مشاهده سبد خرید");
            System.out.println("4. حذف از سبد خرید");
            System.out.println("5. ثبت سفارش");
            System.out.println("0. خروج");
            System.out.print("لطفاً گزینه مورد نظر را انتخاب کنید: ");

            int choice = getIntInput(0, 5);

            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    addToCart(customer);
                    break;
                case 3:
                    customer.viewCart();
                    break;
                case 4:
                    removeFromCart(customer);
                    break;
                case 5:
                    if (customer.placeOrder()) {
                        System.out.println("پرداخت با موفقیت انجام شد!");
                    }
                    break;
                case 0:
                    return;
            }
        }
    }

    private static void addToCart(Customer customer) {
        displayProducts();
        List<Product> products = store.getProducts();
        if (products.isEmpty()) {
            return;
        }

        System.out.print("لطفاً شماره محصول را وارد کنید: ");
        int productId = getIntInput(1, products.size());

        System.out.print("تعداد: ");
        int quantity = getIntInput(1, Integer.MAX_VALUE);

        Optional<Product> product = store.findProductById(productId);
        product.ifPresentOrElse(
                p -> customer.addToCart(p, quantity),
                () -> System.out.println("محصول یافت نشد!")
        );
    }

    private static void removeFromCart(Customer customer) {
        customer.viewCart();
        if (customer.getCart().getItems().isEmpty()) {
            return;
        }

        System.out.print("لطفاً شماره محصول را وارد کنید: ");
        int productId = getIntInput(1, store.getProducts().size());

        System.out.print("تعداد برای حذف: ");
        int quantity = getIntInput(1, Integer.MAX_VALUE);

        Optional<Product> product = store.findProductById(productId);
        product.ifPresentOrElse(
                p -> {
                    if (customer.removeFromCart(p, quantity)) {
                        System.out.println("محصول از سبد خرید حذف شد.");
                    } else {
                        System.out.println("خطا در حذف محصول!");
                    }
                },
                () -> System.out.println("محصول یافت نشد!")
        );
    }

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
}