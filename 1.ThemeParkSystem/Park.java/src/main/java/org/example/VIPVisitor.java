package org.example;

public class VIPVisitor extends Visitor {
    public VIPVisitor(String name){
        super(name);
    }
    public void getAccess(Ride ride){
        System.out.println(getName() + " used priority access.");
    }
}
