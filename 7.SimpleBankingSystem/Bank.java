import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Customer> customers;

    public Bank() {
        customers = new ArrayList<>();
    }

    public void addCustomer(String name, String accountNumber) {
        if (findCustomer(accountNumber) != null) {
            System.out.println("Account already exists.");
            return;
        }
        Customer customer = new Customer(name, accountNumber);
        customers.add(customer);
        System.out.println("Customer added successfully with ID: " + customer.getCustomerId());
    }

    public Customer findCustomer(String accountNumber) {
        for (Customer customer : customers) {
            if (customer.getAccountNumber().equals(accountNumber)) {
                return customer;
            }
        }
        return null;
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }
}