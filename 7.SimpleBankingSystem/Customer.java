public class Customer
{
    public String name;
    public BankAccount account;

    public Customer(String name, String accountNumber)
    {
        this.name = name;
        this.account = new BankAccount(accountNumber);
    }
    public void depositMoney(double amount)
    {
        account.deposit(amount);
    }
    public void withdrawMoney(double amount)
    {
        account.withdraw(amount);
    }
    public void checkBalance()
    {
        System.out.println(name + "'s balance: $" + account.getBalance());
    }
    public String getName()
    {
        return name;
    }
    public String getAccountNumber()
    {
        return account.getAccountNumber();
    }
}