import java.util.LinkedList;
import java.util.Deque;

public class Ride{
    private String name;
    private int capacity;
    private int duration;
    private Deque<Visitor> queue;

    public Ride(String name , int capacity , int duration){
        this.name = name;
        this.capacity = capacity;
        this.duration = duration;
        this.queue = new LinkedList<>();
    }

    public void addVisitor(Visitor visitor){
        if(visitor.hasPriority()){
            queue.addFirst(visitor);
        } else {
            queue.addLast(visitor);
        }
    }

    public void startRide(){
        System.out.println("Starting ride : " + name);
        int count=0; 
        while(count < capacity && !queue.isEmpty()){
            Visitor v = queue.poll();
            System.out.println(" - " + v.getName() + " is riding.");
            count++;
        }
        System.out.println("Ride duration : " + duration + "minutes.\n");
    }

    public String getName(){
        return name;
    }

    public int getCapacity(){
        return capacity;
    }

    public int getDuration(){
        return duration;
    }

    

}