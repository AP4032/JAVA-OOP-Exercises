// Main.java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Ride> rides = new ArrayList<>();
        List<Visitor> visitors = new ArrayList<>();

        // ایجاد ادمین از طریق ورودی کاربر
        Admin admin = Admin.createAdmin(scanner);

        // ایجاد چند وسیله بازی نمونه
        rides.add(new Ride("Roller Coaster", 5.0, 120));
        rides.add(new Ride("Ferris Wheel", 3.0, 90));
        rides.add(new Ride("Carousel", 2.0, 0));

        while (true) {
            System.out.println("\nWelcome to the Theme Park Management System!");
            System.out.println("1. Admin Login");
            System.out.println("2. Visitor Menu");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Admin Login
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();

                    if (admin.login(username, password)) {
                        adminMenu(scanner, rides, visitors);
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;
                case 2:
                    // Visitor Menu
                    visitorMenu(scanner, rides, visitors);
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void adminMenu(Scanner scanner, List<Ride> rides, List<Visitor> visitors) {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Ride");
            System.out.println("2. Remove Ride");
            System.out.println("3. View All Rides");
            System.out.println("4. View All Visitors");
            System.out.println("5. Back to Main Menu");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add Ride
                    System.out.print("Enter ride name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter ride price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter minimum height (cm): ");
                    int minHeight = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    rides.add(new Ride(name, price, minHeight));
                    System.out.println("Ride added successfully!");
                    break;
                case 2:
                    // Remove Ride
                    System.out.print("Enter the name of the ride to remove: ");
                    String rideNameToRemove = scanner.nextLine();
                    rides.removeIf(ride -> ride.getName().equalsIgnoreCase(rideNameToRemove));
                    System.out.println("Ride removed successfully!");
                    break;
                case 3:
                    // View All Rides
                    System.out.println("\nAll Rides:");
                    for (Ride ride : rides) {
                        System.out.println(ride);
                    }
                    break;
                case 4:
                    // View All Visitors
                    System.out.println("\nAll Visitors:");
                    for (Visitor visitor : visitors) {
                        System.out.println(visitor);
                    }
                    break;
                case 5:
                    // Back to Main Menu
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void visitorMenu(Scanner scanner, List<Ride> rides, List<Visitor> visitors) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your height (cm): ");
        int height = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Visitor visitor = new Visitor(name, height);
        visitors.add(visitor);

        while (true) {
            System.out.println("\nVisitor Menu:");
            System.out.println("1. View Available Rides");
            System.out.println("2. Check Ride Eligibility");
            System.out.println("3. Back to Main Menu");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // View Available Rides
                    System.out.println("\nAvailable Rides:");
                    for (Ride ride : rides) {
                        System.out.println(ride);
                    }
                    break;
                case 2:
                    // Check Ride Eligibility
                    System.out.print("Enter the name of the ride: ");
                    String rideName = scanner.nextLine();
                    Ride selectedRide = null;
                    for (Ride ride : rides) {
                        if (ride.getName().equalsIgnoreCase(rideName)) {
                            selectedRide = ride;
                            break;
                        }
                    }

                    if (selectedRide != null) {
                        if (visitor.getHeight() >= selectedRide.getMinHeight()) {
                            System.out.println("You are eligible to ride " + selectedRide.getName() + "!");
                        } else {
                            System.out.println("Sorry, you are not tall enough to ride " + selectedRide.getName() + ".");
                        }
                    } else {
                        System.out.println("Ride not found.");
                    }
                    break;
                case 3:
                    // Back to Main Menu
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
