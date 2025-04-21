package MyJava5;


import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private final List<Order> activeOrders;

    public Restaurant() {
        this.activeOrders = new ArrayList<>();
    }

    public void processNewOrder(Order order) {
        activeOrders.add(order);
        System.out.println("Restaurant: Received new order. Current status: " + order.getCurrentStatus());
    }

    public void setOrderStatus(Order order, String status) {
        order.changeStatus(status);
        System.out.println("Restaurant: Order status changed to '" + status + "'.");
    }
}
