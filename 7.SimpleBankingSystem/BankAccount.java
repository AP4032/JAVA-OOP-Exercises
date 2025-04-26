import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private List<String> transactionHistory;
    private double interestRate;  // Interest rate for savings accounts
    private boolean isSavingsAccount;

    public BankAccount(String accountNumber, boolean isSavingsAccount) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
        this.isSavingsAccount = isSavingsAccount;
        this.interestRate = isSavingsAccount ? 0.03 : 0.0;  // Example: 3% interest for savings
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: $" + amount);
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: $" + amount);
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Apply interest for savings accounts
    public void applyInterest() {
        if (isSavingsAccount) {
            double interest = balance * interestRate;
            balance += interest;
            transactionHistory.add("Interest applied: $" + interest);
            System.out.println("Interest applied: $" + interest);
        }
    }

    // Get balance method
    public double getBalance() {
        return balance;
    }

    // Get transaction history
    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    // Get account type
    public boolean isSavingsAccount() {
        return isSavingsAccount;
    }
}
