import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("New customer added: " + customer.getName());
    }

    public Customer findCustomer(String accountNumber) {
        for (Customer c : customers) {
            if (c.getAccountNumber().equals(accountNumber)) {
                return c;
            }
        }
        return null;
    }

    public void listCustomers() {
        System.out.println("Customers in the bank:");
        for (Customer c : customers) {
            System.out.println("- " + c.getName() + " (Acc#: " + c.getAccountNumber() + ")");
        }
    }
}
