import java.util.HashMap;
import java.util.Map;

public class Authentication {
    private Map<String, Customer> customers;

    public Authentication() {
        this.customers = new HashMap<>();
    }

    public void registerCustomer(Customer customer) {
        customers.put(customer.getEmail(), customer);
        System.out.println("Registration successful for " + customer.getName());
    }

    public Customer login(String email, String password) {
        Customer customer = customers.get(email);
        if (customer != null && customer.authenticate(password)) {
            System.out.println("Login successful. Welcome " + customer.getName() + "!");
            return customer;
        }
        System.out.println("Invalid email or password.");
        return null;
    }
}