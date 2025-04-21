import java.util.Scanner;
import java.util.List;

public class Restaurant {
    private Menu menu;
    private OrderList orderList;
    private Scanner scanner;

    public Restaurant() {
        this.menu = new Menu();
        this.orderList = new OrderList();
        this.scanner = new Scanner(System.in);
    }

    public void placeNewOrder() {
        System.out.print("\nCustomer Name: ");
        String name = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phone = scanner.nextLine();
        System.out.print("Delivery Address: ");
        String address = scanner.nextLine();

        Customer customer = new Customer(name, phone, address);
        Order order = new Order(customer);

        boolean ordering = true;
        while (ordering) {
            menu.displayMenu();
            System.out.print("Select item (0 to finish): ");
            int itemChoice = scanner.nextInt();
            scanner.nextLine();

            if (itemChoice == 0) {
                ordering = false;
            } else if (itemChoice > 0 && itemChoice <= menu.getMenuSize()) {
                MenuItem item = menu.getItem(itemChoice);
                order.addItem(item);
                System.out.println(item.getName() + " added to order");
            } else {
                System.out.println("Invalid selection!");
            }
        }

        if (!order.getItems().isEmpty()) {
            processPayment(order);
            setupDelivery(order, customer);
            order.updateStatus("CONFIRMED");
            orderList.addOrder(order);
            System.out.println("\nOrder placed successfully!");
            order.displayOrder();
        } else {
            System.out.println("No items ordered.");
        }
    }

    private void processPayment(Order order) {
        System.out.print("\nPayment Method (CASH/CREDIT): ");
        String paymentMethod = scanner.nextLine();
        Payment payment = new Payment("PAY-" + order.getOrderId(),
                order.calculateTotal(),
                paymentMethod);
        payment.processPayment();
        order.setPayment(payment);
    }

    private void setupDelivery(Order order, Customer customer) {
        Delivery delivery = new Delivery("DEL-" + order.getOrderId(),
                customer.getAddress());
        order.setDelivery(delivery);
    }

    public void manageOrders() {
        List<Order> activeOrders = orderList.getActiveOrders();
        if (activeOrders.isEmpty()) {
            System.out.println("No active orders to manage");
            return;
        }

        System.out.println("\n=== ACTIVE ORDERS ===");
        for (Order order : activeOrders) {
            System.out.println(order.getOrderId() + " - " +
                    order.getCustomer().getName() +
                    " (" + order.getStatus() + ")");
        }

        System.out.print("\nEnter Order ID to manage (0 to cancel): ");
        int orderId = scanner.nextInt();
        scanner.nextLine();

        if (orderId == 0) return;

        Order order = orderList.findOrderById(orderId);
        if (order == null) {
            System.out.println("Order not found!");
            return;
        }

        manageOrderStatus(order);
    }

    private void manageOrderStatus(Order order) {
        order.displayOrder();
        System.out.println("\n1. Mark as Preparing");
        System.out.println("2. Mark as Out for Delivery");
        System.out.println("3. Mark as Delivered");
        System.out.println("4. Cancel Order");
        System.out.println("0. Back");
        System.out.print("Select action: ");

        int action = scanner.nextInt();
        scanner.nextLine();

        switch (action) {
            case 1:
                order.updateStatus("PREPARING");
                order.getDelivery().updateStatus("PREPARING", "45 minutes");
                break;
            case 2:
                order.updateStatus("OUT_FOR_DELIVERY");
                order.getDelivery().updateStatus("ON_THE_WAY", "30 minutes");
                break;
            case 3:
                order.updateStatus("DELIVERED");
                order.getDelivery().updateStatus("DELIVERED", "0 minutes");
                break;
            case 4:
                order.updateStatus("CANCELLED");
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid action");
        }

        System.out.println("Order status updated");
        order.displayOrder();
    }

    public void displayAllOrders() {
        orderList.displayAllOrders();
    }

    public void displayMenu() {
        menu.displayMenu();
    }
}