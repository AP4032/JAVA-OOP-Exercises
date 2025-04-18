import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Store store = new Store();
        boolean Closed=true;
        String number;
        Product laptop = new Product("laptop", 999.99);
        Product phone = new Product("phone", 499.99);
        Product Speaker = new Product("Speaker", 19.99);
        Product HandsFree = new Product("HandsFree", 8.00);
        Product Modem = new Product("Modem", 29.99);
        store.addProduct(Speaker);
        store.addProduct(HandsFree);
        store.addProduct(Modem);
        store.addProduct(laptop);
        store.addProduct(phone);
        while(Closed) {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃Welcome to Big Masoud online shop     ┃");
            System.out.println("┃1.add Product                         ┃");
            System.out.println("┃2.new Customer                        ┃");
            System.out.println("┃3.Where is my product?(Customer)      ┃");
            System.out.println("┃4.Admin(Order management)             ┃");
            System.out.println("┃5.Exit                                ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            double PriceProduct;
            number=scanner.nextLine();
            switch(number.charAt(0)-'0'){
                case 1:
                    System.out.println("Enter Name Product");
                    String NewProduct=scanner.nextLine();
                    System.out.println("Enter Price Product");
                    while(true){
                        if(scanner.hasNextDouble()){
                            PriceProduct=scanner.nextDouble();
                            scanner.nextLine();
                            break;
                        }else {
                            System.out.println("Invalid Input,Try Again");
                            scanner.next();
                        }
                    }
                    Product product=new Product(NewProduct,PriceProduct);
                    store.addProduct(product);
                    break;
                case 2:
                    System.out.println("Enter your name Sir");
                    String NameCustomer=scanner.nextLine();
                    Customer0 customer=new Customer0(NameCustomer);
                    String NameProduct;
                    String More;
                    while(true) {
                        ShowMenu(store);
                        System.out.println("Enter Name Product");
                        NameProduct = scanner.nextLine();
                        Product product1 = TrueProduct(store, NameProduct);
                        if (product1 != null) {
                            customer.addToCart(product1);
                        } else System.out.println("No Find Product");
                        System.out.println("Do you Have more Orders?y/n");
                        More = scanner.nextLine();
                        if (More.charAt(0) == 'n' || More.charAt(0) == 'N') {
                            break;
                        }
                    }
                    System.out.println("Your Products");
                    customer.ShowItems();
                    System.out.println("Sum of prices:"+ customer.getCalculateTotal());
                    System.out.println("Do you Checkout?y/n");
                    String Checkout = scanner.nextLine();
                    if (Checkout.charAt(0) == 'y' || Checkout.charAt(0) == 'Y') {
                        customer.placeOrder();
                        store.addCustomer(customer);
                        break;
                    }else System.out.println("Try Again");
                    break;
                case 3:
                    System.out.println("Please Enter your Name");
                    String HowMyProDuct=scanner.nextLine();
                    Customer0 customer01=WhereIsMyOrder(store,HowMyProDuct);
                    if(customer01!=null){
                        System.out.println("Your order status: "+customer01.getStatus());
                    }else System.out.println("No Find Customer");
                    break;
                case 4:
                    System.out.println("HelLo Sir,All order,Choose");
                    for(Customer0 AllCustomer:store.getCustomer()){
                        System.out.println(AllCustomer.getName()+"  Order status:"+AllCustomer.getStatus());
                        AllCustomer.ShowItems();
                    }
                    String Choose=scanner.nextLine();
                    Customer0 ChooseCustomer=WhereIsMyOrder(store,Choose);
                    if(ChooseCustomer!=null){
                        System.out.println("Change in status");
                        Choose=scanner.nextLine();
                        ChooseCustomer.setStatus(Choose);
                    }else System.out.println("NO Find Customer");
                    break;
                case 5:
                    System.out.println("Closed");
                    Closed=false;
                    break;
            }
        }


    }
    public static void ShowMenu(Store store){
        System.out.println("------Menu------");
        int Number=1;
           for(Product P:store.getProducts()){
               System.out.println(Number+"."+P.getName()+"    Price:"+P.getPrice());
               Number++;
           }
        System.out.println("---------------");
    }
    public static Product TrueProduct (Store store,String NameTrue){
        for(Product pro : store.getProducts()){
            if(pro.getName().equalsIgnoreCase(NameTrue)){
                return pro;
            }
        }
        return null;
    }
    public static Customer0 WhereIsMyOrder(Store store,String name){
        for (Customer0 customer0: store.getCustomer()){
            if(customer0.getName().equalsIgnoreCase(name)){
                return customer0;
            }
        }
        return null;
    }
}