public class Customer {
    private String name;
    private static long Cid = 100000;
    private long accountNumber;
    private BankAccount account;

    public Customer(String name) {
        this.name = name;
        this.accountNumber = Cid++;
        this.account = new BankAccount();
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

    public double getBalance() {
        return account.getBalance();
    }

    public String getName() {
        return name;
    }

    public long getAccountNumber() {
        return accountNumber;
    }
}