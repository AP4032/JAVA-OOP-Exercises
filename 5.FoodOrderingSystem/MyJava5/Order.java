package MyJava5;

import java.util.ArrayList;
import java.util.List;


public class Order {
    private final List<Menu> orderItems;
    private String currentStatus;

    public Order() {
        this.orderItems = new ArrayList<>();
        this.currentStatus = "Waiting";
    }

    public void addMenuItem(Menu item) {
        orderItems.add(item);
    }

    public double getTotalAmount() {
        double total = 0;
        for (Menu item : orderItems) {
            total += item.getUnitPrice();
        }
        return total;
    }

    public void changeStatus(String newStatus) {
        this.currentStatus = newStatus;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void printSummary() {
        System.out.println("Order Summary:");
        for (Menu item : orderItems) {
            System.out.println("- " + item);
        }
        System.out.println("Total to Pay: " + getTotalAmount() + " Toman");
        System.out.println("Status: " + currentStatus);
    }
}
