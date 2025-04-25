import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> inventory;
    private List<Customer0> customer0s;

    public Store() {
        this.inventory = new ArrayList<>();
        this.customer0s = new ArrayList<>();
    }

    public void addProduct(Product product) {
        inventory.add(product);
        System.out.println(product.getName() + " added to store.");
    }

    public List<Product> getProducts() {
        return inventory;
    }
    public void addCustomer(Customer0 customer){
        customer0s.add(customer);
        System.out.println(customer.getName()+ "added to store");
    }
    public List<Customer0> getCustomer(){
        return customer0s;
    }
}