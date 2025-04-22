import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> inventory;
    private List<Customer> customers;

    public Store() {
        this.inventory = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void addProduct(Product product) {
        inventory.add(product);
        System.out.println(product.getName() + " added to store.");
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Done!");
    }

    public List<Product> getProducts() {
        return inventory;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}