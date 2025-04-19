import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> items;
    private String status;

    public Order(String status) {
        this.items = new ArrayList<>();
        this.status = status;
    }

    public void addItems(MenuItem item) {
        items.add(item);
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public double getTotalAmount() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }
}