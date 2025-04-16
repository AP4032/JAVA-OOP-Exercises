public class VIPVisitor extends Visitor {

    public VIPVisitor(String name, int height) {
        super(name, height); 
    }

    @Override
    public void joinQueue(Ride ride) {
        if (ride != null) {
            ride.addToQueue(this);  
            System.out.println(getName() + " (VIP) has joined the queue for " + ride.getName());
        }
    }
}