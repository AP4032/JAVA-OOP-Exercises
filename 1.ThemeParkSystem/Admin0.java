import java.util.ArrayList;
import java.util.List;

public class Admin0 {
    private List<Ride> rides;

    public Admin0() {
        this.rides = new ArrayList<>();
    }

    public void addRide(Ride ride) {
        rides.add(ride);
        System.out.println("Ride " + ride + " added to the park.");
    }
    public List<Ride> getRides(){
        return rides;
    }
}