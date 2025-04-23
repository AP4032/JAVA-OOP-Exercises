package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ThemePark park = new ThemePark();
        boolean running = true;

        while (running) {
            System.out.println("---- Theme Park Menu ----");
            System.out.println("1. Add ride");
            System.out.println("2. Remove ride");
            System.out.println("3. Add visitor");
            System.out.println("4. Add VIP visitor");
            System.out.println("5. Add visitor to ride queue");
            System.out.println("6. Process ride (remove first visitor)");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ride name: ");
                    String rideName = scanner.nextLine();
                    System.out.print("Enter ride capacity: ");
                    int capacity = scanner.nextInt();
                    System.out.print("Enter ride duration: ");
                    int duration = scanner.nextInt();
                    scanner.nextLine();
                    Ride ride = new Ride(rideName, capacity, duration);
                    park.addRide(ride);
                    break;

                case 2:
                    System.out.print("Enter ride name to remove: ");
                    String removeRideName = scanner.nextLine();
                    park.removeRide(removeRideName);
                    break;

                case 3:
                    System.out.print("Enter visitor name: ");
                    String visitorName = scanner.nextLine();
                    Visitor visitor = new Visitor(visitorName);
                    park.addVisitor(visitor);
                    break;

                case 4:
                    System.out.print("Enter VIP visitor name: ");
                    String vipName = scanner.nextLine();
                    VIPVisitor vip = new VIPVisitor(vipName);
                    park.addVisitor(vip);
                    break;

                case 5:
                    System.out.print("Enter visitor name: ");
                    String nameToAdd = scanner.nextLine();
                    System.out.print("Enter ride name: ");
                    String rideForQueue = scanner.nextLine();

                    Visitor visitorToAdd = park.findVisitor(nameToAdd);
                    Ride targetRide = park.findRide(rideForQueue);

                    if (visitorToAdd != null && targetRide != null) {
                        targetRide.addVisitor(visitorToAdd);
                    } else {
                        System.out.println("Visitor or ride not found!");
                    }
                    break;

                case 6:
                    System.out.print("Enter ride name to process: ");
                    String rideToProcess = scanner.nextLine();
                    Ride processingRide = park.findRide(rideToProcess);

                    if (processingRide != null) {
                        processingRide.startRide();
                    } else {
                        System.out.println("Ride not found!");
                    }
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