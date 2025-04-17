import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Store store = new Store();
        int choice;
        int option;

        System.out.println("Welcome to our Shopping System!");
        do
        {
            System.out.println("Who are you?");
            System.out.println("1. Manager");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            choice = sc.nextInt();
            String temp = sc.nextLine();
            switch (choice)
            {
                case 1:
                    boolean adding = true;
                    System.out.println("Lets add some products in our shop.");
                    while (adding)
                    {
                        System.out.println("Enter product name: ");
                        String name = sc.nextLine();
                        System.out.println("Enter product price: ");
                        double price = sc.nextDouble();
                        Product product = new Product(name, price);
                        store.addProduct(product);
                        String temp1 = sc.nextLine();
                        System.out.println("Would you like to add more products? (y/n)");
                        String answer = sc.nextLine();
                        adding = answer.equalsIgnoreCase("y");
                    }
                    break;
                case 2:
                    System.out.println("Enter your name: ");
                    String customerName = sc.nextLine();
                    Customer customer = new Customer(customerName);
                    do
                    {
                        System.out.println("What do you want?");
                        System.out.println("1. Have our products list");
                        System.out.println("2. Add some product to your shopping cart");
                        System.out.println("3. Buy all your selected products");
                        System.out.println("4. Exit");
                        option = sc.nextInt();
                        String temp1 = sc.nextLine();
                        switch (option)
                        {
                            case 1:
                                System.out.println("The list of our products:");
                                store.getProducts();
                                break;
                            case 2:
                                boolean buying = true;
                                while(buying)
                                {
                                    System.out.println("Enter product name: ");
                                    String name = sc.nextLine();
                                    System.out.println("Enter product price: ");
                                    double price = sc.nextDouble();
                                    Product product = new Product(name, price);
                                    customer.addToCart(product);
                                    String temp2 = sc.nextLine();
                                    System.out.println("Would you like to add more products? (y/n)");
                                    String answer = sc.nextLine();
                                    buying = answer.equalsIgnoreCase("y");
                                }
                                break;
                            case 3:
                                customer.placeOrder();
                                break;
                            case 4:
                                    System.out.println("Dear " + customer.getName() + ",\nThank you for choosing our Shop!");
                                    break;
                            default:
                                System.out.println("Invalid option!");
                                break;
                        }
                    }while(option != 4);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                        System.out.println("Invalid choice!");
                        break;
            }
        }while (choice != 3);
    }
}