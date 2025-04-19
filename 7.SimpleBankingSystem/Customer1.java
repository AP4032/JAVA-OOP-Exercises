

public class Customer1 {
    private BankAccount Account;
    private String name;
    private int password;
    public Customer1 (String string,int password){
     this.password=password;
     this.Account=new BankAccount();
     this.name=string;
    }

    public void setPassword(int password) {
        this.password = password;
        System.out.println("Change made.Your new password:"+getPassword());
    }
    public int getPassword(){
        return password;
    }

    public String getName(){
        return name;
    }
    public int getAccountNumber(){
        return Account.getAccountNumber();
    }
    public void setInventory(double Money){
        this.Account.setInventory(Money);
    }
    public Double getInventory(){
        return Account.getInventory();
    }
    public void DepositMoney(double add){
        this.Account.DepositMoney(add);
    }
    public void Harvest(double add){
        this.Account.Harvest(add);
    }
    public void Deposit(){
        Account.Deposit();
    }

}
