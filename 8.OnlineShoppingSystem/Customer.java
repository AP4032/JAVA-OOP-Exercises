import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private ShoppingCart cart;
    private List<ShoppingCart> orderHistory;  // To store past orders

    public Customer(String name) {
        this.name = name;
        this.cart = new ShoppingCart();
        this.orderHistory = new ArrayList<>();
    }

    // Add item to the shopping cart
    public void addToCart(Product product, int quantity) {
        cart.addItem(product, quantity);
    }

    // Place an order and add it to order history
    public void placeOrder() {
        cart.checkout();
        orderHistory.add(cart);  // Store the cart in order history
        cart = new ShoppingCart();  // Reset the cart for the next purchase
    }

    // Show the customer's order history
    public void showOrderHistory() {
        System.out.println(name + "'s Order History:");
        if (orderHistory.isEmpty()) {
            System.out.println("No orders placed yet.");
        } else {
            for (ShoppingCart order : orderHistory) {
                System.out.println("Order total: $" + order.calculateTotal());
            }
        }
    }

    // view cart for the customer
    public void viewCart(){
        cart.viewCart();
    }

    // Get the customer's name
    public String getName() {
        return name;
    }

    // Get the customer's cart
    public ShoppingCart getCart() {
        return cart;
    }
}
