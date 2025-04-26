public class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Display item details
    public void displayInfo() {
        System.out.println("Item: " + name + " | Price: $" + price);
    }
}