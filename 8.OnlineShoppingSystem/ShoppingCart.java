import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    // Add a product to the cart
    public void addItem(Product product, int quantity) {
        if (product.getStockQuantity() >= quantity) {
            for (int i = 0; i < quantity; i++) {
                items.add(product);
            }
            product.updateStock(quantity);  // Decrease the stock in the store
            System.out.println(quantity + " " + product.getName() + " added to cart.");
        } else {
            System.out.println("Not enough stock for " + product.getName());
        }
    }

    // Calculate total price of all items in the cart
    public double calculateTotal() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }

    // Show all items in the shopping cart
    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println("Your shopping cart is empty.");
        } else {
            System.out.println("Items in your cart:");
            for (Product item : items) {
                item.displayProductDetails();
            }
        }
    }

    // Checkout process (simulating payment)
    public void checkout() {
        double totalAmount = calculateTotal();
        System.out.println("Total amount: $" + totalAmount);

        PaymentGateway paymentGateway = new PaymentGateway();
        boolean paymentSuccess = paymentGateway.processPayment(totalAmount);

        if (paymentSuccess) {
            System.out.println("Order placed successfully!");
            items.clear();  // Clear the cart after successful payment
        } else {
            System.out.println("Payment failed. Please try again.");
        }
    }
}
