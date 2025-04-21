package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    private  List <MenuItem> menuItems = new ArrayList<>();
    public void addItem(Scanner input){
        System.out.println("how many items do you want to add?");

       int items = Main.validInpute(input,100,1);

        for(int i = 0; i < items; i++) {
            System.out.println("Enter name of food " + (i + 1) + " : ");

            String name = input.next();
            System.out.println("Enter " + (i + 1) + " food price");
            int price = input.nextInt();
            System.out.println("Enter quantity of food " + (i + 1) + " : ");
            int quantity = input.nextInt();
            MenuItem menuItem = new MenuItem(name, price, quantity);
            menuItems.add(menuItem);


        }
    }
    public void removeItem(){
        if(menuItems.isEmpty()){
            System.out.println("No items in menu to remove");
            return;
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the index of the item you want to remove");
        displayMenu();
        int items = input.nextInt()-1;


        menuItems.remove(items);
        System.out.println("Item removed successfully");
    }
    public void displayMenu(){
        if(menuItems.isEmpty()){
            System.out.println("There are no items in the menu");
            return;
        }

        for(int i = 0 ; i < menuItems.size(); ++i  ){
            System.out.println(i+1 + ".food = " + menuItems.get(i).getNamee() + " price : " + menuItems.get(i).getPrice() + " quantity : " + menuItems.get(i).getQuantity() );
        }
    }
    public void calculateOrder(){
        int total = 0;
        for (int i = 0; i < menuItems.size(); ++i){
            total +=  menuItems.get(i).getPrice();
            System.out.println("food :" + menuItems.get(i).getNamee()+"  "+menuItems.get(i).getPrice());

        }
        if (total == 0){
            System.out.println("No items in menu to calculate order");
        }else {


            System.out.println("Total price is : "+ total );
        }

    }
    public List <MenuItem> getMenuItems(){
        return menuItems;
    }

}
