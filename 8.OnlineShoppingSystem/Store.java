import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Store {
    private List<Product> products;
    private List<Customer> customers;
    private int nextProductId = 1;
    private int nextCustomerId = 1;

    public Store() {
        this.products = new ArrayList<>();
        this.customers = new ArrayList<>();
        initializeSampleData();
    }

    private void initializeSampleData() {
        addProduct(new Product(nextProductId++, "لپتاپ ایسوس", "لپتاپ گیمینگ 16GB RAM", 35000000, 10, "الکترونیک"));
        addProduct(new Product(nextProductId++, "گوشی سامسونگ", "گوشی هوشمند 128GB", 15000000, 20, "الکترونیک"));
        addProduct(new Product(nextProductId++, "کتاب جاوا", "آموزش برنامه‌نویسی جاوا", 500000, 50, "کتاب"));

        registerCustomer(new Customer(nextCustomerId++, "علی محمدی", "ali@example.com", "تهران"));
    }

    public boolean addProduct(Product product) {
        if (product != null && !products.contains(product)) {
            products.add(product);
            return true;
        }
        return false;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public Optional<Product> findProductById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }

    public boolean registerCustomer(Customer customer) {
        if (customer != null && !customers.contains(customer)) {
            customers.add(customer);
            return true;
        }
        return false;
    }

    public List<Customer> getCustomers() {
        return new ArrayList<>(customers);
    }

    public Optional<Customer> findCustomerById(int id) {
        return customers.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }

    public int getNextCustomerId() {
        return nextCustomerId;
    }
}