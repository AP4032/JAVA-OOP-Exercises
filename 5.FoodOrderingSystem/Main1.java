import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Scanner scanner=new Scanner(System.in);
        MenuItem burger = new MenuItem("Burger", 5.99);
        MenuItem pizza = new MenuItem("Pizza", 8.99);
        MenuItem Potato = new MenuItem("Potato", 2.99);
        MenuItem CocaCola = new MenuItem("CocaCola", 1.99);
        MenuItem Pepsi = new MenuItem("Pepsi", 1.99);
        restaurant.SaveFoodInmMenu(burger);
        restaurant.SaveFoodInmMenu(pizza);
        restaurant.SaveFoodInmMenu(Potato);
        restaurant.SaveFoodInmMenu(CocaCola);
        restaurant.SaveFoodInmMenu(Pepsi);
        boolean Closed= true;
        while(Closed){
            System.out.println("\uD83E\uDD69 \uD83C\uDF54 \uD83C\uDF5F \uD83C\uDF55\uD83E\uDD69 \uD83C\uDF54 \uD83C\uDF5F \uD83C\uDF55\uD83E\uDD69 \uD83C\uDF54 \uD83C\uDF5F \uD83C\uDF55 \uD83E\uDD69");
            System.out.println("\uD83E\uDD69 Welcome to Big Masoud Restaurant \uD83E\uDD69");
            System.out.println("\uD83C\uDF54 1.add Food in List               \uD83C\uDF54");
            System.out.println("\uD83C\uDF5F 2.add Customer                   \uD83C\uDF5F");
            System.out.println("\uD83C\uDF55 3.Kitchen                        \uD83C\uDF55");
            System.out.println("\uD83E\uDD69 4.Order status                   \uD83E\uDD69");
            System.out.println("\uD83C\uDF5F 5.Delete Food in List            \uD83C\uDF5F");
            System.out.println("\uD83C\uDF55 6.Show Menu                      \uD83C\uDF55");
            System.out.println("\uD83E\uDD69 7.Exit                           \uD83C\uDF54");
            System.out.println("\uD83E\uDD69 \uD83C\uDF54 \uD83C\uDF5F \uD83C\uDF55\uD83E\uDD69 \uD83C\uDF54 \uD83C\uDF5F \uD83C\uDF55\uD83E\uDD69 \uD83C\uDF54 \uD83C\uDF5F \uD83C\uDF55 \uD83E\uDD69");

            String Where=scanner.nextLine();
            switch (Where.charAt(0)-'0'){
                case 1:
                    System.out.println("Enter name food");
                    String namefood = scanner.nextLine();
                    System.out.println("add price");
                    String pricefood;
                    int price;
                    while (true) {
                        pricefood = scanner.nextLine();
                        if (pricefood.length() <= 1) {
                            price = pricefood.charAt(0) - '0';
                            break;
                        }
                        if (pricefood.length() == 2) {
                            price = pricefood.charAt(1) - '0';
                            price += (pricefood.charAt(0) - '0') * 10;
                            break;
                        }
                        if (pricefood.length() == 3) {
                            price = pricefood.charAt(2) - '0';
                            price += (pricefood.charAt(1) - '0') * 10;
                            price += (pricefood.charAt(0) - '0') * 100;
                            break;
                        }
                        System.out.println("add namotabar");
                    }
                    MenuItem menuItem = new MenuItem(namefood, price);
                    restaurant.SaveFoodInmMenu(menuItem);
                    System.out.println("Added to the menu");
                    break;
                case 2:
                    System.out.println("What your name Sir");
                    String NameCusromer=scanner.nextLine();
                    Customer cusromer=new Customer(NameCusromer);
                    MenuItem MenuDouble;
                    String ChooseFood;
                    String yesorno;
                    List<MenuItem> AllChoose =new ArrayList<>();
                    double Sorthsab=0.0;
                    boolean EndChoose=true;
                    for (MenuItem menu: restaurant.getMenuFood()){
                        System.out.println(menu.getName()+"  $"+ menu.getPrice());
                    }
                    while (EndChoose) {
                        System.out.println("Choose  Sir");
                        ChooseFood = scanner.nextLine();
                        MenuDouble=TrueFood(restaurant, ChooseFood);
                        if(null!=MenuDouble){
                            AllChoose.add(MenuDouble);
                            Sorthsab+= MenuDouble.getPrice();
                        } else {System.out.println("No Find Food");}
                        System.out.println("Do you more choose:y/n");
                        yesorno=scanner.nextLine();
                        if(yesorno.charAt(0)=='n'||yesorno.charAt(0)=='N'){
                            EndChoose=false;
                        }
                    }
                    if (!(AllChoose.isEmpty())) {
                        Order order=cusromer.placeOrder(AllChoose);
                        restaurant.receiveOrder(order);
                        System.out.println("---------------------------");
                        System.out.println("Your ID:"+order.getIDorder());
                        System.out.println("---------------------------");
                    }
                    System.out.println("Price total: $"+Sorthsab);

                    break;
                case 3:
                    System.out.println("Hello Chef Which order is ready? Enter ID Food");
                    PrintListOrder(restaurant);
                    int OrderID =scanner.nextInt();
                    scanner.nextLine();
                    Order readyOrder= WhoOrder(restaurant,OrderID);
                    if(readyOrder!=null){
                        System.out.println("Chef, how is the order?");
                        String HowIsTheOrder=scanner.nextLine();
                        readyOrder.updateStatus(HowIsTheOrder);
                    }else{ System.out.println("No find Order");}
                    break;
                case 4:
                    double Status=0.0;
                    for (Order Ord:restaurant.getOrders()){
                        for(MenuItem item : Ord.getitems()){
                            System.out.print(" ["+item.getName()+"]");
                            Status+=item.getPrice();
                        }
                        System.out.print(" $"+Status+" ID:"+Ord.getIDorder());
                        System.out.println("    Status:"+Ord.getStatus());
                    }
                    break;
                case 5:
                    System.out.println("Enter name food");
                    String nameFooD=scanner.nextLine();
                    MenuItem menuItem10=TrueFood(restaurant,nameFooD);
                    if(menuItem10!=null){
                        restaurant.DeleteFood(menuItem10);
                    }else System.out.println("No Find Food");
                    break;
                case 6:
                    System.out.println("---------Menu----------");
                    for (MenuItem menu: restaurant.getMenuFood()){
                        System.out.println(menu.getName()+"  $"+ menu.getPrice());
                    }
                    System.out.println("-----------------------");
                    break;
                case 7 :
                    System.out.println("Closed Restaurant");
                    Closed=false;
                    break;
            }

        }




    }
    public static MenuItem TrueFood(Restaurant restaurant, String FoodTrue ){
        for (MenuItem M:restaurant.getMenuFood()){
            if(FoodTrue.equalsIgnoreCase(M.getName())){
                return M;

            }
        }
        return null;
    }
    public static void PrintListOrder(Restaurant restaurant){
        for (Order O: restaurant.getOrders()){
            for (MenuItem T:O.getitems()){
                System.out.print(" ["+T.getName()+"]");
            }

            System.out.println(" ID:"+O.getIDorder());
        }
    }
    public static Order WhoOrder(Restaurant restaurant,int OrderPrice){
        for (Order Order:restaurant.getOrders()){
            if(Order.getIDorder()==OrderPrice){
                return Order;
            }
        }
        return null;
    }
}

