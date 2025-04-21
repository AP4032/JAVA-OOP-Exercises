package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        boolean running = true;
        while (running){
            System.out.println("--- Sports Court Booking System ---");
            System.out.println("1. Add court");
            System.out.println("2. Remove court");
            System.out.println("3. Book court");
            System.out.println("4. Show all courts");
            System.out.println("5. Exit");
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter sport type: ");
                    String type = scanner.nextLine();
                    System.out.println("Enter court price: ");
                    double price = scanner.nextDouble();
                    admin.addCourt(new Court(type , price));
                    break;
                case 2:
                    System.out.println("Enter sport type: ");
                    String remove = scanner.nextLine();
                    admin.removeCourt(remove);
                    break;
                case 3:
                    Court[] available = admin.getCourts();
                    if (available.length == 0) {
                        System.out.println("No courts available!");
                        break;
                    }
                    System.out.println("Courts: ");
                    for (int i = 0; i < available.length; i++){
                        int number = i + 1;
                        String sport = available[i].getSportType();
                        String status = available[i].isAvailable() ? "Available" : "Booked";
                        System.out.println(number + ". " + sport + " - " + status);
                    }
                    System.out.println("Select court number: ");
                    int courtIndex = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter player name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter reservation date and time (yyyy-MM-dd HH:mm): ");
                    String dateTimeString = scanner.nextLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    LocalDateTime dateTime = LocalDateTime.parse(dateTimeString , formatter);
                    if (courtIndex > 0 && courtIndex <= available.length){
                        Player player = new Player(name);
                        player.bookCourt(available[courtIndex - 1] , dateTime);
                    }
                    break;
                case 4:
                    Court[] allCourts = admin.getCourts();
                    System.out.println("All courts: ");
                    for (int i= 0; i < allCourts.length; i++){
                        int number = i + 1;
                        String sport = allCourts[i].getSportType();
                        String status = allCourts[i].isAvailable() ? "Available" : "Booked";
                        if (!allCourts[i].isAvailable()){
                            String bookingTime = allCourts[i].getBookingTime() != null ? allCourts[i].getBookingTime().toString() : "No booking time";
                            status += " at " + bookingTime;
                        }
                        System.out.println(number + ". " + sport + " - " + status);
                    }
                    break;
                case 5:
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