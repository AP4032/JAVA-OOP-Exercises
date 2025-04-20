public class Visitor {

    private String name ;

    public Visitor(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "visitor: " + name ;
    }
}
