import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<Order> allOrders;

    public Restaurant() {
        this.allOrders = new ArrayList<>();
    }

    public void receiveOrder(Order order) {
        allOrders.add(order);
    }

    public void printOrders() {
        if (allOrders.isEmpty()) {
            System.out.println("No orders placed yet.");
            return;
        }

        for (int i = 0; i < allOrders.size(); i++) {
            System.out.println("Order #" + (i + 1));
            System.out.println(allOrders.get(i));
            System.out.println("----------------------");
        }
    }

    public Order getOrderByIndex(int index) {
        return allOrders.get(index);
    }

    public int getTotalOrders() {
        return allOrders.size();
    }

    public void updateOrderStatus(Order order, String newStatus) {
        order.setStatus(newStatus);
        System.out.println("Order status updated to: " + newStatus);
    }
}

