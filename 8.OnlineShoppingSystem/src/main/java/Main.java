// Aria Razavi 

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Store store = new Store();
        Customer customer = null;
        System.out.println("Welcome to Online Shopping System!");

        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Create Customer");
            System.out.println("2. View Products");
            System.out.println("3. Add to Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Checkout");
            System.out.println("6. View Order History");
            System.out.println("7. Add Product");
            System.out.println("8. Exit");
            System.out.print("Choose an option (1-8): ");
            String choice = scanner.next().trim();
            scanner.nextLine(); 

            switch (choice) {
                case "1":
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine().trim();
                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty!");
                        break;
                    }
                    customer = new Customer(name);
                    System.out.println("Customer " + name + " created!");
                    break;

                case "2":
                    store.displayProducts();
                    break;

                case "3":
                    if (customer == null) {
                        System.out.println("Please create a customer first!");
                        break;
                    }
                    store.displayProducts();
                    System.out.print("Enter product number (1-" + store.getProducts().size() + "): ");
                    String indexInput = scanner.nextLine().trim();
                    if (!isPositiveInteger(indexInput)) {
                        System.out.println("Please enter a valid number!");
                        break;
                    }
                    int index = Integer.parseInt(indexInput) - 1;
                    Product product = store.getProductByIndex(index);
                    if (product == null) {
                        System.out.println("Invalid product number!");
                        break;
                    }
                    customer.addToCart(product);
                    break;

                case "4":
                    if (customer == null) {
                        System.out.println("Please create a customer first!");
                        break;
                    }
                    customer.getCart().displayCart();
                    break;

                case "5":
                    if (customer == null) {
                        System.out.println("Please create a customer first!");
                        break;
                    }
                    customer.placeOrder();
                    break;

                case "6":
                    if (customer == null) {
                        System.out.println("Please create a customer first!");
                        break;
                    }
                    customer.displayOrderHistory();
                    break;

                case "7":
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine().trim();
                    System.out.print("Enter product price: ");
                    String priceInput = scanner.nextLine().trim();
                    if (!isPositiveDouble(priceInput)) {
                        System.out.println("Please enter a valid positive price!");
                        break;
                    }
                    double price = Double.parseDouble(priceInput);
                    store.addProduct(productName, price);
                    break;

                case "8":
                    System.out.println("Thanks for shopping with us!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option! Please choose 1-8.");
            }
        }
    }

    // چک کردن  عدد مثبت برای شماره محصول
    private static boolean isPositiveInteger(String input) {
        if (input.isEmpty()) {
            return false;
        }
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        int number = Integer.parseInt(input);
        return number > 0;
    }

                          // چک کردن عدد مثبت برای  قیمت 
    private static boolean isPositiveDouble(String input) {
        if (input.isEmpty()) {
            return false;
        }
        return true;
    }
}
