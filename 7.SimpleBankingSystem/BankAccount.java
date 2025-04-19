import java.util.Random;

public class BankAccount {
     private double Inventory;
     private int AccountNumber=60370000;
     public BankAccount(){
     this.Inventory=0.0;
         Random rand =new Random();
         for(int a =1;a<=1000;a*=10 ){
             this.AccountNumber=this.AccountNumber+(a*(rand.nextInt(9)));
         }
     }


    public int getAccountNumber(){
        return AccountNumber;
    }


    public void setInventory(double Money){
         this.Inventory=Money;
    }


    public double getInventory(){
         return Inventory;
    }


    public void Deposit(){
         System.out.println("Your profit in the last 30 days: $"+(2/this.Inventory)*100);
         this.Inventory+=((double) 2 /100)*this.Inventory;
        System.out.println("In total: $"+this.Inventory);
    }

    public void Harvest(double Reduce){
         if(Reduce<=Inventory) {
             this.Inventory -= Reduce;
             System.out.println("Harvest: $"+Reduce);
             System.out.println("Remainder: $"+Inventory);
         }else System.out.println("Not Enough Inventory.");
    }
    public void DepositMoney(double add){
          this.Inventory+=add;
        System.out.println("DepositMoney:"+add);
        System.out.println("Total:"+Inventory);
    }



}
