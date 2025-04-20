import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Scanner scanner = new Scanner(System.in);


        store.addProduct(new Product("Laptop", 1000, 5));
        store.addProduct(new Product("Phone", 500, 3));

        Customer customer = new Customer("Alice");

        while (true) {
            System.out.println("\n====== Online Shopping System ======");
            System.out.println("1. Show products");
            System.out.println("2. Add product to cart");
            System.out.println("3. Place order");
            System.out.println("4. Add new product to store");
            System.out.println("0. Exit");
            System.out.print(" Choose option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    store.showProducts();
                    break;
                case 2:
                    store.showProducts();
                    System.out.print("Enter product number: ");
                    int index = scanner.nextInt() - 1;
                    if (index >= 0 && index < store.getProducts().size()) {
                        customer.addToCart(store.getProducts().get(index));
                    } else {
                        System.out.println(" Invalid product.");
                    }
                    break;
                case 3:
                    customer.placeOrder();
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    store.addProduct(new Product(name, price, quantity));
                    break;
                case 0:
                    System.out.println(" Exit. Thank you!");
                    return;
                default:
                    System.out.println(" Invalid choice.");
            }
        }
    }
}
