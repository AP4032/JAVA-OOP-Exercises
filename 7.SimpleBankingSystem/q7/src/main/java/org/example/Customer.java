package org.example;
public class Customer {
    private String name;
    private BankAccount account;

    public Customer(String name, int accountNumber, boolean isSaving) {
        this.name = name;
        if (isSaving) {
            this.account = new SavingAccount(accountNumber, 0.10);
        } else {
            this.account = new BankAccount(accountNumber);
        }
    }

    public String getName(){
        return name;
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

    public void showTransactionHistory() {
        account.printTransactionHistory();
    }

    public void applyInterestIfSaving() {
        if (account instanceof SavingAccount) {
            ((SavingAccount) account).applyInterest();
        } else {
            System.out.println("This is not a saving account.");
        }
    }
}