public class Visitor {
    protected String name;

    public Visitor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isVIP() {
        return false;
    }
}