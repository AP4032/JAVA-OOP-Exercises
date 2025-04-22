//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//import java.util.Scanner;
import java.util.*;

public class Game {
    List<Character> CharGuess;
    Random rand = new Random();
    String[] Word = {"ali", "naser", "benoud", "java", "iran"};
    private String name;
    int Opportunity = 5;
    String WordGuess;
    public Game(Player player) {
        this.CharGuess = new ArrayList<>();
        this.WordGuess = Word[rand.nextInt(5)];
        for (char ch : WordGuess.toCharArray()) {
            CharGuess.add('_');
        }

        this.name = player.getName();
    }

    public void play() {
        Scanner input = new Scanner(System.in);
//        boolean foundWord = false;
        String guess = " ";
        while (Opportunity > 0 && GameOver()) {
//            System.out.println("_____________________________________");
            PrintGrid();
            System.out.println(name+" Please enter the word you want to guess(You have "+Opportunity+" chances.):");
            guess = input.nextLine().toLowerCase();
            if (InputValidator(guess)&&plw(guess)) {
                playturn(guess);
                System.out.println("\033[32mWell done!, you got one thing right. \033[0m");
            }
            else{
                System.out.println("\033[31m The letters entered are incorrect. please try again. \033[0m");
                Opportunity--;
            }

        }
        if (!GameOver()) {
            System.out.println("you win");
        }
        else {
            System.out.println("you lose");
        }

    }

    public void PrintGrid() {
        for (Character ch : CharGuess) {
            System.out.print(ch + " ");
        }
        System.out.println();
    }

    public boolean InputValidator(String Guess) {
        if (Guess.length() != 1) {
            return false;
        }
        char ch = Guess.charAt(0);
        return ch >= 'a' && ch <= 'z';
    }
    public  boolean plw(String Guess) {
        char ch = Guess.charAt(0);
        for (char chr : WordGuess.toCharArray()) {
            if (chr == ch) {
                return true;
            }
        }
        return false;
    }
    public  void playturn (String Guess)
    {
        for (int i=0;i<CharGuess.size();i++) {
            if (WordGuess.charAt(i) == Guess.charAt(0)) {
                CharGuess.set(i,Guess.charAt(0));

            }
        }
    }
    public boolean GameOver ()
    {
        for (char chr : CharGuess)
        {
            if (chr == '_')
            { return true; }

        }
        return false;
    }
}
