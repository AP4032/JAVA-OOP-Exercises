package MyJava7;


public class Customer {
    private final String name;
    private final BankAccount account;

    public Customer(String name) {
        this.name = name;
        this.account = new BankAccount();
    }

    public String getName() {
        return name;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void showSummary() {
        System.out.println("Customer: " + name);
        System.out.println(account.getAccountInfo());
    }
}