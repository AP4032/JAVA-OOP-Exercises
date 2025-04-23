package org.example;

public class Ride {
    private String name;
    private int capacity;
    private int duration;
    private Visitor[] queue;
    private int queueSize;

    public Ride(String name, int capacity, int duration) {
        this.name = name;
        this.capacity = capacity;
        this.duration = duration;
        this.queue = new Visitor[capacity];
        this.queueSize = 0;
    }

    public void addVisitor(Visitor visitor) {
        if (queueSize >= capacity) {
            System.out.println("Queue is full for ride " + name + "!");
            return;
        }

        if (visitor instanceof VIPVisitor) {
            // Shift all visitors to make space at the beginning
            for (int i = queueSize; i > 0; i--) {
                queue[i] = queue[i - 1];
            }
            queue[0] = visitor;
            queueSize++;
            System.out.println(visitor.getName() + " (VIP) added to the beginning of the queue for " + name);
        } else {
            queue[queueSize++] = visitor;
            System.out.println(visitor.getName() + " added to the queue for " + name);
        }
    }

    public void startRide() {
        if (queueSize == 0) {
            System.out.println("No visitors in queue for " + name);
            return;
        }

        System.out.println("\n--- Ride " + name + " started! Duration: " + duration + " minutes ---");
        System.out.println("Visitors on this ride:");

        for (int i = 0; i < queueSize; i++) {
            System.out.println((i + 1) + ". " + queue[i].getName());
        }

        queueSize = 0; // Clear the queue after ride starts
        System.out.println("Ride " + name + " completed!\n");
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getDuration() {
        return duration;
    }
}