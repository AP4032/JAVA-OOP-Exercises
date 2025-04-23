package org.example;

public class Admin {
    public void addRide(Ride ride) {
        System.out.println("Ride " + ride.getName() + " added.");
    }

    public void removeRide(String rideName) {
        System.out.println("Ride " + rideName + " removed.");
    }
}
