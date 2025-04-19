import java.util.ArrayList;

public class Restaurant {
    private ArrayList<Order> orders;
    private ArrayList<MenuItem> menu;
    private ArrayList<Customer> customers;

    public Restaurant() {
        this.orders = new ArrayList<>();
        this.menu = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.initMenu();
    }
    //================================
    //GETTERS
    //================================
    public ArrayList<Customer> getCustomers() {
        return customers;
    }
    public ArrayList<MenuItem> getMenuItem() {
        return menu;
    }

    public void receiveOrder(Order order) {
        orders.add(order);
        System.out.println("New order received. Status: " + order.getStatus());
    }

    //Simple method to put some items in the menu.
    public void initMenu() {
        menu.add(new MenuItem("Burger", 5.99));
        menu.add(new MenuItem("Pizza", 8.99));
        menu.add(new MenuItem("Pasta", 7.49));
        menu.add(new MenuItem("Salad", 4.99));
        menu.add(new MenuItem("Sushi", 12.99));
        menu.add(new MenuItem("Steak", 15.99));
        menu.add(new MenuItem("Tacos", 6.49));
        menu.add(new MenuItem("Sandwich", 4.75));
        menu.add(new MenuItem("Fries", 2.99));
        menu.add(new MenuItem("Ice Cream", 3.50));
    }

    //Method to change the status of the order.
    public void updateOrderStatus(int orderID, String newStatus) {
        for (Order order : orders) {
            if (order.getOrderId() == orderID) {
                order.updateStatus(newStatus);
                System.out.println("✅ Order #" + orderID + " status updated to: " + newStatus);
                return;
            }
        }
        System.out.println("❌ Order with ID #" + orderID + " not found.");
    }

    public void printOrders() {
        System.out.println("\n");
        if (orders.isEmpty()) {
            System.out.println("There is no order :(");
        } else {
            for (Order o : orders) {
                System.out.println(o); // THIS LINE prints order details!
                System.out.println();
            }
        }
        System.out.println("\n");
    }

    public void printMenu() {
        System.out.println("\n");
        for (MenuItem item : menu) {
            System.out.println("Item :" + item.getName() + " | Price :" + item.getPrice());
        }
        System.out.println("\n");
    }
}
