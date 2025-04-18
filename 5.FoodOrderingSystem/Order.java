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
            total += item.getTotalPrice();
        }
        return total;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (MenuItem item : items) {
            sb.append(item).append("\n");
        }
        sb.append("Total: $").append(String.format("%.2f", calculateTotal())).append("\n");
        sb.append("Status: ").append(status);
        return sb.toString();
    }
}
