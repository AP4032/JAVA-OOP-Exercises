import java.util.LinkedList;
import java.util.Queue;

public class Ride {

    private String name;
    private int capacity;
    private int duration;
    private LinkedList<Visitor> queue;

    public Ride(String name, int capacity, int duration) {
        this.name = name;
        this.capacity = capacity;
        this.duration = duration;
        this.queue = new LinkedList<>();
    }

    public void addVisitor(Visitor visitor) {
        if (visitor instanceof VIPVisitor) {
            VIPVisitor vip = (VIPVisitor) visitor;
            insertVIP(vip);
        } else {
            queue.addLast(visitor);
            System.out.println(visitor.getName() + " joined the queue for " + name);
        }
    }

    private void insertVIP(VIPVisitor vip) {
        int index = 0;
        for (Visitor v : queue) {
            if (v instanceof VIPVisitor) {
                VIPVisitor other = (VIPVisitor) v;
                if (vip.getLevel().compareTo(other.getLevel()) < 0) {
                    break;
                }
            } else {
                break;
            }
            index++;
        }
        queue.add(index, vip);
        System.out.println(vip.getName() + " (" + vip.getLevel() + ") joined the queue at position " + (index + 1));
    }

    public void startRide() {
        System.out.println("\nStarting ride: " + name);
        int riders = 0;
        while (riders < capacity && !queue.isEmpty()) {
            Visitor rider = queue.poll();
            System.out.println(" - " + rider.getName() + " is enjoying the ride!");
            riders++;
        }
        if (riders == 0) {
            System.out.println("No visitors in queue for " + name);
        }
        endRide();
    }

    public void endRide() {

        System.out.println("\nThe ride " + name + " has ended.");
        queue.clear();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (Capacity: " + capacity + ", Duration: " + duration + " mins)";
    }
}
