package org.example;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    final private int accountNumber;
    private double balance;
    final private List<String> transactions; // history

    public BankAccount(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            String log = "Deposited: $" + amount;
            transactions.add(log);
            System.out.println(log);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            String log = "Withdrew: $" + amount;
            transactions.add(log);
            System.out.println(log);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void printTransactionHistory() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }
        System.out.println("Transaction History:");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }
}