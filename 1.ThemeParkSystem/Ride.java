import java.util.LinkedList;
import java.util.Queue;
public class Ride {
    private String name;
    private int capacity;
    private int duration;
    private Queue<Visitor> queue;
    private Queue<VIPVisitor> vipQueue;

    public Ride(String name,int capacity,int duration){
        this.name = name;
        this.capacity = capacity;
        this.duration = duration;
        this.queue = new LinkedList<>();
        this.vipQueue = new LinkedList<>();
    }

    public void addVisitor(Visitor visitor){
        if(queue.size() + vipQueue.size() < capacity){
            if(visitor instanceof VIPVisitor){
                vipQueue.add((VIPVisitor)visitor);
                ((VIPVisitor) visitor).getPriorityAccess(this);
                System.out.println(visitor.getName() + " joined the VIP queue for " + name);
            }else{
                queue.add(visitor);
                System.out.println(visitor.getName() + " joined the queue for " + name);
            }
        }else{
            System.out.println("Queue is full for " + name);
        }
    }

    public void startRide(){
        System.out.println("Starting ride: " + name);
        Queue<Visitor> combinedQueue = new LinkedList<>();
        combinedQueue.addAll(vipQueue);
        combinedQueue.addAll(queue);

        vipQueue.clear();
        queue.clear();

        for (int i = 0; i < capacity && !combinedQueue.isEmpty() ; i++) {
            Visitor v = combinedQueue.poll();
            System.out.println(v.getName() + " is enjoying " + name);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return name;
    }
}


