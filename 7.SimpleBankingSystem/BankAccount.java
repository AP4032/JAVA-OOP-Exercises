public class BankAccount {
    private String accountNumber;
    private double balance;
    private int password;

    public BankAccount(String accountNumber,int password) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.password = password;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
            System.out.println("Your balance is: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
            System.out.println("Your balance is: $" + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getPassword() {
        return password;
    }
}