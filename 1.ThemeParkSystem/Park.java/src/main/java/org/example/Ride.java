package org.example;

public class Ride {
    private String name;
    private int capacity;
    private int duration;
    private Visitor[] queue;
    private int queueSize;
    public Ride(String name , int capacity , int duration){
        this.name = name;
        this.capacity = capacity;
        this.duration = duration;
        this.queue = new Visitor[capacity];
    }
    public void addVisitor(Visitor visitor){
        if (queueSize >= capacity){
            System.out.println("Queue is full!");
            return;
        }
        if (visitor instanceof  VIPVisitor){
            for (int i = queueSize; i > 0; i--){
                queue[i] = queue[i - 1];
            }
            queue[0] = visitor;
            queueSize++;
            System.out.println(visitor.getName() + " VIP added to the beginning of the queue.");
        }else {
            queue[queueSize++] = visitor;
            System.out.println(visitor.getName() + " added to the queue.");
        }
    }
    public void removeVisitor(String visitorName){
        for (int i = 0; i < queueSize; i++){
            if (queue[i].getName().equals(visitorName)){
                for (int j = i; j < queueSize -1; j++){
                    queue[j] = queue[j + 1];
                }
                queueSize--;
                System.out.println(visitorName + " removed from " + name);
                return;
            }
        }
        System.out.println(visitorName + " not found in " + name);
    }
    public void startRide(){
        System.out.println("Ride " + name + " started! Duration: " + duration);
        queueSize = 0;
    }

    public void removeVisitor(){

    }
    public String getName(){
        return name;
    }
    public int getCapacity() {
        return capacity;
    }
    public int getDuration(){
        return duration;
    }
}

