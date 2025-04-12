package main;

public class VIPVisitor extends Visitor {
    public VIPVisitor(String name) {
        super(name);
    }

    public void priorAccess() {
        System.out.println(getName() + " has prior access to this ride\nThey will ride twice longer");
    }
}
