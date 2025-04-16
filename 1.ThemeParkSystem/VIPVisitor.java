public class VIPVisitor extends Visitor{
    public VIPVisitor(String name) {
        super(name);
    }

    public void getPriorityAccess(Ride ride) {
        System.out.println(getName() + " gets priority access to " + ride);
    }
}
