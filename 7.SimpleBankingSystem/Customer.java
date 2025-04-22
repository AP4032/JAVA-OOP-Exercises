public class Customer {
    private String name;
    private BankAccount account;
    private int accountNumber;

    public Customer(String name, int accountNumber) {
        this.name = name;
        this.account = new BankAccount(accountNumber);
        this.accountNumber = accountNumber;
    }
    public String getName() {
        return name;
    }
    public int getAccountNumber() {
        return accountNumber;
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
    public void applyInterest() {
      double v =  account.getBalance() * 0.01;
      account.deposit(v);


    }

}
