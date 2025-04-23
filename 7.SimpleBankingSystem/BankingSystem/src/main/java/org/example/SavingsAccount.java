package org.example;

public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
    public void applyingInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
        System.out.println("Interest of " + interest + " applied to account " + getAccountNumber());
    }
}
