import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer;
    private Restaurant restaurant;
    private List<MenuItem> items;
    private String orderTime;
    private String deliveryTime;
    private String status;

    public Order(Customer customer, Restaurant restaurant) {
        this.customer = customer;
        this.restaurant = restaurant;
        this.items = new ArrayList<>();
        this.status = "Pending"; // Default status
    }

    // Getters and Setters
    public Customer getCustomer() {
        return customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void removeItem(MenuItem item) {
        items.remove(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void displayOrder() {
        System.out.println("Order Details:");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Restaurant: " + restaurant.getName());
        System.out.println("Items:");
        for (MenuItem item : items) {
            System.out.println(" - " + item.getName() + " ($" + item.getPrice() + ")");
        }
        System.out.println("Total: $" + calculateTotal());
        System.out.println("Status: " + status);
    }
}
