package org.example;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public boolean bookCourt(Court court, LocalDateTime dateTime) {
        Scanner scanner = new Scanner(System.in);
        if (!court.isAvailable()){
            System.out.println("Court is already booked!");
            return false;
        }
        System.out.println("Total price for booking: " + court.getPrice());
        System.out.println("Enter amount to pay: ");
        double amount = scanner.nextDouble();
        if (court.payment((amount))){
            if (court.bookCourt(dateTime)){
                System.out.println(name + " successfully booked a " + court.getSportType() + "court.");
                return true;
            }else {
                System.out.println("Payment failed. Try again!");
            }
        }
        return false;
    }
}