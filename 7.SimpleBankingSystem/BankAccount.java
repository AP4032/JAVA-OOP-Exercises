public class BankAccount {
    String Red = "\033[31m";
    String Green = "\033[32m";
    String Reset = "\033[0m";
    private final int IDcard;
    private double Balance;

    public BankAccount(int IDcard) {
        this.IDcard = IDcard;
        Balance = 0.0;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double Balance) {
        this.Balance = Balance;
    }

    public int getIDcard() {
        return IDcard;
    }

    public void Withdrawal(double Amount) {
        if (Balance >= Amount) {
            Balance -= Amount;
            System.out.println(Green + "Withdrawal was successful" + Reset);
            System.out.println(Green + "Balance: " + Balance + "$" + Reset);
        } else {
            System.out.println(Red + "The amount entered is greater than the balance limit" + Reset);
        }

    }

    public void Deposit(double Amount) {
        Balance += Amount;
        System.out.println(Green + "Deposit was successful" + Reset);
        System.out.println(Green + "Balance: " + Balance + "$" + Reset);
    }
}
