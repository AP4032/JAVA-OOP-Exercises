import java.util.ArrayList;
import java.util.List;

public class order {
    private List<menuItem> items;
    private String status;

    public order() {
        this.items = new ArrayList<>();
        this.status = "Pending";
    }

    public void addItem(menuItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (menuItem item : items) {
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
        for (menuItem item : items) {
            System.out.println(item);
        }
        System.out.println("Total: $" + calculateTotal());
        System.out.println("Status: " + status);
    }
}