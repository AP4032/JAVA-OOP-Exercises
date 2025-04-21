import java.util.List;
import java.util.ArrayList;
public class Store {
    private List<Product> products;
    private Customer customer;

    public Store(){
        this.products = new ArrayList<>();
    }

    public void productRemove(Product product){
        this.products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public Customer getCustomer(){
        return customer;
    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    public void addCustomer(String name){
        customer = new Customer(name);
    }
}
