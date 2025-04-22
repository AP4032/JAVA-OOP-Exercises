import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Ride rollerCoaster = new Ride("Roller Coaster", 5, 10);
        Ride ferrisWheel = new Ride("Ferris Wheel", 6, 8);
        Ride waterRafting = new Ride("Water Ride", 8,5);
        Ride spinningFlatRide = new Ride("Spinning Flat Ride", 40 , 3);
        Ride darkRide = new Ride("Dark Ride", 4, 7);
        Ride[] rides = new Ride[5];
        rides[0]=rollerCoaster;
        rides[1]=ferrisWheel;
        rides[2]=waterRafting;
        rides[3]=spinningFlatRide;
        rides[4]=darkRide;
        Admin admin = new Admin(rides);
        for (Ride ride: rides){
            admin.addRides(ride);
        }
        Visitor v1 = new Visitor("Mas");
        Visitor v2 = new Visitor("Samantha");
        Visitor v3 = new Visitor("Jake");
        Visitor v4 = new Visitor("Emily");
        Visitor v5 = new Visitor("Sara");
        Visitor v6 = new Visitor("Tom");
        Visitor v7 = new Visitor("Ali");
        VIPVisitor vv1 = new VIPVisitor("Samuel");
        VIPVisitor vv2 = new VIPVisitor("Lysandra");
        VIPVisitor vv3 = new VIPVisitor("Celestine");
        VIPVisitor vv4 = new VIPVisitor("Evander");

        vv2.getPriorityAccess(rollerCoaster);
        rollerCoaster.addVisitor(v2);
        rollerCoaster.addVisitor(v7);
        vv1.getPriorityAccess(rollerCoaster);
        vv3.getPriorityAccess(rollerCoaster);
        rollerCoaster.addVisitor(v1);
        spinningFlatRide.addVisitor(v3);
        vv4.getPriorityAccess(spinningFlatRide);
        ferrisWheel.addVisitor(v1);
        ferrisWheel.addVisitor(v6);
        vv2.getPriorityAccess(ferrisWheel);
       vv3.getPriorityAccess(darkRide);
        darkRide.addVisitor(v3);
        waterRafting.addVisitor(v5);
        vv2.getPriorityAccess(waterRafting);



        rollerCoaster.startRide();
        ferrisWheel.startRide();
        spinningFlatRide.startRide();
        darkRide.startRide();
        waterRafting.startRide();


    }
}
