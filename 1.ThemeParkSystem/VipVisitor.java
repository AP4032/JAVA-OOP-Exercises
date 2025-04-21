package org.example;

public class VipVisitor extends Visitor {
    public VipVisitor(String name ) {
        super(name);
    }

    @Override
    public void addVisitorToRide(Ride ride) {
        System.out.println(getName() + " added Vip visitor to ride: " );
    }
}
