import java.util.LinkedList;
import java.util.Queue;

public class Ride {
    private String name;
    private int capacity;
    private int duration;
    private Queue<Visitor> queue;
    private Queue<VIPVisitor> vipQueue;
    public Ride(String name, int capacity, int duration){
        this.name=name;
        this.capacity=capacity;
        this.duration=duration;
        this.queue= new LinkedList<>();
        this.vipQueue=new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Queue<Visitor> getQueue() {
        return queue;
    }

    public void setQueue(Queue<Visitor> queue) {
        this.queue = queue;
    }

    public Queue<VIPVisitor> getVipQueue() {
        return vipQueue;
    }

    public void setVipQueue(Queue<VIPVisitor> vipQueue) {
        this.vipQueue = vipQueue;
    }

    public void addVIPVisitor(VIPVisitor VIPVisitor){
        if(vipQueue.size() + queue.size() < capacity) {
            vipQueue.add(VIPVisitor);
            System.out.println(VIPVisitor.getName() + " joined the queue for " + name);
        }else{
            System.out.println(" Queue is full for " + name);
        }
    }
    public void addVisitor(Visitor visitor) {
        if (vipQueue.size() + queue.size() < capacity) {
                queue.add(visitor);
                System.out.println(visitor.getName() + " joined the queue for " + name);
        } else {
            System.out.println(" Queue is full for " + name);
        }
    }

    public void startRide(){
        System.out.println("Starting Ride: " + name);
        for(Visitor vip : vipQueue){
            System.out.println(vip.getName() + " is enjoying the ride");
        }
        for(Visitor visitor : queue){
            System.out.println( visitor.getName() + " is enjoying the ride");
        }
        queue.clear();
        vipQueue.clear();
    }
}
