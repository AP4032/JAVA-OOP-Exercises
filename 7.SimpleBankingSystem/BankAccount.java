package SimpleBankSystem;

public class BankAccount
{
    private String name;
    private double money;

    public BankAccount(String name , double money)
    {
        this.name = name;
        this.money = money;
    }
    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public void deposit(double mon)
    {
        money += mon;
    }
    public void withdrawal(double mon)
    {
        if(!withdrawalCheck(mon))
        {
            System.out.println("the customer doesn't have that much!");
        }
        else
        {
            money -= mon;
            System.out.println("Rmeining Money = " + money);
        }
    }
    public boolean withdrawalCheck(double mon)
    {
        if(mon > money)
        {
            return false;
        }
        else
        {
            return true;
        }
    }


}
