import java.util.Map;

public class Customer {
    public String name;
    public  BankAccount accunt;
    public double balance;
    public int password;


    public Customer(String name,int password,double balance) {
        this.name = name;
        this.accunt =new BankAccount(balance);
        this.balance = balance;
        this.password = password;

    }


public void getballance(double balance) {
        accunt.balance=balance;
}

public double showballance() {
    return accunt.balance;
}

public void bardasht(double number){
        accunt.bardasht(number);
}

public void variz(double number){
        accunt.variz(number);
    System.out.println("end task...");
}



}
