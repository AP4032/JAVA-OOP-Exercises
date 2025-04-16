package Theme_Park_Management_System;

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
