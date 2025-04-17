import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String phoneNumber;
    private List<Order> orderHistory;

    public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.orderHistory = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orderHistory.add(order);
    }

    public void printOrderHistory() {
        if (orderHistory.isEmpty()) {
            System.out.println("No orders found for " + name);
            return;
        }

        System.out.println("Order history for " + name + ":");
        for (int i = 0; i < orderHistory.size(); i++) {
            System.out.println("Order #" + (i + 1));
            System.out.println(orderHistory.get(i));
        }
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{name='" + name + "', phoneNumber='" + phoneNumber + "'}";
    }
}

