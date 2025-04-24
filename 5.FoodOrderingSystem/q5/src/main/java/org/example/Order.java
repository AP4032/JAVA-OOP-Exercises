package org.example;

import java.util.ArrayList;

public class Order {
    ArrayList<MenuItems> items;
    String status;
    public Order(){
        this.items = new ArrayList<>();
        this.status = "Pending";
    }
    public int totalPrice(){
        int total = 0;
        for(MenuItems item : items){
            total += item.getPrice();
        }
        return total;
    }
    public void showItems(){
        for(MenuItems item:items){
            System.out.print(item.getName());
            if(item!=items.getLast()){
                System.out.print(", ");
            }
        }
    }
    public void addItem(MenuItems item){
        items.add(item);
    }
    public void updateStatus(String status){
        this.status = status;
    }
    public String getStatus(){ return status; }
}
