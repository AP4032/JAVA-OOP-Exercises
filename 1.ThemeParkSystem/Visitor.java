// Visitor.java
public class Visitor {
    private String name;
    private int height;

    public Visitor(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}
