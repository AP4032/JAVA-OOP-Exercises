package org.example;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("New customer added: " + customer);
    }

    public void showAllCustomers(){
        if(customers.isEmpty()){
            System.out.println("There is nothing to see.");
            return;
        }
        int i=1;
        for(Customer customer : customers){
            System.out.println(i+".Name:"+customer.getName());
            customer.checkBalance();
            i++;
        }
    }
}