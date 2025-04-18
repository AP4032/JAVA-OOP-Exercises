import java.util.Scanner;

public class Customer {
    private String name;
    private BankAccount account;

    public Customer(String name, int accountNumber) {
        this.name = name;
        this.account = new BankAccount(accountNumber);
    }

    public String getName() {
        return name;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void depositMoney(int amount) {

        account.deposit(amount);

    }

    public void withdrawMoney(double amount) {
        account.withdraw(amount);
    }

    public void checkBalance() {
        System.out.println(name + "'s balance: $" + account.getBalance());
}
    }