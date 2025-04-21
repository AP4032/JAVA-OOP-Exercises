import java.util.ArrayList;

public class Ride {
    private String name;
    private int capacity;
    private int duration; // دقیقه

    public Ride(String name, int capacity, int duration) {
        this.name = name;
        this.capacity = capacity;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void fillFromQueue(ArrayList<Visitor> queue) {
        System.out.println("\nStarting ride: " + name);
        int count = 0;

        for (int i = 0; i < queue.size(); i++) {
            if (count >= capacity) {
                break;
            }

            Visitor v = queue.get(i);
            System.out.println(" - " + v.getName() + (v.isVIP() ? " [VIP]" : ""));
            count++;
        }

        for (int i = 0; i < count; i++) {
            queue.remove(0); // حذف از صف
        }
    }

    public void start() {
        System.out.println("Ride is running for " + duration + " minutes...");
    }
}