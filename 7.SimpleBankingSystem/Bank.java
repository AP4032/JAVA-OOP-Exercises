import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Bank Class
class Bank {
    private String bankName;
    private List<BankAccount> accounts;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.accounts = new ArrayList<>();
    }

    public String getBankName() {
        return bankName;
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
        System.out.println("New account with number " + account.getAccountNumber() + " created successfully.");
    }

    public void removeAccount(int accountNumber) {
        accounts.removeIf(account -> account.getAccountNumber() == accountNumber);
        System.out.println("Account with number " + accountNumber + " removed successfully.");
    }

    public BankAccount findAccount(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public void displayAllAccounts() {
        System.out.println("List of accounts for " + bankName + ":");
        for (BankAccount account : accounts) {
            account.displayAccountInfo();
            System.out.println("-----");
        }
    }
}
