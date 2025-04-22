public class Main {


    private static Admin admin = new Admin();

    public static void main(String[] args) {

        admin.addCourse(new Course("Tennis"));
        admin.addCourse(new Course("Football"));
        admin.addCourse(new Course("Volleyball"));

        Print.printTitle("Welcome To Court Booking System");
        systemExplain();
        Player player = new Player(setPlayerName());
        Wallet.setWallet(50);

        boolean wantsExit = false;
        while (!wantsExit) {
            Print.printTitle("Welcome " + player.getName());
            Print.printGreenText("1- Book a Course\n");
            Print.printGreenText("2_ Add a Course\n");
            Print.printGreenText("3- Remove a Course\n");
            Print.printGreenText("4_ Exit\n");
            int choice = Input.getIntInput("What's your choice? ");

            switch (choice) {
                case 1:
                    showCourses(player);
                    break;
                case 2:
                    addCourse();
                    break;
                case 3:
                    removedCourse();
                    break;
                case 4:
                    Print.printTitle("Exiting Program, Sayonara");
                    wantsExit = true;
                    break;
                default:
                    Print.printTitle("Invalid Input, try again");
                    break;
            }
        }
    }

    private static void systemExplain() {
        String text = """
                ⚫ You can book any course from this system
                ⚫ You can't book a course twice
                """;

        Print.printRedText(text);
    }

    private static void showCourses(Player player) {

        while (true) {
            Print.printTitle("Sports Courses");
            Print.printRedText("Wallet: " + Wallet.getWallet() + "$");
            boolean isValid = false;
            while (!isValid) {
                admin.showCourseList();
                Print.printGreenText("" + (admin.getCourses().size() + 1));
                Print.printGreenText("- Return Back\n");
                int choice = Input.getIntInput("What's your choice? ");
                if (choice == admin.getCourses().size() + 1) return;
                else if (choice > admin.getCourses().size() - 1) Print.printTitle("Invalid input, try again");
                else {
                    player.bookCourse(admin.getCourses().get(choice-1));
                    isValid = true;
                }
            }

        }
    }

    private static void addCourse() {
        Print.printTitle("Add Course");
        Print.printGreenText("Enter the course name: ");
        String courseName = Input.scanner.nextLine();
        admin.addCourse(new Course(courseName));
        for (int i=0; i<admin.getCourses().size(); i++) {
            if (admin.getCourses().get(i).getSportType() == courseName)
                Print.printTitle("Added " + admin.getCourses().get(i).getSportType() + " course");
        }

    }

    private static void removedCourse() {
        Print.printTitle("Removed Course");
        Print.printGreenText("Enter the course name: ");
        String courseName = Input.scanner.nextLine();
        for (int i=0; i<admin.getCourses().size(); i++) {
            if (admin.getCourses().get(i).getSportType().equals(courseName))
                admin.removeCourse(admin.getCourses().get(i));
        }
    }

    private static String setPlayerName() {

        System.out.print("What's your name? ");
        return Input.scanner.nextLine();
    }
}