package main;

import java.util.ArrayList;

public class Ride {
    private final String instrument;
    private final int capacity;
    private final int duration;
    public ArrayList<Visitor> visitors;

    public Ride(String instrument, int capacity, int duration) {
        this.instrument = instrument;
        this.capacity = capacity;
        this.duration = duration;
        visitors = new ArrayList<>();
    }

    public void addVisitor(String visitorName, int membershipType) {
        Visitor visitor = membershipType == 1 ? new Visitor(visitorName) : new VIPVisitor(visitorName);
        boolean added = visitors.stream().anyMatch(v -> v.getName().equals(visitorName));
        if (visitors.size() < capacity) {
            if (!added) {
                visitors.add(visitor);
                System.out.println(Main.MUTED_GREEN + visitor.getName() + " added to Ride list for " + instrument + Main.RESET);
            } else
                System.out.println(Main.LIGHT_GRAY + visitor.getName() + " is already in the Ride list for " + instrument + Main.RESET);
        } else System.out.println(Main.LIGHT_GRAY + "The queue is full!" + Main.RESET);
    }

    public void printQueue() {
        if (!visitors.isEmpty()) {
            int counter = 1;
            for (Visitor visitor : visitors) {
                System.out.println(Main.MUTED_GREEN + counter + ". " + visitor.getName() + Main.RESET);
                counter++;
            }
        }else{
            System.out.println(Main.LIGHT_GRAY + "The queue is empty!" + Main.RESET);
        }
    }

    public void startRide() throws InterruptedException {
        if (visitors.isEmpty()) System.out.println(Main.LIGHT_GRAY + "No one is waiting in queue to ride!" + Main.RESET);
        else {
            while (!visitors.isEmpty() && capacity > 0) {
                Visitor visitor = visitors.removeFirst();
                if (visitor.getClass().getSimpleName().equals("VIPVisitor")) {
                    VIPVisitor vipVisitor = (VIPVisitor) visitor;
                    vipVisitor.priorAccess();
                    for (int i = duration * 2; i > 0; i--) {
                        System.out.println(Main.LIGHT_GRAY + i + "..." + Main.RESET);
                        Thread.sleep(1000);
                    }
                } else {
                    System.out.println(Main.LIGHT_GRAY + visitor.getName() + " is riding " + instrument + Main.RESET);
                    for (int i = duration; i > 0; i--) {
                        System.out.println(Main.LIGHT_GRAY + i + "..." + Main.RESET);
                        Thread.sleep(1000);
                    }
                }
            }
            System.out.println(Main.MUTED_GREEN + "Ride has been stopped. \n queue is empty." + Main.RESET);
        }
    }
}
