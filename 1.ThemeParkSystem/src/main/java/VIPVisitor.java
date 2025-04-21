public class VIPVisitor extends Visitor {
    public VIPVisitor(String name) {
        super(name);
    }

    @Override
    public boolean isVIP() {
        return true;
    }
}