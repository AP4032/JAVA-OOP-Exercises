package SimpleBankSystem;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
         outer : while(true)
        {
            System.out.println("*****************************");
            System.out.println("1. add Account");
            System.out.println("2. Money Transfer");
            System.out.println("3. deposit");
            System.out.println("4. withdrawal");
            System.out.println("5. show info");
            System.out.println("*****************************");
            int choose = sc.nextInt();
            Scanner input = new Scanner(System.in);
            switch (choose)
            {
                case 1:
                    System.out.print("Enter the name: ");
                    String name = input.nextLine();
                    System.out.print("Enter the Money: ");
                    double Money = input.nextDouble();
                    BankAccount NEW = new BankAccount(name , Money);
                    bank.addAccount(NEW);
                    break;
                case 2:
                    System.out.print("Money depositor: ");
                    int account_number1 = input.nextInt();
                    System.out.print("Money recipient: ");
                    int account_number2 = input.nextInt();
                    System.out.print("Money: ");
                    double pool = input.nextDouble();
                    bank.exchanging(bank.Accounts.get(account_number1) , bank.Accounts.get(account_number2) , pool);
                    break;
                case 3:
                    System.out.print("Money depositor: ");
                    int account = input.nextInt();
                    System.out.print("Money: ");
                    double MoneY = input.nextDouble();
                    bank.Accounts.get(account).deposit(MoneY);
                    break;
                case 4:
                    System.out.print("Account number: ");
                    int Account = input.nextInt();
                    System.out.println("Money: ");
                    double Pool = input.nextDouble();
                    bank.Accounts.get(Account).deposit(Pool);
                    break;
                case 5:
                    System.out.print("Account number: ");
                    int Acc = input.nextInt();
                    System.out.println(bank.Accounts.get(Acc).getName() + "     money: " + bank.Accounts.get(Acc).getMoney());
                default:
                    break outer;
            }
        }
    }
}
