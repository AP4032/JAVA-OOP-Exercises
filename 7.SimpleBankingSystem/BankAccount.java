public abstract class BankAccount {
    protected String type;
    protected double balance;
    protected int accountNumber;

    public BankAccount(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $ " + amount);
        } else {
            System.out.println("Invalid amount!");
        }
    }
    public void withdraw(double amount){
        if(amount > 0){
            if(balance > amount){
                System.out.println("Withdrew: $" + amount);
                balance -= amount;
            }else{
                System.out.println("Insufficient funds. ");
            }
        }else{
            System.out.println("Invalid amount!");
        }
    }
    public void checkBalance(){
        System.out.println("Account number: " + accountNumber);
        System.out.println("Balance: $ " + balance);
    }
}
