import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Scanner scanner = new Scanner(System.in);

//        Product laptop = new Product("Laptop", 999.99);
//        Product phone = new Product("Smartphone", 499.99);
//        store.addProduct(laptop);
//        store.addProduct(phone);
//        Customer customer = new Customer("Alice");
//        customer.addToCart(laptop);
//        customer.addToCart(phone);
//        customer.placeOrder();


        System.out.println("=== Online Shop ===");

        System.out.println("Enter Your Name: ");
        String customerName = scanner.nextLine();
        Customer customer = new Customer(customerName);
        System.out.println("Welcome " + customerName);

        boolean running = true;
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add Product");
            System.out.println("2. Show Products");
            System.out.println("3. Add To Cart");
            System.out.println("4. Show Cart");
            System.out.println("5. Checkout");
            System.out.println("0. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("Enter Product Name: ");
                    String productName = scanner.nextLine();
                    System.out.println("Enter Product Price: ");
                    double productPrice = scanner.nextDouble();
                    Product product = new Product(productName, productPrice);
                    store.addProduct(product);
                    break;

                case 2:
                    System.out.println("Products: ");
                    for (Product p : store.getProducts()) {
                        System.out.println(p.getName() + " " + p.getPrice());
                    }
                    if (store.getProducts().isEmpty()) {
                        System.out.println("There Are No Products!");
                    }
                    break;

                case 3:
                    System.out.println("Enter Product Name: ");
                    String productForCart = scanner.nextLine();
                    Product productToAdd = findProductByName(store, productForCart);
                    if (productToAdd != null) {
                        customer.addToCart(productToAdd);
                    } else {
                        System.out.println("User Not Found!");
                    }
                    break;

                case 4:
                    System.out.println("Cart: ");
                    for (Product p : customer.getCart().getItems()) {
                        System.out.println(p.getName() + " " + p.getPrice());
                    }
                    if (customer.getCart().getItems().isEmpty()) {
                        System.out.println("There Are No Products!");
                    }
                    break;

                case 5:
                    customer.placeOrder();
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    public static Product findProductByName(Store store, String name) {
        for (Product p : store.getProducts()) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

}