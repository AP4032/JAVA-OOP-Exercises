import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Restaurant restaurant = new Restaurant();

        System.out.println("\nWelcome to your restaurant ! 🍽️");
        boolean keepGoing = true;
        while (keepGoing){
            showMenu();
            System.out.print("Enter an option :");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option){
                case 1 -> restaurant.printMenu();
                case 2 -> orderPlacementHandler(sc, restaurant.getCustomers(), restaurant);
                case 3 -> restaurant.printOrders();
                case 4 -> updateOrderStatusHandler(sc, restaurant);
                case 5 -> {
                    keepGoing = false;
                    System.out.println("Exiting...");
                }
                default -> System.out.println("Enter a valid input");
            }

        }

    }

    public static void updateOrderStatusHandler(Scanner sc, Restaurant restaurant){
        System.out.print("Enter Order ID to update: ");
        int orderId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new status (e.g., In Progress, Ready, Delivered): ");
        String newStatus = sc.nextLine();
        restaurant.updateOrderStatus(orderId, newStatus);
    }

    public static void orderPlacementHandler(Scanner sc, ArrayList<Customer> customers, Restaurant restaurant){
        Customer customer = getOrCreateCustomer(sc, customers);
        Order order = new Order();

        while (true){
            restaurant.printMenu();
            System.out.print("Choose one (@ to stop): ");
            String foodName = sc.nextLine();

            if (foodName.equalsIgnoreCase("@")) {
                if (order.getItems().isEmpty()) {
                    System.out.println("No items were added. Order canceled.");
                    return;
                }
                customer.setOrder(order); // store order in customer if needed
                restaurant.receiveOrder(order); // officially submit the order
                break;
            }

            MenuItem food = findItem(restaurant.getMenuItem(), foodName);
            if (food != null) {
                order.addItem(food);
                System.out.println(food.getName() + " added to your order.");
            } else {
                System.out.println("There is no food by this name!");
            }
        }
    }

    //Helper method to print the menu options.
    public static void showMenu (){
        System.out.println("1. View Menu");
        System.out.println("2. Place Order");
        System.out.println("3. View All Orders (Staff)");
        System.out.println("4. Update Order Status (Staff)");
        System.out.println("5. Exit");
    }

    //Helper method when we need to interact with user info.
    public static Customer getOrCreateCustomer(Scanner sc, ArrayList<Customer> customers) {
        System.out.print("Enter your name: ");
        String inputName = sc.nextLine();

        Customer customer = findCustomer((ArrayList<Customer>) customers, inputName);
        if (customer == null) {
            customer = new Customer(inputName);
            customers.add(customer);
            System.out.println("Customer: " + customer.getName() + " was added to the customers list.");
        } else {
            System.out.println("Welcome back " + customer.getName() + ".");
        }

        return customer;
    }
    //Simple helper method to find a customer from customer list in Restaurant class.
    public static Customer findCustomer(ArrayList<Customer> customers, String name){
       for (Customer c : customers){
           if (c.getName().equalsIgnoreCase(name)){
               return c;
           }
       }
       return null;
    }
    //Simple helper method to find an item from menu in Restaurant class.
    public static MenuItem findItem (ArrayList<MenuItem> menuItems, String foodName){
        for (MenuItem item : menuItems){
           if (item.getName().equalsIgnoreCase(foodName)){
               return item;
           }
        }
        return null;
    }
}
