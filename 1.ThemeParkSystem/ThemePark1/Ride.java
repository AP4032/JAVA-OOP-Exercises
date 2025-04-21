package ThemePark1 ;

import java.util.LinkedList;
import java.util.Queue;

public class Ride {
    protected String name;
    protected int capacity;
    protected int duration; // in minutes
    protected Queue<Visitor> queue;

    public Ride(String name, int capacity, int duration) {
        this.name = name;
        this.capacity = capacity;
        this.duration = duration;
        this.queue = new LinkedList<>();
    }

    public String getname() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getDuration() {
        return duration;
    }

    public void addVisitor(Visitor visitor) {
        if (visitor instanceof VIPVisitor) {
            // VIP goes to the front of the queue
            LinkedList<Visitor> tempList = (LinkedList<Visitor>) queue;
            tempList.addFirst(visitor);
            System.out.println(visitor.getname() + " (VIP) joined the front of the queue for " + name);
        } else {
            if (queue.size() < capacity * 2) { // allow queue to be double the capacity
                queue.add(visitor);
                System.out.println(visitor.getname() + " joined the queue for " + name);
            } else {
                System.out.println("Queue is full for " + name);
            }
        }
    }

    public void startRide() {
        System.out.println("\nStarting ride: " + name);
        for (int i = 0; i < capacity && !queue.isEmpty(); i++) {
            Visitor v = queue.poll();
            System.out.println(v.getname() + " is enjoying " + name);
        }
        System.out.println("Ride ended.\n");
    }
}
