package org.example;

public class SavingAccount extends BankAccount {
    final private double interestRate;

    public SavingAccount(int accountNumber, double interestRate) {
        super(accountNumber);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
        System.out.println("Interest applied: $" + interest);
    }
}