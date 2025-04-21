
public class Admin{
    private Ride[] rides;
    public Admin(Ride[] rides){
        this.rides= rides;
    }
    public Ride[] getRides() {
        return rides;
    }

    public void setRides(Ride[] rides) {
        this.rides = rides;
    }
    public void addRides(Ride ride){
        System.out.println("Ride " + ride.getName() + " added to the park.");
    }
}
