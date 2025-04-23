package org.example;

public class ThemePark {
    private Ride[] rides;
    private Visitor[] visitors;
    private int rideCount;
    private int visitorCount;

    public ThemePark(){
        this.rides = new Ride[50];
        this.visitors = new Visitor[100];
        this.rideCount = 0;
        this.visitorCount = 0;
    }

    public void addRide(Ride ride) {
        if (rideCount < rides.length) {
            rides[rideCount++] = ride;
            System.out.println("Ride " + ride.getName() + " added successfully.");
        } else {
            System.out.println("Cannot add more rides. Park is at full capacity.");
        }
    }

    public void removeRide(String rideName) {
        for (int i = 0; i < rideCount; i++) {
            if (rides[i].getName().equals(rideName)) {
                for (int j = i; j < rideCount - 1; j++) {
                    rides[j] = rides[j + 1];
                }
                rideCount--;
                System.out.println("Ride " + rideName + " removed successfully.");
                return;
            }
        }
        System.out.println("Ride " + rideName + " not found.");
    }

    public Ride findRide(String rideName) {
        for (int i = 0; i < rideCount; i++) {
            if (rides[i].getName().equals(rideName)) {
                return rides[i];
            }
        }
        return null;
    }

    public void addVisitor(Visitor visitor) {
        if (visitorCount < visitors.length) {
            visitors[visitorCount++] = visitor;
            System.out.println("Visitor " + visitor.getName() + " added successfully.");
        } else {
            System.out.println("Cannot add more visitors. Park is at full capacity.");
        }
    }

    public Visitor findVisitor(String visitorName) {
        for (int i = 0; i < visitorCount; i++) {
            if (visitors[i].getName().equals(visitorName)) {
                return visitors[i];
            }
        }
        return null;
    }
}