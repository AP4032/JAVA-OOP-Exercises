import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String customerId;
    private String password;
    private List<BankAccount> accounts;

    public Customer(String name, String customerId, String password) {
        this.name = name;
        this.customerId = customerId;
        this.password = password;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
        System.out.println("New account added: " + account.getAccountNumber());
    }

    public BankAccount getAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void displayAllAccounts() {
        System.out.println("\nAccounts for " + name + ":");
        for (BankAccount account : accounts) {
            account.displayAccountInfo();
            System.out.println("-------------------");
        }
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }
}