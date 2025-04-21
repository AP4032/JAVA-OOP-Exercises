import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> inventory;
    private List<String> categories;

    public Store() {
        this.inventory = new ArrayList<>();
        this.categories = new ArrayList<>();
        initializeStore();
    }

    private void initializeStore() {
        categories.add("Electronics");
        categories.add("Clothing");
        categories.add("Books");
        categories.add("Home");


        addProduct(new Product("P1001", "Laptop", 999.99, 10, "Electronics"));
        addProduct(new Product("P1002", "Smartphone", 499.99, 15, "Electronics"));
        addProduct(new Product("P1003", "T-Shirt", 19.99, 50, "Clothing"));
        addProduct(new Product("P1004", "Java Programming Book", 39.99, 20, "Books"));
    }

    public void addProduct(Product product) {
        inventory.add(product);
        if (!categories.contains(product.getCategory())) {
            categories.add(product.getCategory());
        }
    }

    public void displayProductsByCategory(String category) {
        System.out.println("\nProducts in " + category + ":");
        for (Product product : inventory) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                product.displayInfo();
                System.out.println("-------------------");
            }
        }
    }

    public void displayAllCategories() {
        System.out.println("\nAvailable Categories:");
        for (String category : categories) {
            System.out.println("- " + category);
        }
    }

    public Product findProductById(String id) {
        for (Product product : inventory) {
            if (product.getId().equalsIgnoreCase(id)) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getInventory() { return inventory; }
    public List<String> getCategories() { return categories; }
}