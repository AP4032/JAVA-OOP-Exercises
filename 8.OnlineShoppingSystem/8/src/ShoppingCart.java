import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> items;
    private List<Integer> quantities;

    public ShoppingCart() {
        this.items = new ArrayList<>();
        this.quantities = new ArrayList<>();
    }

    public void addItem(Product product, int quantity) {
        if (product.getStock() >= quantity) {
            items.add(product);
            quantities.add(quantity);
            System.out.println(quantity + " x " + product.getName() + " added to cart.");
        } else {
            System.out.println("Not enough stock for " + product.getName());
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getPrice() * quantities.get(i);
        }
        return total;
    }

    public void displayCart() {
        System.out.println("\nYour Shopping Cart:");
        for (int i = 0; i < items.size(); i++) {
            Product item = items.get(i);
            int quantity = quantities.get(i);
            System.out.println(quantity + " x " + item.getName() + " @ $" + item.getPrice() + " each");
        }
        System.out.println("Total: $" + calculateTotal());
    }

    public List<Product> getItems() { return items; }
    public List<Integer> getQuantities() { return quantities; }

    public void clear() {
        items.clear();
        quantities.clear();
    }
}