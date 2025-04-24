package SimpleBanking;


public class Customer {
    private String name;
    private BankAccount account;
    private SavingAccount savingsAccount;


    public Customer(String name, String accountNumber, boolean isSavings) {
        this.name = name;
        if (isSavings) {
            this.savingsAccount = new SavingAccount(accountNumber, 2.5); // 2.5% interest rate for savings
        } else {
            this.account = new BankAccount(accountNumber);
        }
    }

    public void depositMoney(double amount) {
        if (account != null) {
            account.deposit(amount);
        } else {
            savingsAccount.deposit(amount);
        }
    }

    public void withdrawMoney(double amount) {
        if (account != null) {
            account.withdraw(amount);
        } else {
            savingsAccount.withdraw(amount);
        }
    }

    public void checkBalance() {
        if (account != null) {
            System.out.println(name + "'s balance: $" + account.getBalance());
        } else {
            System.out.println(name + "'s savings account balance: $" + savingsAccount.getBalance());
        }
    }

    public void calculateInterest() {
        if (savingsAccount != null) {
            savingsAccount.calculateInterest();
        }
    }

    public String getName() {
        return name;
    }
}
