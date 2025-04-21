package org.example;

import java.util.ArrayList;
import java.util.List;

public class Ride {
    private String name;
    private int capacity;
    private int duration;
    private  List<Visitor> visitors = new ArrayList<>();
    public Ride (String name, int capacity, int duration) {
        this.name =name ;
        this.capacity = capacity;
        this.duration = duration;
    }
    public void addVisitorToRide(Visitor visitor) {
       if (visitor instanceof VipVisitor){
           visitors.add(visitor);
           System.out.println("VIP visitor added to ride");

        }else {
           if (visitors.size() < capacity) {
               visitors.add(visitor);
               System.out.println(visitor.getName() + "  added visitor to ride" );

           } else {
               System.out.println("the ride is already full");
           }
       }
    }
public String getName() {
        return name;
}
public int getCapacity() {
        return capacity;
}
public int getDuration(){
        return duration;
}

    }


