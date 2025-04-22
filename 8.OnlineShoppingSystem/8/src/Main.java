import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Store store = new Store();

        System.out.println("=== Online Shopping System ===");

        boolean running = true;
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add Product");
            System.out.println("2. Show all Products");
            System.out.println("3. Add to Cart");
            System.out.println("4. Place Order");
            System.out.println("5. Add Customer");
            System.out.println("6. Exit");


            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter product price: ");
                    double price = scanner.nextDouble();
                    Product product = new Product(name, price);
                    store.addProduct(product);

                    break;

                case 2:
                    for(Product item : store.getProducts()){
                        System.out.println(item.getName() + " " + item.getPrice());
                    }
                    break;
                case 3:

                    System.out.println("Enter your ID: ");
                    int id = scanner.nextInt();

                    for(Customer customer : store.getCustomers()){
                        if(customer.customerId == id ){
                            System.out.println("Enter product name: ");
                            Scanner sc = new Scanner(System.in);
                            String item1 = sc.nextLine();
                            for(Product item : store.getProducts()){
                                if(item.getName().equals(item1)){
                                    customer.addToCart(item);

                                }
                                else System.out.println("not found!");
                            }


                        }
                        else System.out.println("Customer does not exist.");
                    }
                    break;


                case 4:
                    System.out.println("Enter your ID: ");
                    int id2 = scanner.nextInt();
                    for(Customer customer2 : store.getCustomers()){
                        if(customer2.customerId == id2 ){
                            customer2.placeOrder();
                        }
                        else System.out.println("Customer does not exist.");
                    }
                    break;

                case 5:
                    System.out.println("Enter your name: ");
                    String name2 = scanner.nextLine();
                    Customer customerM = new Customer(name2);
                    store.addCustomer(customerM);
                    break;
                case 6:
                    running = false;

            }
        }
    }
}
