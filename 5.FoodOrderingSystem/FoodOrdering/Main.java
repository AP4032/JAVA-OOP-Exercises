package FoodOrdering;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner =  new Scanner(System.in);
        Restaurant restaurant = new Restaurant();
        List<MenuItem> menu = new ArrayList<>();
        menu.add(new MenuItem("Burger" ,  5.99));
        menu.add(new MenuItem("Pizza" , 8.99));
        menu.add(new MenuItem("Fries" , 2.49));
        menu.add(new MenuItem("Soda" , 1.99));

        Order currentOrder = null;
        Customer currentCustomer = null;
        boolean running = true;

        while (running) {
            System.out.println("\n=== Food Ordering System ===");
            System.out.println("1. View Menu");
            System.out.println("2. Place Order");
            System.out.println("3. View Order Total");
            System.out.println("4. Update Order Status");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\n--- Menu ---");
                    for (int i = 0; i < menu.size(); i++) {
                        MenuItem item = menu.get(i);
                        System.out.println((i + 1) + ". " + item.getName() + " - $" + item.getPrice());
                    }
                    break;

                case 2:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    currentCustomer = new Customer(name);

                    System.out.print("How many items do you want to order? ");
                    int count = scanner.nextInt();
                    scanner.nextLine();

                    MenuItem[] selectedItems = new MenuItem[count];
                    for (int i = 0; i < count; i++) {
                        System.out.print("Enter item number (" + (i + 1) + "): ");
                        int itemNumber = scanner.nextInt();
                        scanner.nextLine();

                        if (itemNumber >= 1 && itemNumber <= menu.size()) {
                            selectedItems[i] = menu.get(itemNumber - 1);
                        } else {
                            System.out.println("Invalid item number.");
                            i--; // Try again
                        }
                    }

                    currentOrder = currentCustomer.placeOrder(selectedItems);
                    restaurant.receiveOrder(currentOrder);
                    break;

                case 3:
                    if (currentOrder != null) {
                        System.out.println("Current order total: $" + currentOrder.calculateTotal());
                        System.out.println("Status: " + currentOrder.getStatus());
                    } else {
                        System.out.println("No active order.");
                    }
                    break;

                case 4:
                    if (currentOrder != null) {
                        System.out.print("Enter new status (e.g., In Progress, Completed): ");
                        String status = scanner.nextLine();
                        restaurant.updateOrderStatus(currentOrder, status);
                    } else {
                        System.out.println("No active order to update.");
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("Thank you for using Food Ordering System!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}