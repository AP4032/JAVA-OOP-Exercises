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
    public void addRide(Ride ride){
        if (rideCount < rides.length){
            rides[rideCount++] = ride;
        }
    }
    public void removeRide(String rideName){
        for (int i=0; i < rideCount; i++){
            if (rides[i].getName().equals(rideName)){
                for (int j = i; j < rideCount - 1; j++){
                    rides[j] = rides[j + 1];
                }
                rideCount--;
                break;
            }
        }
    }
    public void showRides(){
        for (int i = 0; i < rideCount; i++){
            System.out.println(rides[i].getName());
        }
    }
}
