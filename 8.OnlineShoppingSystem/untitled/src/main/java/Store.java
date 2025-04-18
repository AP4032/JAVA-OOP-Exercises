import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> inventory;

    public Store() {
        inventory = new ArrayList<>();
    }


    public void addProduct(Product product) {
        inventory.add(product);
        System.out.println( product.getName() + " added to store.");
    }


    public void showProducts() {
        if (inventory.isEmpty()) {
            System.out.println(" Store is empty.");
            return;
        }
        System.out.println(" Available products:");
        for (Product product : inventory) {
            product.printInfo();
        }
    }


    public Product getProductById(int id) {
        for (Product product : inventory) {
            if (product.getId() == id) {
                return product;
            }
        }
        System.out.println(" Product with ID " + id + " not found.");
        return null;
    }

    public List<Product> getInventory() {
        return inventory;
    }
}
