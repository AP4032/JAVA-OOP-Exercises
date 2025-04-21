import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private List<MenuItem> menu;
    private List<Order> orders;

    public Restaurant(String name) {
        this.name = name;
        this.menu = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public void updateOrderStatus(Order order, String status) {
        order.setStatus(status);
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public String getName() {
        return name;
    }
}