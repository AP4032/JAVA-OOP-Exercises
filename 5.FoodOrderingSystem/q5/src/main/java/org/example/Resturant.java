package org.example;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Resturant {
    ArrayList<Order> orders;
    ArrayList<MenuItems> menu;
    Scanner scInt = new Scanner(System.in);
    Scanner scString = new Scanner(System.in);

    public  Resturant(){
        this.orders = new ArrayList<>();
        this.menu = new ArrayList<>();
        menu.add(new MenuItems("Pizza", 20));
        menu.add(new MenuItems("Pasta", 25));
        menu.add(new MenuItems("Burger", 15));
        menu.add(new MenuItems("French fries", 10));
        menu.add(new MenuItems("Sandwich", 18));
    }

    public void start(){
        System.out.print("Enter your name: ");
        String name = scString.nextLine();
        System.out.print("Enter your address: ");
        String address = scString.nextLine();
        Customer customer = new Customer(name,address);
        System.out.println("1.place an new order\n2.see current orders\n3.pay\n4.deliver\n5.exit");
        System.out.print("choose: ");
        int choice = input();
        scInt.nextLine();
        while(true) {
            switch (choice) {
                case 1:
                    takeOrder();
                    break;
                case 2:
                    showAllOrders();
                    break;
                case 3:
                    pay();
                    break;
                case 4:
                    deliver(customer);
                    break;
                case 5:
                    System.out.println("Goodbye.");
                    return;
                default:
                    System.out.println("invalid input!");
            }
            System.out.println("1.place an new order\n2.see current orders\n3.pay\n4.deliver\n5.exit");
            System.out.print("choose: ");
            choice = input();
            scInt.nextLine();
        }
    }

    private void takeOrder() {
        Order order = new Order();

        System.out.println("status: "+order.getStatus());

        System.out.println("new order:");

        while (true) {
            showMenu();

            int itemChoice = scInt.nextInt();
            scInt.nextLine();

            if (itemChoice == 6) {
                orders.add(order);
                System.out.println("ok done!\ntotal:" + order.totalPrice() + "$");
                break;
            }

            MenuItems item;
            switch (itemChoice) {
                case 1:
                    item = new MenuItems("Pizza", 20);
                    break;
                case 2:
                    item = new MenuItems("Pasta", 25);
                    break;
                case 3:
                    item = new MenuItems("Burger", 15);
                    break;
                case 4:
                    item = new MenuItems("French fries", 10);
                    break;
                case 5:
                    item = new MenuItems("Sandwich", 18);
                    break;
                default:
                    System.out.println("Invalid input!");
                    continue;
            }

            order.addItem(item);
            System.out.println(item.getName() + " added!");
            updateOrderStatus(order,"in progress.");
        }
        updateOrderStatus(order,"order placed.");
    }

    public void showAllOrders(){
        if(orders.isEmpty()){
            System.out.println("there is nothing to see!");
            return;
        }
        int i=1;
        for(Order order : orders){
            System.out.print(i+". items:");
            order.showItems();
            System.out.println(" price: "+ order.totalPrice());
            i++;
        }
    }

    public void updateOrderStatus(Order order, String status) {
        order.updateStatus(status);
        System.out.println("Order status updated to: " + status);
    }

    public void showMenu() {
        int i=1;
        for(MenuItems item : menu){
            System.out.println(i+". name: "+item.getName()+" price: "+ item.getPrice() + "$");
            i++;
        }
        System.out.println("6.Done");
        System.out.print("choose: ");
    }

    public void pay(){
        if(orders.isEmpty()){
            System.out.println("You have to place at least one order!");
            return;
        }
        showAllOrders();
        System.out.print("choose: ");
        int ch1 = input();
        ch1--;
        while(ch1<0 || ch1> orders.size()){
            System.out.println("invalid input!");
            ch1 = scInt.nextInt();
            ch1--;
        }
        System.out.print("you have to pay "+orders.get(ch1).totalPrice()+"$\nto pay enter 1:");
        int ch2 = input();
        while(ch2!=1){
            System.out.println("you have to pay first!");
            ch2 = scInt.nextInt();
        }
        updateOrderStatus(orders.get(ch1),"payed");
    }

    public void deliver(Customer customer){
        if(orders.isEmpty()){
            System.out.println("You have to place at least one order!");
            return;
        }
        showAllOrders();
        int ch = input();
        ch--;
        while(ch<0 || ch> orders.size()){
            System.out.println("invalid input!");
            ch = input();
            ch--;
        }
        if(Objects.equals(orders.get(ch).getStatus(), "payed")){
            updateOrderStatus(orders.get(ch),"delivering to " + customer.getAddress());
            updateOrderStatus(orders.get(ch),"delivered to " + customer.getName());
        }else{
            System.out.println("you have to pay first!");
        }
    }

    public int input(){
        int ch;
        while(!scInt.hasNextInt()){
            System.out.println("invalid input!");
            scInt.next();
            System.out.print("choose again: ");
        }
        ch = scInt.nextInt();
        return ch;
    }
}
