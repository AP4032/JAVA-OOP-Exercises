import java.util.ArrayList;
import java.util.List;

public class Admin {

    private String name;
    private List<Ride> rides;

    public Admin(String name) {
        this.name = name;
        this.rides = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addRide(Ride ride) {
        rides.add(ride);
        System.out.println( name + " added ride: " + ride.getName());
    }

    public void removeRide(Ride ride) {
        if (rides.remove(ride)) {
            System.out.println( name + " removed ride: " + ride.getName());
        } else {
            System.out.println(" Ride not found: " + ride.getName());
        }
    }

    public void listRides() {
        System.out.println(" Rides managed by admin " + name + ":");
        if (rides.isEmpty()) {
            System.out.println("No rides available.");
        } else {
            for (Ride ride : rides) {
                System.out.println("• " + ride);
            }
        }
    }

    public Ride getRideByName(String rideName) {
        for (Ride ride : rides) {
            if (ride.getName().equalsIgnoreCase(rideName)) {
                return ride;
            }
        }
        System.out.println(" Ride with name '" + rideName + "' not found.");
        return null;
    }
}
