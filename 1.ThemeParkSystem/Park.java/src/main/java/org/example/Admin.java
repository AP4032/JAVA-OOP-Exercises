package org.example;

public class Admin {
    private Ride[] rides = new Ride[50];
    private int rideCount = 0;
    public void addRide(Ride ride){
        if (rideCount < rides.length){
            rides[rideCount++] = ride;
            System.out.println("Ride " + ride.getName() + " added.");
        }
    }
    public void removeRide(String rideName){
        for (int i = 0; i < rideCount; i++){
            if (rides[i].getName().equals(rideName)){
                for (int j = i; j < rideCount - 1; j++){
                    rides[j] = rides[j + 1];
                }
                rideCount--;
                System.out.println("Ride " + rideName + " removed.");
                return;
            }
        }
        System.out.println("Ride not found!");
    }
}
