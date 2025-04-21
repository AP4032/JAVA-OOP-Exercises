import java.util.ArrayList;
import java.util.List;

public class OrderList {
    private List<Order> orders;

    public OrderList() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getActiveOrders() {
        List<Order> activeOrders = new ArrayList<>();
        for (Order order : orders) {
            if (!order.getStatus().equals("COMPLETED")) {
                activeOrders.add(order);
            }
        }
        return activeOrders;
    }

    public Order findOrderById(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }

    public void displayAllOrders() {
        System.out.println("\n=== ALL ORDERS ===");
        for (Order order : orders) {
            order.displayOrder();
        }
        System.out.println("=================");
    }
}