import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurant restaurant = new Restaurant("The Java Diner");

        /*restaurant.addMenuItem(new MenuItem("Burger", 5.99));
        restaurant.addMenuItem(new MenuItem("Pizza", 7.99));
        restaurant.addMenuItem(new MenuItem("Pasta", 6.49));
*/
        System.out.println("=== Food Ordering System ===");

        boolean running = true;
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add Menu Item");
            System.out.println("2. Place Order");
            System.out.println("3. Show Orders");
            System.out.println("4. Update Order Status");
            System.out.println("5. Show Order Details");
            System.out.println("6. Show All Menu Items");
            System.out.println("7. Show All Orders");
            System.out.println("8. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter menu item name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter menu item price: ");
                    double itemPrice = scanner.nextDouble();
                    scanner.nextLine();
                    MenuItem menuItem = new MenuItem(itemName, itemPrice);
                    restaurant.addMenuItem(menuItem);
                    System.out.println("Menu item added: " + itemName + " ($" + itemPrice + ")");
                    break;

                case 2:
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter customer address: ");
                    String customerAddress = scanner.nextLine();
                    Customer customer = new Customer(customerName, customerAddress);

                    Order order = new Order();
                    System.out.println("Select items to order:");
                    for (int i = 0; i < restaurant.getMenu().size(); i++) {
                        System.out.println((i + 1) + ". " + restaurant.getMenu().get(i).getName() + " - $" + restaurant.getMenu().get(i).getPrice());
                    }
                    System.out.print("Enter item number (0 to finish): ");
                    int itemNum;
                    while ((itemNum = scanner.nextInt()) != 0) {
                        if (itemNum > 0 && itemNum <= restaurant.getMenu().size()) {
                            order.addItem(restaurant.getMenu().get(itemNum - 1));
                        }
                        System.out.print("Enter item number (0 to finish): ");
                    }
                    scanner.nextLine();

                    restaurant.placeOrder(order);
                    System.out.println("Order placed successfully.");
                    break;

                case 3:
                    showAllOrders(restaurant);
                    break;

                case 4:
                    System.out.print("Enter order number: ");
                    int orderNum = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new status: ");
                    String status = scanner.nextLine();

                    if (orderNum > 0 && orderNum <= restaurant.getOrders().size()) {restaurant.updateOrderStatus(restaurant.getOrders().get(orderNum - 1), status);
                        System.out.println("Order status updated.");
                    } else {
                        System.out.println("Order not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter order number: ");
                    int orderDetailsNum = scanner.nextInt();
                    scanner.nextLine();

                    if (orderDetailsNum > 0 && orderDetailsNum <= restaurant.getOrders().size()) {
                        Order orderDetails = restaurant.getOrders().get(orderDetailsNum - 1);
                        System.out.println("Order Details:");
                        for (MenuItem item : orderDetails.getItems()) {
                            System.out.println("- " + item.getName() + ": $" + item.getPrice());
                        }
                        System.out.println("Total: $" + orderDetails.calculateTotal());
                        System.out.println("Status: " + orderDetails.getStatus());
                    } else {
                        System.out.println("Order not found.");
                    }
                    break;

                case 6:
                    showAllMenuItems(restaurant);
                    break;

                case 7:
                    showAllOrders(restaurant);
                    break;

                case 8:
                    running = false;
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }


    public static void showAllMenuItems(Restaurant restaurant) {
        System.out.println("\n--- Menu Items ---");
        for (MenuItem item : restaurant.getMenu()) {
            System.out.println("- " + item.getName() + ": $" + item.getPrice());
        }
    }

    
    public static void showAllOrders(Restaurant restaurant) {
        System.out.println("\n--- Orders ---");
        int i = 1;
        for (Order order : restaurant.getOrders()) {
            System.out.println(i + ". Status: " + order.getStatus());
            i++;
        }
    }
}