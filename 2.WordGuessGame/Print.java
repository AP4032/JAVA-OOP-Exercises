public class Print {

    private static final String blueText = "\u001B[34m";
    public static final String greenText = "\u001B[32m";
    private static final String redText = "\u001B[31m";
    private static final String resetColor = "\u001B[0m";

    public static void printTitle(String title) {

        System.out.println(blueText);
        starLine(title.length() + 10);
        System.out.println("**** " + title + " ****");
        starLine(title.length() + 10);
        System.out.println(resetColor);

    }

    private static void starLine(int titleLength) {
        System.out.println("*".repeat(titleLength));
    }

    public static void printGameRule(String gameRule) {
        System.out.println(redText + gameRule + resetColor);
    }

    public static void printGuessWord(char[] guessWord) {
        System.out.print("Word: ");

        for (int i=0; i<guessWord.length; i++) {
            System.out.print(redText + guessWord[i] + ' ');
        }
        System.out.println(resetColor);
    }

    public static void printText(String text) {
        System.out.print(greenText + text);
    }

    public static void printGameResult(String gameResult) {
        System.out.println(redText);
        starLine( gameResult.length() + 14);
        System.out.println("**** " + "You " + gameResult + " ****");
        starLine( gameResult.length() + 14);
        System.out.println(resetColor);
    }
}
