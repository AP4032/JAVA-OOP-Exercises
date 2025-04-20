import java.util.List;
import java.util.ArrayList;

public class ShoppingCart {
    private List<Product> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product product) {
        if (product.getQuantity() > 0) {
            product.decreaseQuantity();
            items.add(product);
            System.out.println(" " + product.getName() + " added to cart.");
        } else {
            System.out.println(" " + product.getName() + " is out of stock!");
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void checkout() {
        if (items.isEmpty()) {
            System.out.println(" Cart is empty!");
            return;
        }

        System.out.println("\n Order Summary:");
        for (Product item : items) {
            System.out.println("- " + item.getName() + ": $" + item.getPrice());
        }
        System.out.println("Total: $" + calculateTotal());
        System.out.println(" Order placed successfully!");
        items.clear();
    }
}
