import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<Order> orders;

    public Restaurant() {
        this.orders = new ArrayList<>();
    }

    // Receive an order from a customer
    public void receiveOrder(Order order) {
        orders.add(order);
        System.out.println("New order received. Status: " + order.getStatus());
    }

    // Update the status of an order
    public void updateOrderStatus(Order order, String status) {
        order.updateStatus(status);
        System.out.println("Order status updated to: " + status);
    }

    // Simulate payment processing
    public void processPayment(Order order) {
        System.out.println("Processing payment for order. Total: $" + order.calculateTotal());
        System.out.println("Payment successful!");
        order.updateStatus("Completed");
    }

    // Simulate delivery tracking
    public void trackDelivery(Order order) {
        String status = order.getStatus();
        if (status.equals("Completed")) {
            System.out.println("The order has been delivered to: " + order.getCustomer().getAddress());
        } else {
            System.out.println("Order is still in progress.");
        }
    }

    // Display all orders
    public void displayOrders() {
        for (Order order : orders) {
            order.displayOrderDetails();
        }
    }

    // Get all orders
    public List<Order> getOrders() {
        return orders;
    }
}