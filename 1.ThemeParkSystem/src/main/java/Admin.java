import java.util.ArrayList;

public class Admin {
    private ArrayList<Ride> rides;

    public Admin() {
        this.rides = new ArrayList<>();
    }

    // اضافه کردن وسیله بازی
    public void addRide(Ride ride) {
        rides.add(ride);
        System.out.println("New ride added: " + ride.getName());
    }

    // حذف وسیله بازی
    public void removeRide(Ride ride) {
        rides.remove(ride);
        System.out.println("Ride removed: " + ride.getName());
    }

    public ArrayList<Ride> getRides() {
        return rides;
    }
}