public class Customer {
    private static int idCounter = 1;
    private int customerId;
    private String name;
    private BankAccount account;

    public Customer(String name, String accountNumber) {
        this.name = name;
        this.account = new BankAccount(accountNumber);
        this.customerId = idCounter++;
    }

    public String getName() {
        return name;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getAccountNumber() {
        return account.getAccountNumber();
    }

    public void deposit(double amount) {
        account.deposit(amount);
    }

    public void withdraw(double amount) {
        account.withdraw(amount);
    }

    public void checkBalance() {
        account.printBalance();
    }
}