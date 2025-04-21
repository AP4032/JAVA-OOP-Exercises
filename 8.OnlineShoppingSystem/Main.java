import java.io.PrintStream;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class Main {
    static Store store = new Store();
    static Product laptop = new Product("Laptop", 999.99, "A social gaming laptop !");
    static Product phone = new Product("Smartphone", 499.99, " S24 ultra + cover and mark !");
    static Product monitor = new Product("Monitor", 399.99 , "experience the bast quality !");
    static Product pizza = new Product("Pizza", 60.5, "Maded by chicken and cheese and Vegetables");
    static Product airpod = new Product("Airpod", 200,"galaxy buds 2 pro!");
    static Customer customer= new Customer();
    static ShoppingCart cart = new ShoppingCart();
    public static void main(String[] args) {



        store.addProduct(laptop);
        store.addProduct(phone);
        store.addProduct(monitor);
        store.addProduct(pizza);
        store.addProduct(airpod);


        Scanner input = new Scanner(System.in);

        System.out.println("Hello dude! ");
        System.out.println("Answer these questions: ");
        System.out.println("Enter your name :");
        String name = input.nextLine();
        customer.setName(name);
        System.out.println("Enter your account balance :");
        double accountBalance = input.nextDouble();
        customer.setAccountBalance(accountBalance);

        System.out.println("Welcome to your shop " + customer.getname());
        menu();
        customer.placeOrder();
    }
    public static void menu() {
        Scanner input = new Scanner(System.in);

        System.out.println("1. view products");
        System.out.println("2. add product to my Shopping list");
        System.out.println("3. remove product to my Shopping list");
        System.out.println("4. check my shopping list");
        System.out.println("5. Paying for the shopping list");
        System.out.println("6. Exit");
        int choice = input.nextInt();
        switch(choice){
            case 1:
                System.out.println(laptop.toString());
                System.out.println(phone.toString());
                System.out.println(monitor.toString());
                System.out.println(pizza.toString());
                System.out.println(airpod.toString());
                menu();
                break;
            case 2:
                System.out.println("enter your product name :");
                input.nextLine();
                String productname = input.nextLine();
                switch(productname){
                    case "laptop":
                        cart.addItem(laptop);
                        menu();
                    case "phone":
                        cart.addItem(phone);
                        menu();
                    case "monitor":
                        cart.addItem(monitor);
                        menu();
                    case "pizza":
                        cart.addItem(pizza);
                        menu();
                    case "airpod":
                        cart.addItem(airpod);
                        menu();
                    default:
                        System.out.println("couldn't find product.");
                        menu();
                }
            case 3 :
                System.out.println("enter your product name :");
                input.nextLine();
                String productname2 = input.nextLine();
                switch(productname2) {
                    case "laptop":
                        cart.removeItem(laptop);
                        menu();
                    case "phone":
                        cart.removeItem(phone);
                        menu();
                    case "monitor":
                        cart.removeItem(monitor);
                        menu();
                    case "pizza":
                        cart.removeItem(pizza);
                        menu();
                    case "airpod":
                        cart.removeItem(airpod);
                        menu();
                    default:
                        System.out.println("couldn't find product.");
                        menu();
                        break;
                }
            case 4 :
                cart.displayItems();
                System.out.println("and these list cost :" + cart.calculateTotal());
                System.out.println("your balance : "+ customer.getAccountBalance());
                menu();
            case 5 :
                if(cart.calculateTotal()>= customer.getAccountBalance()){
                    double m = customer.getAccountBalance() - cart.calculateTotal();
                    customer.setAccountBalance(m);
                    System.out.println("Purchase completed successfully.");
                    menu();
                }
                else{
                    System.out.println("You don't have enough money.");
                    menu();
                }
            case 6 :
                System.out.println("bye bye");
                System.exit(0);


        }


    }


}