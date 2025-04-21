package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ThemePark park = new ThemePark();
        Admin admin = new Admin();
        boolean running = true;
        while (running){
            System.out.println();
            System.out.println("---- Theme Park Menu ----");
            System.out.println("1. Add ride");
            System.out.println("2. Remove ride");
            System.out.println("3. Add visitors");
            System.out.println("4. Add VIP visitor");
            System.out.println("5. Add visitor to ride queue");
            System.out.println("6. Remove visitor from ride queue");
            System.out.println("7. Exit");
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Enter ride name: ");
                    String rideName = scanner.nextLine();
                    System.out.println("Enter ride capacity: ");
                    int capacity = scanner.nextInt();
                    System.out.println("Enter ride duration: ");
                    int duration = scanner.nextInt();
                    scanner.nextLine();
                    Ride ride = new Ride(rideName ,capacity ,duration);
                    admin.addRide(ride);
                    break;
                case 2:
                    System.out.println("Enter ride name to remove: ");
                    String removeRideName = scanner.nextLine();
                    admin.removeRide(removeRideName);
                    break;
                case 3:
                    System.out.println("Enter visitor name: ");
                    String visitorName = scanner.nextLine();
                    Visitor visitor = new Visitor(visitorName);
                    System.out.println("Visitor " + visitor.getName() + " added.");
                    break;
                case 4:
                    System.out.println("Enter VIP visitor name: ");
                    String vipName = scanner.nextLine();
                    VIPVisitor vip = new VIPVisitor(vipName);
                    System.out.println("VIP visitor " + vip.getName() + " added.");
                    break;
                case 5:
                    System.out.println("Enter visitor name: ");
                    String nameToAdd = scanner.nextLine();
                    System.out.println("Enter ride name: ");
                    String rideForQueue = scanner.nextLine();
                    System.out.println(nameToAdd + " added to the queue for " + rideForQueue);
                    break;
                case 6:
                    System.out.println("Enter ride name: ");
                    String rideToRemoveFrom = scanner.nextLine();
                    System.out.println("First visitor removed from " + rideToRemoveFrom);
                    break;
                case 7:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }
}