import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Order {
    private String orderId;
    private Customer customer;
    private List<Product> items;
    private List<Integer> quantities;
    private LocalDateTime orderDate;
    private Payment payment;
    private String status;

    public Order(Customer customer, List<Product> items, List<Integer> quantities, Payment payment) {
        this.orderId = "ORD" + System.currentTimeMillis();
        this.customer = customer;
        this.items = items;
        this.quantities = quantities;
        this.orderDate = LocalDateTime.now();
        this.payment = payment;
        this.status = "Processing";
    }

    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getPrice() * quantities.get(i);
        }
        return total;
    }

    public void displayOrder() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("\nOrder ID: " + orderId);
        System.out.println("Date: " + orderDate.format(formatter));
        System.out.println("Customer: " + customer.getName());

        System.out.println("\nItems:");
        for (int i = 0; i < items.size(); i++) {
            Product item = items.get(i);
            int quantity = quantities.get(i);
            System.out.println(quantity + " x " + item.getName() + " @ $" + item.getPrice());
        }

        System.out.println("\nTotal: $" + calculateTotal());
        payment.displayPaymentDetails();
        System.out.println("Status: " + status);
    }

    public String getOrderId() { return orderId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}