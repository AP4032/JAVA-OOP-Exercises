public class VIPVisitor extends Visitor {
    public VIPVisitor(String name) {
        super(name);
    }

    public boolean hasPriority(){
        return true;
    }
}
