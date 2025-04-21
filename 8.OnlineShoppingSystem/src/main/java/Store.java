import java.util.ArrayList;

public class Store {
    private ArrayList<Product> products;

    public Store() {
        this.products = new ArrayList<>();
        
        products.add(new Product("Laptop", 999.99));
        products.add(new Product("phone", 499.99));
        products.add(new Product("Headphones", 99.99));
    }

    public boolean addProduct(String name, double price) {
        if (name.isEmpty()) {
            System.out.println("Product name cannot be empty!");
            return false;
        }
        if (price <= 0) {
            System.out.println("Price must be positive!");
            return false;
        }
        // چک کردن نام تکراری
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name)) {
                System.out.println("A product with name " + name + " already exists!");
                return false;
            }
        }
        Product product = new Product(name, price);
        products.add(product);
        System.out.println(name + " added to store.");
        return true;
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available!");
        } else {
            System.out.println("\n=== Available Products ===");
            for (int i = 0; i < products.size(); i++) {
                System.out.println((i + 1) + ". " + products.get(i));
            }
        }
    }

    public Product getProductByIndex(int index) {
        if (index >= 0 && index < products.size()) {
            return products.get(index);
        }
        return null;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}