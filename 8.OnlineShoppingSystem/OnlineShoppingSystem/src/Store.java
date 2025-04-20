import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> inventory;

    public Store() {
        this.inventory = new ArrayList<>();
    }

    public void addProduct(Product product) {
        inventory.add(product);
        System.out.println(" " + product.getName() + " added to store.");
    }

    public List<Product> getProducts() {
        return inventory;
    }

    public void showProducts() {
        System.out.println("\n Available Products:");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println((i + 1) + ". " + inventory.get(i));
        }
    }
}
