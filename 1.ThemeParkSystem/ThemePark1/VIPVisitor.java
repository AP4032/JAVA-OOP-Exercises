package ThemePark1 ;

public class VIPVisitor extends Visitor{

    public VIPVisitor(String name , int ticket){
        super(name , ticket);
    }

    public void getPriorityAccess(Ride ride) {
        System.out.println(getname() + " gets priority access to " + ride);
    }

}
