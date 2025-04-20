import java.util.LinkedList;
import java.util.Queue;

public class Ride {
    private String name;
    private int capacity;
    private int duration;
    private Queue<Visitor> queue;

    public Ride(String name, int capacity, int duration) {
        this.name = name;
        this.capacity = capacity;
        this.duration = duration;
        this.queue = new LinkedList<>();
    }

    public void addVisitor(Visitor visitor) {
        if (queue.size() < capacity) {
            queue.add(visitor);
            System.out.println(visitor.getName() + " به صف " + name + " پیوست");
        } else {
            System.out.println("صف " + name + " تکمیل است");
        }
    }

    public void startRide() {
        System.out.println("شروع وسیله بازی: " + name);
        for (int i = 0; i < capacity && !queue.isEmpty(); i++) {
            Visitor v = queue.poll();
            System.out.println(v.getName() + " در حال استفاده از " + name + " است");
        }
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name;
    }
}