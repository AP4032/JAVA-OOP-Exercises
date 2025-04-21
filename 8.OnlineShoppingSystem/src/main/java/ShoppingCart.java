import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product product) {
        items.add(product);
        System.out.println(product.getName() + " added to cart.");
    }

    public double calculateTotal() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty!");
        } else {
            System.out.println("\n=== Shopping Cart ===");
            for (Product item : items) {
                System.out.println(item);
            }
            System.out.println("Total amount: $" + calculateTotal());
        }
    }

    public Order checkout() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty, nothing to checkout!");
            return null;
        }
        System.out.println("\n=== Order Summary ===");
        displayCart();
        System.out.println("Order placed successfully!");
        Order order = new Order(items, calculateTotal());
        items.clear();
        return order;
    }
}