import java.util.LinkedList;
import java.util.Queue;

public class Ride {
    private String name;
    private int capacity;
    private int capacityVIP;
    private int[] TicketVIP=new int[50];
    private int Nobat=0;
    private int duration;
    private Queue<Visitor> queue;
    private Queue<Visitor> queueVIP;

    public Ride(String name, int capacity,int capacityVIP, int duration) {
        this.name = name;
        this.capacity = capacity;
        this.capacityVIP=capacityVIP;
        this.duration = duration;
        this.queue = new LinkedList<>();
        this.queueVIP= new LinkedList<>();
    }

    public void addVisitor(Visitor visitor) {
        if (queue.size() < capacity) {
            queue.add(visitor);
            System.out.println(visitor.getName() + " joined the queue for " + name);
        } else {
            System.out.println("Queue is full for " + name);
        }
    }
    public void addVisitorVIP(VIPVisitor VIPvisitor){
        if(queueVIP.size()< capacityVIP){
            queueVIP.add(VIPvisitor);
            TicketVIP[Nobat]=3;
            Nobat++;
            System.out.println(VIPvisitor.getName() + " joined the queue for " + name);
        }else  System.out.println("Queue is full for " + name);
    }

    public void startRide() {
        System.out.println("Starting ride: " + name);
        System.out.println("------Normal Line------");
        for (int i = 0; i < capacity && !queue.isEmpty(); i++) {
            Visitor v = queue.poll();
            System.out.println(v.getName() + " is enjoying " + name);
        }
        System.out.println("------VIP Line------");
        for (int j = 0; j < capacityVIP; j++) {
            if(TicketVIP[j]>0) {
                Visitor V = queueVIP.poll();
                if(V!=null) {
                    queueVIP.add(V);
                    System.out.println(V.getName() + " is enjoying " + name);
                    TicketVIP[j]--;
                }
            }else{
                Visitor V = queueVIP.poll();
                if(V!=null){
                    System.out.println(V.getName()+ " is enjoying " + name);
                }

            }

        }
    }
    public String getname(){
        return name;
    }
    public int getCapacity(){
        return capacity;
    }
    public int getCapacityVIP(){
        return  capacityVIP;
    }
    public int getSizeCapacity(){
        return queue.size();
    }
    public int getSizeVIPCapacity(){
        return queueVIP.size();
    }
}
