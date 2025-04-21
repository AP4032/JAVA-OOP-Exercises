public class Print {

    private static final String redText = "\u001B[31m";
    private static final String greenText = "\u001B[32m";
    private static final String blueText = "\u001B[34m";
    private static final String resetColor = "\u001B[0m";

    public static void printTitle(String title) {
        System.out.println(blueText);
        printStarLine(title.length());
        System.out.println("**** " + title + " ****");
        printStarLine(title.length());
        System.out.println(resetColor);
    }

    private static void printStarLine(int length) {
        System.out.println("*".repeat(length+10));
    }

    public static void printRedText(String text) {
        System.out.println(redText + text + resetColor);
    }

    public static void printGreenText(String text) {
        System.out.print(greenText + text);
    }
}
