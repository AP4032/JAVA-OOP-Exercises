package MyJava7;

import java.util.HashMap;
import java.util.Map;


public class Bank {
    private final Map<String, Customer> customers;

    public Bank() {
        this.customers = new HashMap<>();
    }

    public void registerCustomer(String name) {
        Customer newCustomer = new Customer(name);
        customers.put(newCustomer.getAccount().getAccountNumber(), newCustomer);
        System.out.println("Customer " + name + " registered with Account Number: " + newCustomer.getAccount().getAccountNumber());
    }

    public Customer getCustomerByAccount(String accountNumber) {
        return customers.get(accountNumber);
    }

    public void displayAllCustomers() {
        System.out.println("=== Customer List ===");
        for (Customer customer : customers.values()) {
            customer.showSummary();
            System.out.println("---------------------");
        }
    }
}
