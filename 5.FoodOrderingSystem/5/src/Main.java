import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== WELCOME TO FOOD ORDERING SYSTEM ===");

        while (true) {
            System.out.println("\n1. Place New Order");
            System.out.println("2. Manage Orders");
            System.out.println("3. View All Orders");
            System.out.println("4. View Menu");
            System.out.println("5. Exit");
            System.out.print("Select option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    restaurant.placeNewOrder();
                    break;
                case 2:
                    restaurant.manageOrders();
                    break;
                case 3:
                    restaurant.displayAllOrders();
                    break;
                case 4:
                    restaurant.displayMenu();
                    break;
                case 5:
                    System.out.println("Thank you for using our system!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}