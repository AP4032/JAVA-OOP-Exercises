package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class Customer {
    private String name;
    private double money;
    public Customer(String name, double money) {
        this.name = name;
        this.money = money;
    }
    private static List<Customer> customers = new ArrayList<Customer>();
    public void addCustomer(){
        System.out.println("Enter the name of the customer : ");
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
        System.out.println("Enter the money : ");
        money = sc.nextDouble();
        Customer customer = new Customer (name,money);
        customers.add(customer);
    }
    public void showCustomers() {
        if(customers.isEmpty()){
            System.out.println("No customer found");
        }
        for(int i = 0 ;i < customers.size() ; ++i){
            System.out.println(i+1 + ". "+ customers.get(i).getName() + "  " + customers.get(i).getMoney()+"$");
        }
    }
    public String getName(){
        return name;
    }
    public void removeCustomer(){
        if(customers.isEmpty()){
            System.out.println("No customer found");
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the index of customer you want to remove : ");
        showCustomers();
        int index = sc.nextInt()-1;
        customers.remove(index);
        System.out.println("Customer removed successfully");


        }
        public  static List<Customer> getCustomers(){
        return customers;
        }
        public double getMoney(){
        return money;
        }
        public void kamMoney(double amount){
        if(money>=amount){
            money -= amount;
        }
        }
    }


