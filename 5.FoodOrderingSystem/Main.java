package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Order order = new Order();
        Resturant resturant = new Resturant();
        Customer customer = new Customer("",0);
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to FoodOrdering System");


        while (true) {
            System.out.println("\nEnter your choice\n1-Menu\n2-Add/remove Item\n3-Add/remove customers\n4-customer Order\n5-All calculation\n6-Exit");

            int choice = validInpute(input, 6, 1);

            switch (choice) {
                case 1:
                    order.displayMenu();
                    break;

                case 2:
                    addMenu(order, input);
                    break;

                case 3:
                    customerMenu(input);
                    break;

                case 4:
                    resturant.addCustomerToOrder(customer, order, choice);
break;


                case 5:
                    order.calculateOrder();
                    break;

                case 6:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void addMenu(Order order, Scanner input) {
        while (true) {
            System.out.println("1-Add food \n2-Remove food\n3-Exit");

            int choice = validInpute(input, 3, 1);

            switch (choice) {
                case 1:
                    order.addItem(input);
                    break;
                case 2:
                    order.removeItem();
                    break;
                case 3:
                    return;
            }
        }
    }

    private static void customerMenu(Scanner input) {
        Customer customer = new Customer("",0);
        while (true) {
            System.out.println("Enter your choice\n1-Add Customer\n2-Remove Customer\n3-Show Customers\n4-Exit");

            int choice = validInpute(input, 4, 1);

            switch (choice) {
                case 1:
                    customer.addCustomer();
                    break;
                case 2:
                    customer.removeCustomer();
                    break;
                case 3:
                    customer.showCustomers();
                    break;
                case 4:
                    return;
            }
        }
    }

    public static int validInpute(Scanner input, int max, int min) {
        int choice;
        while (true) {
            while (!input.hasNextInt()) {
                System.out.println("Invalid choice, please try again:");
                input.nextLine();
            }

            choice = input.nextInt();
            input.nextLine();

            if (choice >= min && choice <= max) {
                return choice;
            } else if(max==min){
                System.out.println("Invalid input try again");
            } else {
                System.out.println("Enter a number between " + min + " and " + max);
            }

        }
    }
}
