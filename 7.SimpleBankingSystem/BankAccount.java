import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// BankAccount Class
class BankAccount {
    private int accountNumber;
    private double balance;
    private Customer customer;

    public BankAccount(int accountNumber, double balance, Customer customer) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit of " + amount + " to account " + accountNumber + " successful. New balance: " + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal of " + amount + " from account " + accountNumber + " successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        customer.displayCustomerInfo();
    }
}
