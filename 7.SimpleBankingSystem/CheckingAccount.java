public class CheckingAccount extends BankAccount {
    public CheckingAccount(int accountNumber){
        super(accountNumber);
    }
    @Override
    public void checkBalance() {
        super.checkBalance();
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
    }
}
