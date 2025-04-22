import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Product, Integer> currentItems = new HashMap<>();

    public void addProduct(Product product) {
        if (product.getStockCount() > 0) {
            currentItems.put(product, currentItems.getOrDefault(product, 0) + 1);
            product.setStockCount(product.getStockCount() - 1);
            System.out.println(product.getProductName() + " added to cart.");
        } else {
            System.out.println("Product out of stock: " + product.getProductName());
        }
    }

    public void removeProduct(Product product) {
        if (currentItems.containsKey(product)) {
            int quantity = currentItems.get(product);
            if (quantity == 1) {
                currentItems.remove(product);
            } else {
                currentItems.put(product, quantity - 1);
            }
            product.setStockCount(product.getStockCount() + 1);
            System.out.println(product.getProductName() + " removed from cart.");
        } else {
            System.out.println("Product not in cart.");
        }
    }

    public void calculateTotalPrice() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : currentItems.entrySet()) {
            total += entry.getKey().getProductPrice() * entry.getValue();
        }
        System.out.printf("Total Price: %.2f%n", total);
    }

    public void displayCartContents() {
        if (currentItems.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        for (Map.Entry<Product, Integer> entry : currentItems.entrySet()) {
            Product p = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(p.getProductName() +
                    " | Quantity: " + quantity +
                    " | Price: " + p.getProductPrice());
        }
    }
}
