import java.util.ArrayList;
import java.util.Random;

public class Order {
    private ArrayList<MenuItem> items;
    private int orderId;
    private String status;

    public Order() {
        Random rand = new Random();
        this.items = new ArrayList<>();
        this.status = "Pending";
        this.orderId = rand.nextInt(5000) + 1000;
    }
    //================================
    //GETTERS
    //================================
    public String getStatus() {
        return status;
    }
    public ArrayList<MenuItem> getItems() {
        return items;
    }
    public int getOrderId(){
        return orderId;
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
    //setter for status property
    public void updateStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Order #" + orderId + " | Status: " + status + "\n");
        for (MenuItem item : items) {
            sb.append("- ").append(item).append("\n");
        }
        sb.append("Total: $").append(String.format("%.2f", calculateTotal()));
        return sb.toString();
    }
}

