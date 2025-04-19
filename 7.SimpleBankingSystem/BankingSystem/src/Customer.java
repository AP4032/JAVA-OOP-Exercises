public class Customer {
    private String name;
    private BankAccount account;

    public Customer(String name, double initialBalance) {
        this.name = name;
        this.account = new BankAccount(initialBalance);
    }

    public String getName() {
        return name;
    }

    public BankAccount getAccount() {
        return account;
    }
}