package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.Main.validInpute;

public class Resturant {
    private List <Order> orders = new ArrayList<Order>();
    private List <Customer> customers = new ArrayList<Customer>();
    Scanner input = new Scanner(System.in);
    public void addCustomerToOrder(Customer customer, Order order, int choice){
        if(Customer.getCustomers().isEmpty()){
            System.out.println("There are no customers in the system");
        }
        if(order.getMenuItems().isEmpty()){
            System.out.println("There are no items in the system");
        }
        System.out.println("select a customer first");
        for (int i = 0 ; i < customer.getCustomers().size(); i++){
            System.out.println(1+i + ". " + customer.getCustomers().get(i).getName());
        }
        int customerIndex = validInpute(input,customer.getCustomers().size(), 1)-1;
        if(customerIndex < 0 || customerIndex>= customer.getCustomers().size()){
            System.out.println("Customer index out of bounds");
        }
        Customer selectedCustomer = customer.getCustomers().get(customerIndex);
        System.out.println("Select an item ");
        order.displayMenu();
        if(order.getMenuItems().isEmpty()){
            return;
        }

        int itemIndex = validInpute(input,order.getMenuItems().size(),1)-1;
        if (itemIndex<0 || itemIndex>= order.getMenuItems().size()){
            System.out.println("Item index out of bounds");
        }
        MenuItem selectedItem = order.getMenuItems().get(itemIndex);
        if (selectedCustomer.getMoney() < selectedItem.getPrice()){
            System.out.println("You do not have enough money to order");
            return;

        }
        if (selectedItem.getQuantity() == 0 ){
            System.out.println("Out of stock ");
return;
        }


        selectedItem.kamQuantity(1);
        selectedCustomer.kamMoney(selectedItem.getPrice());
        selectedItem.setCustomer(selectedCustomer);
        System.out.println("Customer " + selectedCustomer.getName() + " successfully ordered " + selectedItem.getNamee());
        System.out.println("Remaining money: $" + selectedCustomer.getMoney());
        System.out.println("Remaining quantity of " + selectedItem.getNamee() + ": " + selectedItem.getQuantity());



    }

    public List <Order> getOrders() {
        return this.orders;
    }
    public List <Customer> getCustomers() {
        return this.customers;
    }


}
