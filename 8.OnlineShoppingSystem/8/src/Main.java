import java.util.Scanner;

public class Main {
    private static final Store store = new Store();
    private static final Authentication auth = new Authentication();
    private static final Scanner scanner = new Scanner(System.in);
    private static Customer currentCustomer = null;

    public static void main(String[] args) {
        showMainMenu();
    }

    private static void showMainMenu() {
        while (true) {
            System.out.println("\n=== Online Shopping System ===");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    handleLogin();
                    break;
                case 2:
                    handleRegistration();
                    break;
                case 3:
                    System.out.println("Thank you for shopping with us!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void handleLogin() {
        System.out.print("\nEmail: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        currentCustomer = auth.login(email, password);
        if (currentCustomer != null) {
            showCustomerMenu();
        }
    }

    private static void handleRegistration() {
        System.out.print("\nName: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        Customer newCustomer = new Customer(
                "CUST" + System.currentTimeMillis(),
                name, email, password
        );
        auth.registerCustomer(newCustomer);
        System.out.println("Registration successful!");
    }

    private static void showCustomerMenu() {
        while (currentCustomer != null) {
            System.out.println("\nWelcome, " + currentCustomer.getName() + "!");
            System.out.println("1. Browse Products");
            System.out.println("2. View Cart");
            System.out.println("3. Checkout");
            System.out.println("4. Order History");
            System.out.println("5. Logout");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    browseProducts();
                    break;
                case 2:
                    currentCustomer.viewCart();
                    break;
                case 3:
                    processCheckout();
                    break;
                case 4:
                    currentCustomer.viewOrderHistory();
                    break;
                case 5:
                    currentCustomer = null;
                    System.out.println("Logged out successfully.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void browseProducts() {
        store.displayAllCategories();
        System.out.print("\nEnter category: ");
        String category = scanner.nextLine();
        store.displayProductsByCategory(category);

        System.out.print("\nEnter product ID to add to cart (or 'back'): ");
        String productId = scanner.nextLine();

        if (!productId.equalsIgnoreCase("back")) {
            Product product = store.findProductById(productId);
            if (product != null) {
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();
                currentCustomer.addToCart(product, quantity);
            }
        }
    }

    private static void processCheckout() {
        if (currentCustomer.getCart().getItems().isEmpty()) {
            System.out.println("Your cart is empty!");
            return;
        }

        currentCustomer.viewCart();
        System.out.println("\n1. Credit Card\n2. PayPal");
        System.out.print("Select payment: ");
        int paymentChoice = scanner.nextInt();
        scanner.nextLine();

        Payment payment = createPayment(paymentChoice);
        if (payment != null && payment.processPayment()) {
            currentCustomer.placeOrder(payment);
        }
    }

    private static Payment createPayment(int choice) {
        System.out.print("Amount: $" + currentCustomer.getCart().calculateTotal() + "\n");

        switch (choice) {
            case 1:
                System.out.print("Card number: ");
                String cardNumber = scanner.nextLine();
                System.out.print("Expiry (MM/YY): ");
                String expiry = scanner.nextLine();
                System.out.print("CVV: ");
                String cvv = scanner.nextLine();
                return new CreditCardPayment(
                        currentCustomer.getCart().calculateTotal(),
                        cardNumber, expiry, cvv
                );
            case 2:
                System.out.print("PayPal email: ");
                String email = scanner.nextLine();
                return new PayPalPayment(
                        currentCustomer.getCart().calculateTotal(),
                        email
                );
            default:
                System.out.println("Invalid payment method.");
                return null;
        }
    }
}