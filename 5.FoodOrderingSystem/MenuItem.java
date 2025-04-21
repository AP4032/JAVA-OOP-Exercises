package org.example;

public class MenuItem {
    private String namee ;
    private double price ;
    private int quantity ;
    private Customer customer ;
    public MenuItem(String name , double price, int quantity) {
        this.namee = name;
        this.price = price;
        this.quantity = quantity;

    }
    public String getNamee(){
        return namee;
    }
    public  double getPrice(){
        return price;

    }
    public void setName(String name){
        this.namee = namee;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    public Customer getCustomer(){
        return customer;
    }
    public void kamQuantity(int amount){
        if(quantity>=amount){
            quantity -= amount;
        }
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}
