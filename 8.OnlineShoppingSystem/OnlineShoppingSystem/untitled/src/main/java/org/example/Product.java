package org.example;
public class Product {
    private  static int IdCounter=1;
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.id=IdCounter++;
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean IsOutOfStock() {
        return quantity<=0;
    }

    public boolean ReduceQuantity(int amount) {
        if (amount>quantity) {
            System.out.println("Not enough stock for " + name);
            return false;
        }
        quantity -= amount;
        return true;
    }

    public void printInfo(){
        System.out.println("ID"+ id+"| name:"+name+"| price:"+price+"| Stock:"+quantity);
    }
}


