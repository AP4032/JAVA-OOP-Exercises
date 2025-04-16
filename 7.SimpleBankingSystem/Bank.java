package Simple_Banking_System;

import java.util.ArrayList;

public class Bank
{
    ArrayList<BankAccount> Accounts = new ArrayList<>();

    public void addAccount(BankAccount newOne)
    {
        Accounts.add(newOne);
    }

    public void exchanging(BankAccount from , BankAccount to , double Money)
    {
        if(from.withdrawalCheck(Money) == true)
        {
            from.withdrawal(Money);
            to.deposit(Money);
            System.out.println(Money + " dollars has been transferd from " + from.getName() + " to " + to.getName());
        }
        else
        {
            from.withdrawal(Money);
        }
    }
}
