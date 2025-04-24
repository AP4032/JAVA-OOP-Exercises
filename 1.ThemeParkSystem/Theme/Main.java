package Theme;

import java.util.Scanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();

        boolean running = true;

        System.out.println("=== Welcome to the Theme Park Management System ===");

        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add Ride");
            System.out.println("2. Show All Rides");
            System.out.println("3. Add Visitor to Ride");
            System.out.println("4. Add VIP Visitor to Ride");
            System.out.println("5. Start a Ride");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ride name: ");
                    String rideName = scanner.nextLine();
                    System.out.print("Enter ride capacity: ");
                    int capacity = scanner.nextInt();
                    System.out.print("Enter ride duration: ");
                    int duration = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    Ride ride = new Ride(rideName, capacity, duration);
                    admin.addRide(ride);
                    break;

                case 2:
                    admin.showAllRides();
                    break;

                case 3:
                    System.out.print("Enter visitor name: ");
                    String visitorName = scanner.nextLine();
                    System.out.print("Enter ride name to join: ");
                    String rideToJoin = scanner.nextLine();
                    Ride rideFound = admin.findRideByName(rideToJoin);
                    if (rideFound != null) {
                        Visitor visitor = new Visitor(visitorName);
                        rideFound.addVisitor(visitor);
                    } else {
                        System.out.println("Ride not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter VIP visitor name: ");
                    String vipName = scanner.nextLine();
                    System.out.print("Enter ride name to join: ");
                    String vipRideName = scanner.nextLine();
                    Ride vipRide = admin.findRideByName(vipRideName);
                    if (vipRide != null) {
                        VIPVisitor vip = new VIPVisitor(vipName , 1);
                        vip.getPriorityAccess(vipRide);
                        vipRide.addVisitor(vip);
                    } else {
                        System.out.println("Ride not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter ride name to start: ");
                    String rideToStart = scanner.nextLine();
                    Ride rideStart = admin.findRideByName(rideToStart);
                    if (rideStart != null) {
                        rideStart.startRide();
                    } else {
                        System.out.println("Ride not found.");
                    }
                    break;

                case 6:
                    running = false;
                    System.out.println("Exiting Theme Park Management System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}