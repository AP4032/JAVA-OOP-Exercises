package org.example;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private List<String> transactionHistory;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Initial balance: " + balance);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
        } else {
            balance += amount;
            transactionHistory.add("Deposited:" + amount + " New Balance:" + balance);
            System.out.println("Deposited " + amount + " into account " + accountNumber);
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than 0.");
        } else if (balance >= amount) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount + " New Balance: " + balance);
            System.out.println("Withdrew " + amount + " from account " + accountNumber);
        } else {
            transactionHistory.add("Failed to withdraw" + amount + "  Insufficient funds.");
            System.out.println("Insufficient balance in account " + accountNumber);
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }
}
