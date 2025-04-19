import java.util.ArrayList;

public class Admin {

    public void addRide(ArrayList<Ride> rides, Ride newRide) {
        rides.add(newRide);
        System.out.println("Ride added: " + newRide.getName());
    }

    public void removeRide(ArrayList<Ride> rides, String rideName) {
        for (int i = 0; i < rides.size(); i++) {
            if (rides.get(i).getName().equalsIgnoreCase(rideName)) {
                rides.remove(i);
                System.out.println("Ride removed: " + rideName);
                return;
            }
        }
        System.out.println("Ride not found: " + rideName);
    }

    public void showAllRides(ArrayList<Ride> rides) {
        System.out.println("All Rides:");
        for (Ride r : rides) {
            System.out.println("- " + r.getName() + " (Capacity: " + r.getCapacity() + ")");
        }
    }
}