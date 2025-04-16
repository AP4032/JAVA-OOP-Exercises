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

    public void joinQueue(Ride ride) {
        if (ride != null) {
            ride.addToQueue(this);
            System.out.println(name + " has joined the queue for " + ride.getName());
        }
    }

    @Override
    public String toString() {
        return "Visitor{name='" + name + "', height=" + height + '}';
    }
}