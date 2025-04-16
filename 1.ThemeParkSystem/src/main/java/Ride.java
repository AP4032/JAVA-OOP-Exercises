import java.util.LinkedList;
import java.util.Queue;

public class Ride {
    private String name;
    private int duration;      
    private int capacity;      
    private Queue<Visitor> queue;

    public Ride(String name, int duration, int capacity) {
        this.name = name;
        this.duration = duration;
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }
    
    public String getName() {
    return name;
}

public int getDuration() {
    return duration;
}

public int getCapacity() {
    return capacity;
}

    
    public void addToQueue(Visitor visitor) {
        if (visitor instanceof VIPVisitor) {
            
            LinkedList<Visitor> tempList = (LinkedList<Visitor>) queue;
            tempList.addFirst(visitor);
        } else {
            queue.add(visitor);
        }
    }

    public void startRide() {
    if (queue.size() < capacity) {
        System.out.println("🚫 Not enough people to start " + name + ". Need " + (capacity - queue.size()) + " more.");
        return;
    }

    System.out.println("🎢 Starting ride: " + name);
    for (int i = 0; i < capacity; i++) {
        Visitor v = queue.poll();
        System.out.println("✅ " + v.getName() + " is enjoying the ride!");
    }
    System.out.println("🎉 Ride finished!\n");
}

    @Override
    public String toString() {
        return "Ride{name='" + name + "', duration=" + duration + "min, capacity=" + capacity + "}";
    }
}