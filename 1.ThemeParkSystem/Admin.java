import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Ride> rides;

    public Admin() {
        this.rides = new ArrayList<>();
    }

    public void addRide(Ride ride) {
        rides.add(ride);
        System.out.println("Ride added: " + ride.getName());
    }

    public void removeRide(String rideName) {
        Ride rideToRemove = null;
        for (Ride ride : rides){
            if(ride.getName().equalsIgnoreCase(rideName)){
                rideToRemove = ride;
                break;
            } 
        }
        if (rideToRemove != null){
            rides.remove(rideToRemove);
            System.out.println("Ride \"" + rideName + "\" removed.");
        } else {
            System.out.println("Ride not found. ");
        }
    }

    public List<Ride> getRides() {
        return rides;
    }
}