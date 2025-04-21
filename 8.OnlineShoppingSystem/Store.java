import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> inventory;

    public Store() {
        this.inventory = new ArrayList<>();
    }

    public void addProduct(Product product) {
        inventory.add(product);
    }

    public List<Product> getProducts() {
        return inventory;
    }
}
