import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> items;
    private String status;
    private double totalPrice;
    private Customer customer;  // Reference to Customer

    // Constructor with customer
    public Order(Customer customer) {
        this.customer = customer;
        this.items = new ArrayList<>();
        this.status = "Pending";
        this.totalPrice = 0;
    }

    // Default constructor (no customer)
    public Order() {
        this.items = new ArrayList<>();
        this.status = "Pending";
        this.totalPrice = 0;
    }

    // Add item to the order
    public void addItem(MenuItem item) {
        items.add(item);
        totalPrice += item.getPrice();
    }

    // Calculate total price of order
    public double calculateTotal() {
        return totalPrice;
    }

    // Update order status
    public void updateStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    // Get customer for delivery address
    public Customer getCustomer() {
        return customer;
    }

    // Display order details
    public void displayOrderDetails() {
        System.out.println("\nOrder Details:");
        for (MenuItem item : items) {
            item.displayInfo();
        }
        System.out.println("Total Price: $" + totalPrice);
        System.out.println("Status: " + status);
    }
}