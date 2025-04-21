import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int nextOrderId = 1;
    private int orderId;
    private Customer customer;
    private List<MenuItem> items;
    private String status;
    private Payment payment;
    private Delivery delivery;

    public Order(Customer customer) {
        this.orderId = nextOrderId++;
        this.customer = customer;
        this.items = new ArrayList<>();
        this.status = "PENDING";
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public List<MenuItem> getItems() {
        return new ArrayList<>(items);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void updateStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void displayOrder() {
        System.out.println("\n=== ORDER DETAILS ===");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.getName());
        System.out.println("\nItems Ordered:");
        items.forEach(item -> System.out.println("- " + item));
        System.out.printf("\nTotal: $%.2f\n", calculateTotal());
        System.out.println("Status: " + status);
        System.out.println("====================");
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }
}