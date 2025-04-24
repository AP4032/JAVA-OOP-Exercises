package Theme;


import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Ride> rides;

    public Admin() {
        this.rides = new ArrayList<>();
    }

    public void addRide(Ride ride) {
        rides.add(ride);
        System.out.println("Ride \"" + ride.getname() + "\" added to the park.");
    }

    public void showAllRides() {
        if (rides.isEmpty()) {
            System.out.println("No rides in the park.");
        } else {
            System.out.println("--- List of Rides ---");
            for (Ride r : rides) {
                System.out.println("Ride: " + r.getname() + " | Capacity: " + r.getCapacity() + " | Duration: " + r.getDuration() + " mins");
            }
        }
    }

    public Ride findRideByName(String name) {
        for (Ride r : rides) {
            if (r.getname().equalsIgnoreCase(name)) {
                return r;
            }
        }
        return null;
    }
}


