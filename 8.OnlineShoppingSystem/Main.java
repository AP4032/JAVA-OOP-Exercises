import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create store and products
        Store store = new Store();
        Product laptop = new Product("Laptop", 999.99, 10);
        Product phone = new Product("Smartphone", 499.99, 15);

        store.addProduct(laptop);
        store.addProduct(phone);

        // Initialize Authentication system
        AuthenticationSystem authSystem = new AuthenticationSystem();
        authSystem.registerUser("alice", "password123");
        authSystem.registerUser("bob", "password456");

        // Initialize scanner for user input
        Scanner scanner = new Scanner(System.in);
        Customer loggedInCustomer = null;

        while (true) {
            System.out.println("\n--- Online Shopping System ---");
            System.out.println("1. Log in");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            if (choice == 1) {
                // Log in
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                // Authenticate user
                if (authSystem.authenticate(username, password)) {
                    System.out.println("Login successful!");
                    loggedInCustomer = new Customer(username);  // Create customer object on successful login
                    break;
                } else {
                    System.out.println("Invalid credentials. Please try again.");
                }
            } else if (choice == 2) {
                System.out.println("Exiting...");
                System.exit(0);
            }
        }

        // Main menu for logged in customer
        while (true) {
            System.out.println("\nWelcome to the Store, " + loggedInCustomer.getName() + "!");
            System.out.println("1. View products");
            System.out.println("2. Add to cart");
            System.out.println("3. view cart");
            System.out.println("4. Place order");
            System.out.println("5. View order history");
            System.out.println("6. Log out");
            System.out.print("Enter your choice: ");
            int menuChoice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (menuChoice) {
                case 1:
                    // View products
                    System.out.println("Available products:");
                    for (Product product : store.getProducts()) {
                        product.displayProductDetails();
                    }
                    break;

                case 2:
                    // Add product to cart
                    System.out.print("Enter product name to add to cart: ");
                    String productName = scanner.nextLine();
                    boolean productFound = false;
                    for (Product product : store.getProducts()) {
                        if (product.getName().equalsIgnoreCase(productName)) {
                            System.out.print("Enter quantity: ");
                            int quantity = scanner.nextInt();
                            loggedInCustomer.addToCart(product, quantity);
                            productFound = true;
                            break;
                        }
                    }
                    if (!productFound) {
                        System.out.println("Product not found.");
                    }
                    break;


                case 3:
                    System.out.println("products in the cart: \n");
                    loggedInCustomer.viewCart();
                    break;




                case 4:
                    // Place order
                    loggedInCustomer.placeOrder();
                    break;

                case 5:
                    // View order history
                    loggedInCustomer.showOrderHistory();
                    break;

                case 6:
                    // Log out
                    System.out.println("Logged out successfully!");
                    loggedInCustomer = null;  // Clear the customer object on log out
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (loggedInCustomer == null) {
                break;
            }
        }

        scanner.close();
    }
}
