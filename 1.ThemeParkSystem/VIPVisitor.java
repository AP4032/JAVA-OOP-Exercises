public class VIPVisitor extends Visitor {
    public VIPVisitor(String name) {
        super(name);
    }


    public void getPriorityAccess(Ride ride) {
        if (ride.getVipQueue().size() + ride.getQueue().size() < ride.getCapacity()) {
            ride.addVIPVisitor(this);
            System.out.println(getName() + " has received priority access to " + ride.getName());
        } else {
            System.out.println("Sorry, " + getName() + ". The queue is full for " + ride.getName());
        }
    }
}