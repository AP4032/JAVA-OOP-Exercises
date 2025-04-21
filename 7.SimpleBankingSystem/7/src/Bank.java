import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String bankName;
    private List<Customer> customers;
    private List<Transaction> transactions;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("New customer added: " + customer.getName());
    }

    public Customer getCustomer(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void displayBankInfo() {
        System.out.println("\nBank Name: " + bankName);
        System.out.println("Total Customers: " + customers.size());
        System.out.println("Total Transactions: " + transactions.size());
    }

    public String getBankName() {
        return bankName;
    }
}