package MyJava7;

import java.util.ArrayList;
import java.util.List;


public class BankAccount {
    private static int accountCounter = 1000;
    private final String accountNumber;
    private double balance;
    private final List<String> transactionHistory;

    public BankAccount() {
        this.accountNumber = "AC" + accountCounter++;
        this.balance = 0;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance $0.0");
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) return false;
        balance += amount;
        transactionHistory.add("Deposited: $" + amount);
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) return false;
        balance -= amount;
        transactionHistory.add("Withdrew: $" + amount);
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountInfo() {
        return "Account: " + accountNumber + " | Balance: $" + balance;
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History for " + accountNumber + ":");
        for (String log : transactionHistory) {
            System.out.println(" - " + log);
        }
    }
}
