public class Customer {
    private String name;
    private BankAccount account;

    public Customer(String name, String accountNumber, boolean isSavingsAccount) {
        this.name = name;
        this.account = new BankAccount(accountNumber, isSavingsAccount);
    }

    // Deposit money
    public void depositMoney(double amount) {
        account.deposit(amount);
    }

    // Withdraw money
    public void withdrawMoney(double amount) {
        account.withdraw(amount);
    }

    // Check balance
    public void checkBalance() {
        System.out.println(name + "'s balance: $" + account.getBalance());
    }

    // Apply interest (if savings account)
    public void applyInterest() {
        account.applyInterest();
    }

    // Show transaction history
    public void showTransactionHistory() {
        System.out.println(name + "'s Transaction History:");
        for (String transaction : account.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }

    // Transfer money to another customer's account
    public void transferMoney(Customer recipient, double amount) {
        if (amount > 0 && amount <= account.getBalance()) {
            account.withdraw(amount);
            recipient.depositMoney(amount);
            System.out.println("Transferred: $" + amount + " to " + recipient.getName());
        } else {
            System.out.println("Insufficient balance or invalid amount for transfer.");
        }
    }

    // Get the customer's account
    public BankAccount getAccount() {
        return account;
    }

    // Get the customer's name
    public String getName() {
        return name;
    }
}
