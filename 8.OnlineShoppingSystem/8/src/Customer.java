import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String id;
    private String name;
    private String email;
    private String password;
    private ShoppingCart cart;
    private List<Order> orderHistory;

    public Customer(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.cart = new ShoppingCart();
        this.orderHistory = new ArrayList<>();
    }

    public void addToCart(Product product, int quantity) {
        cart.addItem(product, quantity);
    }

    public void viewCart() {
        cart.displayCart();
    }

    public void placeOrder(Payment payment) {
        if (cart.getItems().isEmpty()) {
            System.out.println("Your cart is empty!");
            return;
        }

        Order order = new Order(this, cart.getItems(), cart.getQuantities(), payment);
        orderHistory.add(order);
        cart.clear();
        System.out.println("Order placed successfully!");
        order.displayOrder();
    }

    public void viewOrderHistory() {
        System.out.println("\nOrder History for " + name + ":");
        for (Order order : orderHistory) {
            order.displayOrder();
            System.out.println("-------------------");
        }
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public ShoppingCart getCart() { return cart; }
}