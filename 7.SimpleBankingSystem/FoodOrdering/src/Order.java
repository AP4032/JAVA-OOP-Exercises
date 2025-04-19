import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> items;
    private String status;

    public Order() {
        this.items = new ArrayList<>();
        this.status = "Pending";
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void updateStatus(String status) {
        this.status = status;
        System.out.println("Order status updated to: " + status);
    }

    public void displayOrder() {
        System.out.println("\nOrder Summary:");
        for (MenuItem item : items) {
            System.out.println(item);
        }
        System.out.println("Total: $" + calculateTotal());
        System.out.println("Status: " + status);
    }
}