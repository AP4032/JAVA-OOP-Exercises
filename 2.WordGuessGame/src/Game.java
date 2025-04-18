import java.util.Random;
import java.util.Scanner;

public class Game {
    private String[] words = {"جاوا", "پایتون", "برنامه‌نویسی", "توسعه‌دهنده", "شیء"};
    private String chosenWord;
    private char[] guessedWord;
    private int attempts;

    public Game() {
        Random random = new Random();
        this.chosenWord = words[random.nextInt(words.length)];
        this.guessedWord = new char[chosenWord.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }
        this.attempts = chosenWord.length() + 3;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (attempts > 0) {
            System.out.println("کلمه: " + String.valueOf(guessedWord));
            System.out.print("یک حرف وارد کنید: ");
            char guess = scanner.next().charAt(0);
            boolean correct = false;

            for (int i = 0; i < chosenWord.length(); i++) {
                if (chosenWord.charAt(i) == guess) {
                    guessedWord[i] = guess;
                    correct = true;
                }
            }

            if (!correct) {
                attempts--;
                System.out.println("حدس نادرست! تعداد تلاش‌های باقی‌مانده: " + attempts);
            }

            if (String.valueOf(guessedWord).equals(chosenWord)) {
                System.out.println("تبریک! شما کلمه را حدس زدید: " + chosenWord);
                return;
            }
        }
        System.out.println("بازی تمام شد! کلمه مورد نظر بود: " + chosenWord);
    }
}