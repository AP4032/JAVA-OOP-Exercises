package org.example;

public class OnlineBanking {
    private Bank bank;

    public OnlineBanking(Bank bank) {
        this.bank = bank;
    }
    public void checkingBalance(String customerName, String accountNumber) {
        Customer customer = bank.getCustomer(customerName);
        if (customer != null) {
            for (BankAccount account : customer.getAccounts()) {
                if (account != null && account.getAccountNumber().equals(accountNumber)) {
                    System.out.println("Balance for account " + accountNumber + ": " + account.getBalance());
                    return;
                }
            }
            System.out.println("Account not found for customer: " + customerName);
        } else {
            System.out.println("Customer not found: " + customerName);
        }
    }

}
