package Online_Shopping_System;

import java.util.ArrayList;

public class Shopkeeper
{
    ArrayList<Product> stors_products = new ArrayList<>();

    public void addPriducts(Product p){
        stors_products.add(p);
    }
    public void show_info(){
        for (int i = 0; i < stors_products.size(); i++) {
            System.out.println(i+ "." + " " + stors_products.get(i).getName() + " price: " + stors_products.get(i).getSell_price() + " discount: " +
                               stors_products.get(i).getTakhfif() + " price before discount: " + stors_products.get(i).getPrice() + " numbers in inventory: " +
                               stors_products.get(i).getNumber_inventory() + " ");
        }
    }
}
