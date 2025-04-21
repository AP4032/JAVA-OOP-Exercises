package org.example;

public class SavingAccount extends BankAccount{
    private double interestRate;

    public SavingAccount(String accountNumber, double interestRate) {
        super(accountNumber);
        this.interestRate = interestRate;
    }

    public void calculateInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
        System.out.println("Interest of $" + interest + " has been added to your savings account.");
    }
}
