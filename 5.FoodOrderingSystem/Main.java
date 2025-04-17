import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurant restaurant = new Restaurant();

        System.out.println("--- Restaurant Management System ---");

        boolean running = true;
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add Customer(Admin only)");
            System.out.println("2. View Menu");
            System.out.println("3. Place Order");
            System.out.println("4. Add Items to Order");
            System.out.println("5. Update Order Status(Admin only)");
            System.out.println("6. Process Payment");
            System.out.println("7. Delivery Tracking");
            System.out.println("8. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter table number: ");
                    int tableNumber = scanner.nextInt();
                    scanner.nextLine();
                    Customer customer = new Customer(tableNumber);
                    restaurant.addCustomer(customer);
                    break;

                case 2:
                    restaurant.printMenu();
                    break;

                case 3:
                    System.out.print("Enter table number: ");
                    int tableOrder = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter menu item to order: ");
                    String itemOrder = scanner.nextLine();

                    Customer foundCustomer = restaurant.findCustomer(tableOrder);
                    if (foundCustomer != null) {
                        MenuItem item = restaurant.getMenuItemByName(itemOrder);
                        if (item != null) {
                            foundCustomer.placingOrder(item);
                            System.out.println("Order placed for Table " + tableOrder + ": " + item.getName());
                        } else {
                            System.out.println("Menu item not found.");
                        }
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter table number: ");
                    int tableAdd = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter menu item to add: ");
                    String itemAdd = scanner.nextLine();

                    Customer customerForAdd = restaurant.findCustomer(tableAdd);
                    if (customerForAdd != null) {
                        MenuItem itemToAdd = restaurant.getMenuItemByName(itemAdd);
                        if (itemToAdd != null) {
                            customerForAdd.addToExistingOrder(itemToAdd);
                            System.out.println("Item added to the order for Table " + tableAdd + ": " + itemToAdd.getName());
                        } else {
                            System.out.println("Menu item not found.");
                        }
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter table number: ");
                    int tableStatus = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new status: ");
                    String newStatus = scanner.nextLine();

                    Customer customerForStatus = restaurant.findCustomer(tableStatus);
                    if (customerForStatus != null && customerForStatus.getOrder() != null) {
                        restaurant.updatingStatus(customerForStatus.getOrder(), newStatus);
                    } else {
                        System.out.println("No order found for Table " + tableStatus);
                    }
                    break;

                case 6:
                    System.out.print("Enter table number: ");
                    int tablePayment = scanner.nextInt();
                    scanner.nextLine();

                    Customer customerForPayment = restaurant.findCustomer(tablePayment);
                    if (customerForPayment != null && customerForPayment.getOrder() != null) {
                        double totalAmount = customerForPayment.getOrder().getTotalAmount();
                        System.out.print("Enter payment method (Card/Cash): ");
                        String paymentMethod = scanner.nextLine();

                        Payment payment = new Payment(totalAmount, paymentMethod);
                        if (payment.processPayment()) {
                            System.out.println("Payment processed for Table " + tablePayment);
                        }
                    } else {
                        System.out.println("No order found for Table " + tablePayment);
                    }
                    break;

                case 7:
                    System.out.print("Enter tracking number: ");
                    String trackingNumber = scanner.nextLine();

                    DeliveryTracking tracking = new DeliveryTracking(trackingNumber);

                    boolean trackingRunning = true;
                    while (trackingRunning) {
                        System.out.println("\n--- Delivery Tracking Menu ---");
                        System.out.println("1. View Delivery Status");
                        System.out.println("2. Update Delivery Status");
                        System.out.println("3. Back to Main Menu");

                        System.out.print("Choose an option: ");
                        int trackingChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (trackingChoice) {
                            case 1:
                                System.out.println("Current status: " + tracking.getStatus());
                                break;
                            case 2:
                                System.out.print("Enter new status: ");
                                String status = scanner.nextLine();
                                tracking.updateStatus(status);
                                break;
                            case 3:
                                trackingRunning = false;
                                break;
                            default:
                                System.out.println("Invalid option. Try again.");
                        }
                    }
                    break;

                case 8:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }
}
