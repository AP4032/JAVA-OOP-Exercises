import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get customer information
        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter your phone number: ");
        String customerPhone = scanner.nextLine();

        System.out.print("Enter your address: ");
        String customerAddress = scanner.nextLine();

        // Create restaurants
        Restaurant restaurant1 = new Restaurant("Delicious Burgers", "123 Main St");
        Restaurant restaurant2 = new Restaurant("Pasta Paradise", "456 Oak Ave");

        // Create menu items
        MenuItem burger = new MenuItem("Classic Burger", "Beef patty, lettuce, tomato, cheese", 8.99);
        MenuItem cheeseburger = new MenuItem("Cheeseburger", "Beef patty, cheese, pickles, onions", 9.99);
        MenuItem veggieBurger = new MenuItem("Veggie Burger", "Plant-based patty, lettuce, tomato, avocado", 10.50);
        MenuItem fries = new MenuItem("French Fries", "Crispy golden fries", 3.50);
        MenuItem soda = new MenuItem("Soda", "Coke, Pepsi, Sprite", 2.00);

        MenuItem spaghetti = new MenuItem("Spaghetti Bolognese", "Pasta with meat sauce", 11.00);
        MenuItem lasagna = new MenuItem("Lasagna", "Layers of pasta, meat, and cheese", 13.00);
        MenuItem ravioli = new MenuItem("Ravioli", "Pasta filled with cheese or meat", 12.50);
        MenuItem garlicBread = new MenuItem("Garlic Bread", "Toasted bread with garlic butter", 4.00);
        MenuItem salad = new MenuItem("Caesar Salad", "Lettuce, croutons, parmesan cheese, Caesar dressing", 7.00);

        restaurant1.addMenuItem(burger);
        restaurant1.addMenuItem(cheeseburger);
        restaurant1.addMenuItem(veggieBurger);
        restaurant1.addMenuItem(fries);
        restaurant1.addMenuItem(soda);

        restaurant2.addMenuItem(spaghetti);
        restaurant2.addMenuItem(lasagna);
        restaurant2.addMenuItem(ravioli);
        restaurant2.addMenuItem(garlicBread);
        restaurant2.addMenuItem(salad);

        // Create a customer
        Customer customer = new Customer(customerName, customerPhone, customerAddress);

        // Display restaurants and menus
        System.out.println("Available Restaurants:");
        System.out.println("1. " + restaurant1.getName());
        System.out.println("2. " + restaurant2.getName());

        System.out.print("Choose a restaurant (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        Restaurant selectedRestaurant;
        if (choice == 1) {
            selectedRestaurant = restaurant1;
        } else if (choice == 2) {
            selectedRestaurant = restaurant2;
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        selectedRestaurant.displayMenu();

        // Create an order
        Order order = new Order(customer, selectedRestaurant);

        // Add items to the order
        System.out.print("Enter the number of the item you want to order (or 0 to finish): ");
        int itemNumber = scanner.nextInt();
        scanner.nextLine();

        while (itemNumber != 0) {
            if (itemNumber > 0 && itemNumber <= selectedRestaurant.getMenu().size()) {
                order.addItem(selectedRestaurant.getMenu().get(itemNumber - 1));
            } else {
                System.out.println("Invalid item number.");
            }

            System.out.print("Enter the number of the item you want to order (or 0 to finish): ");
            itemNumber = scanner.nextInt();
            scanner.nextLine();
        }

        // Display the order
        order.displayOrder();

        scanner.close();
    }
}
