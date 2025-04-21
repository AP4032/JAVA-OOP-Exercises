public class BankAccount {
    public double balance;


    public BankAccount(double balance) {
        this.balance =balance;
    }

    public void bardasht(double number){
        if(number>0 && balance-number >= 0){
            balance -= number;
            System.out.println("success task!");
        }
        else
            System.out.println("you dont have enough money to get");
    }


    public void variz(double number){
        if(number>0){
            balance+=number;
        }
        else
            System.out.println(" you did not enter positive number");
    }

}
