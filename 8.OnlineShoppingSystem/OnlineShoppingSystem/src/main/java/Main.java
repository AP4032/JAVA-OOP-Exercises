import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        UserManager userManager = new UserManager();
        Store store = new Store();
        Customer customer = null;

        System.out.println("Welcome to the  Online Shopping System!");

        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Add Product to Store");
            System.out.println("4. View Products");
            System.out.println("5. Add Product to Cart");
            System.out.println("6. View Cart");
            System.out.println("7. Checkout and Make Payment");
            System.out.println("8. Add Funds to Wallet");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    // Register
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter your phone number: ");
                    String phoneNumber = scanner.nextLine();  // Get phone number
                    if (userManager.registerUser(username, password)) {
                        // Create a new customer with the provided phone number
                        customer = new Customer(username, phoneNumber, 0.0);
                        System.out.println("Registration successful!");
                    }
                    break;

                case 2:
                    // Login
                    if (customer == null) {
                        System.out.println("Please register first.");
                        break;
                    }
                    System.out.print("Username: ");
                    username = scanner.nextLine();
                    System.out.print("Password: ");
                    password = scanner.nextLine();
                    if (userManager.loginUser(username, password)) {
                        customer = new Customer(username, "0000000000", 1000.0); // Initialize wallet with $1000
                    }
                    break;

                case 3:
                    // Add product to store
                    System.out.print("Enter the product name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter the product price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter the product quantity: ");
                    int quantityToAdd = scanner.nextInt();
                    store.addProduct(new Product(productName, price, quantityToAdd));
                    break;

                case 4:
                    // View products
                    store.showProducts();
                    break;

                case 5:
                    // Add product to cart
                    if (customer == null) {
                        System.out.println("Please log in first.");
                        break;
                    }
                    System.out.print("Enter the product ID to add: ");
                    int productId = scanner.nextInt();
                    System.out.print("Quantity: ");
                    int quantity = scanner.nextInt();
                    Product product = store.getProductById(productId);
                    if (product != null) {
                        customer.addToCart(product, quantity);
                    }
                    break;

                case 6:
                    // View cart
                    if (customer == null) {
                        System.out.println("Please log in first.");
                        break;
                    }
                    customer.viewCart();
                    break;

                case 7:
                    // Checkout and make payment
                    if (customer == null) {
                        System.out.println("Please log in first.");
                        break;
                    }
                    double totalAmount = customer.getShoppingCart().calculateTotal();
                    if (totalAmount == 0) {
                        System.out.println("Your cart is empty. Please add items to your cart.");
                        break;
                    }
                    System.out.println("Your cart total is: $" + totalAmount);
                    System.out.println("Do you want to proceed with payment? (y/n)");
                    String confirmation = scanner.nextLine();
                    if (confirmation.equalsIgnoreCase("y")) {
                        if (customer.getWalletBalance() >= totalAmount) {
                            customer.getShoppingCart().checkout();
                            customer.setWalletBalance(customer.getWalletBalance() - totalAmount);
                            System.out.println("Payment successful! Remaining wallet balance: $" + customer.getWalletBalance());
                        } else {
                            System.out.println("Insufficient funds in your wallet.");
                        }
                    } else {
                        System.out.println("Payment canceled.");
                    }
                    break;

                case 8:
                    // Add funds to wallet
                    if (customer == null) {
                        System.out.println("Please log in first.");
                        break;
                    }
                    System.out.print("Amount to add to wallet: ");
                    double amount = scanner.nextDouble();
                    customer.addFunds(amount);
                    break;

                case 9:
                    // Exit the program
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Please select a valid option.");
            }
        }
    }
}
