package org.example;

public class Customer {
    private String name;
    private BankAccount[] accounts;
    private int count;
    public Customer(String name) {
        this.name = name;
        this.accounts = new BankAccount[10];
        this.count = 0;
    }
    public String getName() {
        return name;
    }
    public void addAccount(BankAccount account) {
        if(count<accounts.length) {
            accounts[count]=account;
            count++;
            System.out.println(account.getAccountNumber()+"added to the accounts list ");
        }
        else{
            System.out.println("we cant add more accounts");
        }
    }
    public BankAccount[] getAccounts() {
        return accounts;
    }

}
