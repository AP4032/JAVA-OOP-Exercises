package ThemeParkSystem;

import Sports_Court_Booking.Court;
import Sports_Court_Booking.Player;

import java.util.ArrayList;

public class Admin
{
    ArrayList<Ride> rides = new ArrayList<>();
    ArrayList<Visitor> visitors = new ArrayList<>();

    public void addRide(Ride name) {
        rides.add(name);
    }

    public void addVisitor(Visitor name) {
        visitors.add(name);
    }
}
