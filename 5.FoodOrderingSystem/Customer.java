import java.util.List;

public class Customer {
    private final String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Order getOrder(MenuItem menuItem) {
        Order order = new Order();
        order.addToOrderList(menuItem);
        return order;
    }
}
