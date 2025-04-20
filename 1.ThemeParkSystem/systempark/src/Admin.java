import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Ride> rides;

    public Admin() {
        this.rides = new ArrayList<>();
    }

    public void addRide(Ride ride) {
        rides.add(ride);
        System.out.println("وسیله بازی " + ride + " به شهربازی اضافه شد.");
    }
}