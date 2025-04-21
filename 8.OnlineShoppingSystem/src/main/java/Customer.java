import java.util.ArrayList;

public class Customer {
    private String name;
    private ShoppingCart cart;
    private ArrayList<Order> orderHistory;

    public Customer(String name) {
        this.name = name;
        this.cart = new ShoppingCart();
        this.orderHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void addToCart(Product product) {
        cart.addItem(product);
    }

    public void placeOrder() {
        Order order = cart.checkout();
        if (order != null) {
            orderHistory.add(order);
        }
    }

    public void displayOrderHistory() {
        if (orderHistory.isEmpty()) {
            System.out.println("No orders placed yet!");
        } else {
            System.out.println("\n=== Order History for " + name + " ===");
            for (Order order : orderHistory) {
                order.displayOrder();
            }
        }
    }
}