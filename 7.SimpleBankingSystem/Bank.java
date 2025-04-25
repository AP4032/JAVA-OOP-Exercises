import java.util.ArrayList;
import java.util.List;
public class Bank {
    private List<Customer1> customer1List;
    public Bank(){
        this.customer1List=new ArrayList<>();
    }
    public void SetCustomer(Customer1 customer){
        customer1List.add(customer);
        System.out.println("Account in the name of "+customer.getName()+" Opened");
        System.out.println("Your AccountNumber:"+customer.getAccountNumber()+" And your password:"+customer.getPassword());
    }
    public List<Customer1> getCustomerList(){
        return customer1List;
    }

}
