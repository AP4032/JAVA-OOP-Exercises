import java.util.Random;

public class Customer {
    private String name;
    private BankAccount account;

    public Customer(String name, String accountNumber, int password) {
        this.name = name;
        this.account = new BankAccount(accountNumber, password);
    }

    public void depositMoney(double amount) {
        account.deposit(amount);
    }

    public void withdrawMoney(double amount) {
        account.withdraw(amount);
    }

    public void checkBalance() {
        System.out.println(name + "'s balance: $" + account.getBalance());
    }

    public String getName() {
        return name;
    }

    public BankAccount getAccount() {
        return account;
    }
}