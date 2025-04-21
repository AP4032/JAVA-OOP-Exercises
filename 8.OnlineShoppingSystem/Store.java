import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Store {
    private List<Product> inventory;
    private List<Customer> customers;

    public Store() {
        this.inventory = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Product> getInventory() {
        return inventory;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void setInventory(List<Product> inventory) {
        this.inventory = inventory;
    }

    public void browseProducts() {
        if (!inventory.isEmpty()) {
            for (Product p : inventory) {
                p.printDetails();
            }
        } else {
            System.out.println("There are no products available.");
        }
    }
    public void addProduct(Product product){
        inventory.add(product);
    }
    }
