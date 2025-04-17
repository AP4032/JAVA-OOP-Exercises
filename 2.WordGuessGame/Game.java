import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
public class Game
{
    private String[] words = {"java", "python", "csharp", "kotlin", "swift"};
    private String chosenWord;
    private char[] guessedWord;
    private int attempts;
    public int score = 800;
    ArrayList<Character>Guessing =  new ArrayList<>();

    public Game()
    {
        Random random = new Random();
        this.chosenWord = words[random.nextInt(words.length)];
        this.guessedWord = new char[chosenWord.length()];
        for (int i = 0; i < guessedWord.length; i++)
        {
            guessedWord[i] = '_';
        }
        this.attempts = chosenWord.length() + 3;
    }

    public void play()
    {
        Scanner scanner = new Scanner(System.in);
        while (attempts > 0 || score > 0)
        {
            System.out.println("Word: " + String.valueOf(guessedWord));
            System.out.print("Enter a letter: ");
            char guess = scanner.next().charAt(0);
            Guessing.add(guess);
            boolean sameGuess = false;
            boolean correct = false;

            for(int i = 0; i < Guessing.size() - 2; i++)
            {
                if (guess == Guessing.get(i))
                {
                    sameGuess = true;
                }
            }

            for (int i = 0; i < chosenWord.length(); i++)
            {
                if ((chosenWord.charAt(i) == guess) && !sameGuess)
                {
                    guessedWord[i] = guess;
                    correct = true;
                    score += 50;
                }
            }
            if (!correct)
            {
                attempts--;
                score -= 100;
                System.out.println("Incorrect guess! Attempts left: " + attempts + " Current Score: " + score);
            }

            if (String.valueOf(guessedWord).equals(chosenWord))
            {
                System.out.println("Congratulations! You guessed the word: " + chosenWord + "\nYour Final Score: " + score);
                return;
            }
        }
        System.out.println("Game Over! The word was: " + chosenWord);
        score = 0;
    }
}
