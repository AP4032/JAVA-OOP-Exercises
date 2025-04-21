import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    public HashMap<String,Customer> customers;

    public Bank (){
        this.customers = new HashMap<>();
    }

    public void add(Customer customer){
        customers.put(customer.name, customer);
        System.out.println("the customer added");
    }

    public boolean checkCustomer(String name,int password){
       if(customers.containsKey(name) &&  password==customers.get(name).password){
           return true;
       }
       else return false;
    }
}
