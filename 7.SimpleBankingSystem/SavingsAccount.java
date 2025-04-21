public class SavingsAccount extends BankAccount{

    public SavingsAccount(int accountNumber){
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
    public double interest(){
        double interestRate=0.05;
        balance = balance + (balance*interestRate);
        System.out.println(" 5% interest added to balance! ");
        return balance;
    }
}
