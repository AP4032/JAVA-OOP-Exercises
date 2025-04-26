import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create restaurant and menu items
        Restaurant restaurant = new Restaurant();
        MenuItem burger = new MenuItem("Burger", 5.99);
        MenuItem pizza = new MenuItem("Pizza", 8.99);
        MenuItem soda = new MenuItem("Soda", 1.99);

        // Create customer
        Customer customer = new Customer("Alice", "1234 Elm Street");

        // Main interaction loop
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the Restaurant!");
            System.out.println("1. View menu");
            System.out.println("2. Place order");
            System.out.println("3. Process payment");
            System.out.println("4. Track delivery");
            System.out.println("5. View all orders");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // View menu
                    System.out.println("Menu:");
                    burger.displayInfo();
                    pizza.displayInfo();
                    soda.displayInfo();
                    break;

                case 2:
                    // Place an order
                    System.out.println("Enter the items you want to order (separate by commas): ");
                    String input = scanner.nextLine();
                    String[] itemNames = input.split(",");
                    Order order = new Order(customer);  // Pass customer to the order
                    for (String name : itemNames) {
                        if (name.trim().equalsIgnoreCase("Burger")) {
                            order.addItem(burger);
                        } else if (name.trim().equalsIgnoreCase("Pizza")) {
                            order.addItem(pizza);
                        } else if (name.trim().equalsIgnoreCase("Soda")) {
                            order.addItem(soda);
                        }
                    }
                    restaurant.receiveOrder(order);
                    break;

                case 3:
                    // Process payment
                    System.out.println("Processing payment...");
                    if (restaurant.getOrders().isEmpty()) {
                        System.out.println("No orders placed yet.");
                    } else {
                        restaurant.processPayment(restaurant.getOrders().get(0));  // Process the first order
                    }
                    break;

                case 4:
                    // Track delivery
                    System.out.println("Tracking your delivery...");
                    if (restaurant.getOrders().isEmpty()) {
                        System.out.println("No orders placed yet.");
                    } else {
                        restaurant.trackDelivery(restaurant.getOrders().get(0));  // Track the first order
                    }
                    break;

                case 5:
                    // View all orders
                    restaurant.displayOrders();
                    break;

                case 6:
                    // Exit
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}