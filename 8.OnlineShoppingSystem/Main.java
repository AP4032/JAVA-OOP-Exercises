package Online_Shopping_System;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Shopkeeper shopkeeper = new Shopkeeper();

        while (true){
            out:while(true)
            {
            Scanner in = new Scanner(System.in);
            System.out.println("shopkeeper fill the store! 1-add products   2-end of adding products");
            int choose = in.nextInt();
            Scanner sc = new Scanner(System.in);
            switch (choose) {
                case 1:
                    System.out.print("Enter the name of product: ");
                    String p_name = sc.nextLine();
                    System.out.print("Enter the price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter the discount: ");
                    double discount = sc.nextDouble();
                    System.out.print("Enter number of the product: ");
                    int n = sc.nextInt();
                    Product product = new Product(p_name, price, discount, n);
                    shopkeeper.addPriducts(product);
                    break;
                case 2:
                    break out;
            }
            }
            while (true){
                Scanner scan = new Scanner(System.in);
                int payable_money =0;
                System.out.println("Customer! Enter your name: ");
                String name= scan.nextLine();
                Customer customer = new Customer(name);
                shopkeeper.show_info();
                while(true){
                    Scanner input = new Scanner(System.in);
                    System.out.println("which product do you want: ");
                    int choice = scan.nextInt();
                    System.out.println("che tedad mikhahid? ");
                    int n = input.nextInt();
                    if(shopkeeper.stors_products.get(choice).getNumber_inventory() >= n)
                    {
                        shopkeeper.stors_products.get(choice).change_number(n);
                        customer.addProducts(shopkeeper.stors_products.get(choice) , n);
                        payable_money += n * shopkeeper.stors_products.get(choice).getSell_price();
                    }
                    else{
                        System.out.println("mojoodie kala kafi nist!");
                    }
                    System.out.println("do you want to keep going? 1.yes  2.no ");
                    int edame_dadan = scan.nextInt();
                    if (edame_dadan==2)
                    {
                        customer.bill();
                        System.out.println("payable price: " + payable_money);
                        break;
                    }
                }

            }

        }
    }
}
