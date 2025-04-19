import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurant {
    private List<Order> orders;

    public Restaurant() {
        this.orders = new ArrayList<>();
    }

    public void receiveOrder(Order order) {
        orders.add(order);
        System.out.println("New order received!");
    }

    public void updateOrderStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter order number to update (1-" + orders.size() + "): ");
        int orderNumber = scanner.nextInt();
        scanner.nextLine();

        if (orderNumber > 0 && orderNumber <= orders.size()) {
            System.out.println("Enter new status: ");
            String newStatus = scanner.nextLine();
            orders.get(orderNumber - 1).updateStatus(newStatus);
        } else {
            System.out.println("Invalid order number.");
        }
    }
}