// Ride.java
public class Ride {
    private String name;
    private double price;
    private int minHeight;

    public Ride(String name, double price, int minHeight) {
        this.name = name;
        this.price = price;
        this.minHeight = minHeight;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getMinHeight() {
        return minHeight;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", minHeight=" + minHeight +
                '}';
    }
}
