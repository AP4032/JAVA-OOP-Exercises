import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        ArrayList<Product> currentStock = store.getAvailableProducts();
        ArrayList<Customer> customers = store.getCustomers();

        boolean keepGoing = true;
        System.out.println(":::  Welcome to our OnlineShop  :::");
        while (keepGoing) {
            Scanner sc = new Scanner(System.in);
            showMenu();
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> PrintAvailableProduct(currentStock);
                case 2 -> showUserBasket(sc, customers);
                case 3 -> addProductToUserBasket(sc, currentStock, customers);
                case 4 -> addProductToStore(sc, currentStock);
                case 5 -> chargeProduct(sc, currentStock);
                case 6 -> {
                    System.out.println("Exiting ...");
                    keepGoing = false;
                }
                default -> System.out.println("Please enter an valid input :");
            }
        }
    }


    public static void showMenu() {
        System.out.println("1. List of products");
        System.out.println("2. View the user basket");
        System.out.println("3. Add product to cart");
        System.out.println("4. Add new product to store (Admin)");
        System.out.println("5. Charge a product (Admin)");
        System.out.println("6. Exit");
        System.out.print("Enter an option :");
    }

    public static void chargeProduct(Scanner sc, ArrayList<Product> currentProduct) {
        System.out.print("Enter the name of the product you wanna charge :");
        String name = sc.nextLine();

        for (Product p : currentProduct){
            if (p.getProductName().equalsIgnoreCase(name)){
                System.out.print("How much do you want to charge it ?");
                int input = sc.nextInt();
                sc.nextLine();

                p.chargeProduct(input);
            }
        }
    }

    public static void addProductToStore(Scanner sc,ArrayList<Product> inventory){
        System.out.print("Enter the name of the product you wanna add to store :");
        String productName = sc.nextLine();
        addProductToInventory(sc, inventory, productName, 10);
    }

    public static void showUserBasket(Scanner sc, ArrayList<Customer> c) {
        Customer customer = getOrCreateCustomer(sc, c);
        customer.getUserBasket().displayCartContents();
        customer.getUserBasket().calculateTotalPrice();
    }


    public static void addProductToInventory(Scanner sc ,ArrayList<Product> inventory, String name,int initialStock) {
        // Check if product with same name already exists
        for (Product p : inventory) {
            if (p.getProductName().equalsIgnoreCase(name)) {
                System.out.println("Product already exists in inventory.");
                return;
            }
        }
        System.out.print("Enter the price of the product :");
        float productPrice = sc.nextFloat();
        sc.nextLine();

        Product newProduct = new Product(name, productPrice);
        newProduct.setStockCount(initialStock); // Make sure this sets, not adds
        inventory.add(newProduct);
        System.out.println("Added new product: " + name + " | Price: " + productPrice + " | Stock: " + initialStock);
    }

    public static void addProductToUserBasket(Scanner sc, ArrayList<Product> storeList, ArrayList<Customer> c) {
        Customer customer = getOrCreateCustomer(sc, c);

        System.out.println("List of available items :");
        PrintAvailableProduct(storeList);
        System.out.print("Enter the product name you wanna add to your basket :");
        String productName = sc.nextLine();

        for (Product p : storeList){
            if (p.getProductName().equalsIgnoreCase(productName)){
                if (p.getStockCount() == 0){
                    System.out.println("This product is out of stock currently :(");
                }
                else {
                    customer.getUserBasket().addProduct(p);
                    System.out.println("Product :" + p.getProductName() + " is in your basket right now.");
                    customer.getUserBasket().displayCartContents();
                }
            }
        }
    }

    public static void PrintAvailableProduct(ArrayList<Product> list) {
        for (Product p : list) {
            if (p.getStockCount() != 0) {
                System.out.println(p.getProductName() + " | Price :" + p.getProductPrice() + " | left :" + p.getStockCount());
            }
        }
    }

    public static Customer findCustomer(ArrayList<Customer> customers, String name) {
        for (Customer c : customers) {
            if (c.getUserName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }
    public static Customer getOrCreateCustomer(Scanner sc, List<Customer> customers) {
        System.out.print("Enter your name: ");
        String inputName = sc.nextLine();

        Customer customer = findCustomer((ArrayList<Customer>) customers, inputName);
        if (customer == null) {
            customer = new Customer(inputName);
            customers.add(customer);
            System.out.println("Customer: " + customer.getUserName() +
                    " with the ID of " + customer.getId() +
                    " was added to the customers list.");
        } else {
            System.out.println("Welcome back " + customer.getUserName() + ".");
        }

        return customer;
    }

}
