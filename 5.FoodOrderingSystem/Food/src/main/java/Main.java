import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurant restaurant = new Restaurant();
        List<Customer> customers = new ArrayList<>();
        List<MenuItem> menu = new ArrayList<>();

        System.out.println("=== Restaurant Management System ===");

        boolean running = true;
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Menu Item");
            System.out.println("3. Show Menu");
            System.out.println("4. Place Order");
            System.out.println("5. Show Customer Orders");
            System.out.println("6. Show All Orders");
            System.out.println("7. Update Order Status");
            System.out.println("8. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();
                    Customer customer = new Customer(name, phone);
                    customers.add(customer);
                    System.out.println("Customer added: " + customer);
                    break;

                case 2:
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    MenuItem item = new MenuItem(itemName, price, 0);
                    menu.add(item);
                    System.out.println("Menu item added.");
                    break;

                case 3:
                    System.out.println("--- Menu ---");
                    for (int i = 0; i < menu.size(); i++) {
                        MenuItem m = menu.get(i);
                        System.out.println((i + 1) + ". " + m.getName() + " - $" + m.getPrice());
                    }
                    break;

                case 4:
                    System.out.print("Enter customer phone number: ");
                    String custPhone = scanner.nextLine();
                    Customer foundCustomer = findCustomerByPhone(customers, custPhone);
                    if (foundCustomer == null) {
                        System.out.println("Customer not found.");
                        break;
                    }

                    List<MenuItem> selectedItems = new ArrayList<>();
                    boolean addingItems = true;
                    while (addingItems) {
                        System.out.println("Choose item number from menu (-1 to finish): ");
                        for (int i = 0; i < menu.size(); i++) {
                            System.out.println((i + 1) + ". " + menu.get(i).getName());
                        }

                        int itemChoice = scanner.nextInt();
                        if (itemChoice == -1) {
                            addingItems = false;
                            continue;
                        }

                        if (itemChoice < 1 || itemChoice > menu.size()) {
                            System.out.println("Invalid choice.");
                            continue;
                        }

                        System.out.print("Enter quantity: ");
                        int qty = scanner.nextInt();
                        scanner.nextLine();

                        MenuItem baseItem = menu.get(itemChoice - 1);
                        MenuItem orderedItem = new MenuItem(baseItem.getName(), baseItem.getPrice(), qty);
                        selectedItems.add(orderedItem);
                    }

                    if (!selectedItems.isEmpty()) {
                        Order order = new Order();
                        for (MenuItem ordered : selectedItems) {
                            order.addItem(ordered);
                        }
                        foundCustomer.placeOrder(order);
                        restaurant.receiveOrder(order);
                        System.out.println("Order placed successfully!");
                    } else {
                        System.out.println("No items selected.");
                    }
                    break;

                case 5:
                    System.out.print("Enter customer phone number: ");
                    String phoneSearch = scanner.nextLine();
                    Customer customerFound = findCustomerByPhone(customers, phoneSearch);
                    if (customerFound != null) {
                        customerFound.printOrderHistory();
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 6:
                    restaurant.printOrders();
                    break;
                    
                case 7:
                    System.out.print("Enter order number to update (1 to " + restaurant.getTotalOrders() + "): ");
                    int orderNum = scanner.nextInt();
                    scanner.nextLine();

                    if (orderNum < 1 || orderNum > restaurant.getTotalOrders()) {
                        System.out.println("Invalid order number.");
                        break;
                    }

                    System.out.println("Choose new status:");
                    System.out.println("1. Preparing");
                    System.out.println("2. Ready");
                    System.out.println("3. Delivered");
                    System.out.println("4. Cancelled");
                    System.out.print("Enter choice: ");
                    int statusChoice = scanner.nextInt();
                    scanner.nextLine();

                    String newStatus = " ";
                    switch (statusChoice) {
                        case 1:
                            newStatus = "Preparing";
                            break;
                        case 2:
                            newStatus = "Ready";
                            break;
                        case 3:
                            newStatus = "Delivered";
                            break;
                        case 4:
                            newStatus = "Cancelled";
                            break;
                        default:
                            System.out.println("Invalid status choice.");
                            break;
                    }

                    Order orderToUpdate = restaurant.getOrderByIndex(orderNum - 1);
                    orderToUpdate.setStatus(newStatus);
                    System.out.println("Order status updated to: " + newStatus);
                    break;

                case 8:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }

    public static Customer findCustomerByPhone(List<Customer> customers, String phone) {
        for (Customer c : customers) {
            if (c.getPhoneNumber().equals(phone)) {
                return c;
            }
        }
        return null;
    }
}
