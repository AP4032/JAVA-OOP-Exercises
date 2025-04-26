import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
    }

    // Add customer to the bank
    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("New customer added: " + customer.getName());
    }

    // Show all customers in the bank
    public void showCustomers() {
        System.out.println("All customers in the bank:");
        for (Customer customer : customers) {
            System.out.println(customer.getName());
        }
    }

    // Get a customer by name
    public Customer getCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }
}
