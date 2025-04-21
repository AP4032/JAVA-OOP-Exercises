import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product product) {
        items.add(product);
        System.out.println(product.getName() + " added to cart.");
    }
    public void removeItem(Product product) {
        if (items.remove(product)) {
            System.out.println(product.getName() + " removed from cart.");
        } else {
            System.out.println("Product not found in cart.");
        }
    }
    public double calculateTotal() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }
    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("Your shopping cart is empty.");
        } else {
            System.out.println("Items in your shopping cart:");
            for (Product item : items) {
                System.out.println(item.toString());
            }
            System.out.println("Total: $" + calculateTotal());
        }
    }
    public void checkout() {
        System.out.println("Total amount: $" + calculateTotal());
        System.out.println("Order placed successfully!");
        items.clear();
    }
}