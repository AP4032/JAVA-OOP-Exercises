import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> inventory;

    public Store() {
        this.inventory = new ArrayList<>();
    }

    // Add a product to the store inventory
    public void addProduct(Product product) {
        inventory.add(product);
        System.out.println(product.getName() + " added to store.");
    }

    // Retrieve all products in the store
    public List<Product> getProducts() {
        return inventory;
    }
}
