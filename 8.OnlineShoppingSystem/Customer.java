package Online_Shopping_System;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Customer
{
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    private String name;

    public String getName() {
        return name;
    }
    public Customer(String name){
        this.name = name;
    }

    public void addProducts(Product p , int n){
        products.add(p);
        numbers.add(n);
    }
    public void bill(){
        System.out.println("your bill:");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(i+ "." + " " + products.get(i).getName()+ " number: "+ numbers.get(i) + " price: " + products.get(i).getSell_price()*numbers.get(i) +
                    products.get(i).getNumber_inventory() + " ");
        }
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    }
}

