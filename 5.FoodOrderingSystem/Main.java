import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Map<Integer,MenuItem> menuItems = new HashMap<>();
    static ArrayList<MenuItem> items = new ArrayList<>();
    static ArrayList<Customer> customers = new ArrayList<>();
    static ArrayList<Order> orders1 = new ArrayList<>();
    static ArrayList<Restaurant> restaurant = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static Scanner sc1 = new Scanner(System.in);
    public static void main(String[] args) {
        restaurant.add(new Restaurant());
        populateMenu();
        menu();
    }
    public static void menu(){
        System.out.println("Welcome to our restaurant!");
        System.out.println("What is your name?");
        String name = sc1.nextLine();
        customers.add(new Customer(name));
        System.out.println(" ***** Menu ***** ");
        System.out.println(" $$$   Foods  $$$ ");
        System.out.println("1. Burger    9$ ");
        System.out.println("2. Pizza    9.5$");
        System.out.println("3. Sandwich    7.5$");
        System.out.println("4. French fries    6$");
        System.out.println("5. Fried chicken    8.5$");
        System.out.println("6. Sushi    8$");
        System.out.println("7. Hot dog    7.5$");
        System.out.println("8. Chips and cheese    7$");
        System.out.println("9. Kebab    10$");
        System.out.println("10. Grilled chicken    9$");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("$$$ Drinks $$$ ");
        System.out.println("11. Soda    3$");
        System.out.println("12. Lemonade    2.5$");
        System.out.println("13. Dough    1.5$");
        System.out.println("14. Juice    2$");
        System.out.println("15. Water    0.5$");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("$$$ Dessert $$$ ");
        System.out.println("16. Sauce    2.5$");
        System.out.println("17. Yogurt    2$");
        System.out.println("18. Jelly    3$");
        System.out.println("19. Cultivated olives    4$");
        System.out.println("20. Fruit Tray    3.5$");
        System.out.println("Please enter your orders number (Enter 0 to finish!) :");
        takingorders();
    }
    public static void populateMenu() {
        menuItems.put(1, new MenuItem("Burger", 9.00));
        menuItems.put(2, new MenuItem("Pizza", 9.5));
        menuItems.put(3, new MenuItem("Sandwich", 7.5));
        menuItems.put(4, new MenuItem("French fries", 6.0));
        menuItems.put(5, new MenuItem("Fried chicken", 8.5));
        menuItems.put(6, new MenuItem("Sushi", 8.0));
        menuItems.put(7, new MenuItem("Hot dog", 7.5));
        menuItems.put(8, new MenuItem("Chips and cheese", 7.0));
        menuItems.put(9, new MenuItem("Kebab", 10.0));
        menuItems.put(10, new MenuItem("Grilled chicken", 9.0));
        menuItems.put(11, new MenuItem("Soda", 3.0));
        menuItems.put(12, new MenuItem("Lemonade", 2.5));
        menuItems.put(13, new MenuItem("Dough", 1.5));
        menuItems.put(14, new MenuItem("Juice", 2.0));
        menuItems.put(15, new MenuItem("Water", 0.5));
        menuItems.put(16, new MenuItem("Sauce", 2.5));
        menuItems.put(17, new MenuItem("Yogurt", 2.0));
        menuItems.put(18, new MenuItem("Jelly", 3.0));
        menuItems.put(19, new MenuItem("Cultivated olives", 4.0));
        menuItems.put(20, new MenuItem("Fruit Tray", 3.5));
    }
    public static void takingorders() {
        while (true) {
            int choice = sc.nextInt();
            if (choice == 0) break;

            MenuItem item = menuItems.get(choice);
            if (item != null) {
                items.add(item);
                orders1.add(customers.getLast().placeOrder(item));
                System.out.println("Added: " + item.getName());
            } else {
                System.out.println("Invalid choice.");
            }
        }
        Order order = customers.getLast().placeOrder(items.toArray(new MenuItem[0]));
        restaurant.getLast().receiveOrder(order);
        restaurant.getLast().updateOrderStatus(order,"Taking order");
        System.out.println("Orders taken and price total:");
        for (MenuItem item : items) {
            System.out.println(item.getName() + ": " + item.getPrice());
        }
        System.out.println("Total price: " + order.calculateTotal());
        System.out.println("Paying price...");
        restaurant.getLast().updateOrderStatus(order,"Paying order");
        menu();
    }



}

