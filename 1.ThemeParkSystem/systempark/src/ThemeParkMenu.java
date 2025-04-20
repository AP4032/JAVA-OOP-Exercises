import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ThemeParkMenu {
    private static List<Ride> rides = new ArrayList<>();
    private static List<Visitor> visitors = new ArrayList<>();
    private static Admin admin = new Admin();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showMainMenu();
    }

    private static void showMainMenu() {
        while (true) {
            System.out.println("\n*** مدیریت شهربازی ***\n");
            System.out.println("1. مدیریت وسایل بازی");
            System.out.println("2. مدیریت بازدیدکنندگان");
            System.out.println("3. مدیریت صف‌ها");
            System.out.println("4. نمایش اطلاعات");
            System.out.println("5. خروج");
            System.out.print("لطفاً گزینه مورد نظر را انتخاب کنید: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> manageRides();
                case 2 -> manageVisitors();
                case 3 -> manageQueues();
                case 4 -> displayInformation();
                case 5 -> {
                    System.out.println("با تشکر از استفاده شما. خداحافظ!");
                    System.exit(0);
                }
                default -> System.out.println("گزینه نامعتبر! لطفاً عدد بین 1 تا 5 وارد کنید.");
            }
        }
    }

    private static void manageRides() {
        while (true) {
            System.out.println("\n=== مدیریت وسایل بازی ===");
            System.out.println("1. اضافه کردن وسیله جدید");
            System.out.println("2. حذف وسیله");
            System.out.println("3. نمایش همه وسایل");
            System.out.println("4. بازگشت به منوی اصلی");
            System.out.print("انتخاب کنید: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("نام وسیله بازی: ");
                    String name = scanner.nextLine();
                    System.out.print("ظرفیت: ");
                    int capacity = scanner.nextInt();
                    System.out.print("مدت زمان (دقیقه): ");
                    int duration = scanner.nextInt();

                    Ride newRide = new Ride(name, capacity, duration);
                    admin.addRide(newRide);
                    rides.add(newRide);
                }
                case 2 -> {
                    if (rides.isEmpty()) {
                        System.out.println("هیچ وسیله‌ای وجود ندارد.");
                        break;
                    }
                    System.out.println("لیست وسایل بازی:");
                    for (int i = 0; i < rides.size(); i++) {
                        System.out.println((i+1) + ". " + rides.get(i));
                    }
                    System.out.print("شماره وسیله برای حذف: ");
                    int index = scanner.nextInt() - 1;
                    if (index >= 0 && index < rides.size()) {
                        rides.remove(index);
                        System.out.println("وسیله با موفقیت حذف شد.");
                    } else {
                        System.out.println("شماره نامعتبر!");
                    }
                }
                case 3 -> displayRides();
                case 4 -> {
                    return;
                }
                default -> System.out.println("گزینه نامعتبر!");
            }
        }
    }

    private static void manageVisitors() {
        while (true) {
            System.out.println("\n=== مدیریت بازدیدکنندگان ===");
            System.out.println("1. ثبت بازدیدکننده جدید");
            System.out.println("2. ثبت بازدیدکننده VIP");
            System.out.println("3. نمایش همه بازدیدکنندگان");
            System.out.println("4. بازگشت به منوی اصلی");
            System.out.print("انتخاب کنید: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("نام بازدیدکننده: ");
                    String name = scanner.nextLine();
                    visitors.add(new Visitor(name));
                    System.out.println("بازدیدکننده با موفقیت ثبت شد.");
                }
                case 2 -> {
                    System.out.print("نام بازدیدکننده VIP: ");
                    String vipName = scanner.nextLine();
                    visitors.add(new VIPVisitor(vipName));
                    System.out.println("بازدیدکننده VIP با موفقیت ثبت شد.");
                }
                case 3 -> displayVisitors();
                case 4 -> {
                    return;
                }
                default -> System.out.println("گزینه نامعتبر!");
            }
        }
    }

    private static void manageQueues() {
        if (rides.isEmpty() || visitors.isEmpty()) {
            System.out.println("وسایل بازی یا بازدیدکنندگان وجود ندارند!");
            return;
        }

        while (true) {
            System.out.println("\n=== مدیریت صف‌ها ===");
            System.out.println("1. اضافه کردن بازدیدکننده به صف");
            System.out.println("2. شروع وسیله بازی");
            System.out.println("3. بازگشت به منوی اصلی");
            System.out.print("انتخاب کنید: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("لیست بازدیدکنندگان:");
                    displayVisitors();
                    System.out.print("شماره بازدیدکننده: ");
                    int visitorIndex = scanner.nextInt() - 1;

                    System.out.println("لیست وسایل بازی:");
                    displayRides();
                    System.out.print("شماره وسیله بازی: ");
                    int rideIndex = scanner.nextInt() - 1;

                    if (visitorIndex >= 0 && visitorIndex < visitors.size() &&
                            rideIndex >= 0 && rideIndex < rides.size()) {
                        Visitor visitor = visitors.get(visitorIndex);
                        Ride ride = rides.get(rideIndex);

                        if (visitor instanceof VIPVisitor) {
                            ((VIPVisitor)visitor).getPriorityAccess(ride);
                        }
                        ride.addVisitor(visitor);
                    } else {
                        System.out.println("شماره نامعتبر!");
                    }
                }
                case 2 -> {
                    System.out.println("لیست وسایل بازی:");
                    displayRides();
                    System.out.print("شماره وسیله بازی برای شروع: ");
                    int startRideIndex = scanner.nextInt() - 1;
                    if (startRideIndex >= 0 && startRideIndex < rides.size()) {
                        rides.get(startRideIndex).startRide();
                    } else {
                        System.out.println("شماره نامعتبر!");
                    }
                }
                case 3 -> {
                    return;
                }
                default -> System.out.println("گزینه نامعتبر!");
            }
        }
    }

    private static void displayInformation() {
        System.out.println("\n=== اطلاعات سیستم ===");
        displayRides();
        displayVisitors();
    }

    private static void displayRides() {
        System.out.println("\nوسایل بازی موجود:");
        if (rides.isEmpty()) {
            System.out.println("هیچ وسیله‌ای وجود ندارد.");
        } else {
            for (int i = 0; i < rides.size(); i++) {
                Ride ride = rides.get(i);
                System.out.println((i+1) + ". " + ride + " (ظرفیت: " + ride.getCapacity() + ")");
            }
        }
    }

    private static void displayVisitors() {
        System.out.println("\nبازدیدکنندگان ثبت‌شده:");
        if (visitors.isEmpty()) {
            System.out.println("هیچ بازدیدکننده‌ای وجود ندارد.");
        } else {
            for (int i = 0; i < visitors.size(); i++) {
                Visitor visitor = visitors.get(i);
                String type = (visitor instanceof VIPVisitor) ? "VIP" : "عادی";
                System.out.println((i+1) + ". " + visitor.getName() + " (" + type + ")");
            }
        }
    }
}