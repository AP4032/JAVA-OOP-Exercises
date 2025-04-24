package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    final private String chosenWord;
    private char[] guessWord;
    private int attempt;
    private int score=0;

    public Game() {
        String filename = "src/main/resources/word.txt";
        this.chosenWord = RandomWord.getRandomWord(filename);
        if(chosenWord!=null){
            this.guessWord = new char[chosenWord.length()];
            for (int i = 0; i < this.guessWord.length; i++) {
                guessWord[i] = '-';
            }
        }else{
            System.exit(0);
        }
        this.attempt = chosenWord.length()+3;
    }

    public void play() {
        ArrayList<Character> guessedLetters = new ArrayList<>();
        while (attempt > 0) {
            Scanner scan = new Scanner(System.in);
            System.out.println("word: " + String.valueOf(guessWord));
            System.out.print("guess a letter: ");
            char guess = scan.next().charAt(0);
            guess = Character.toLowerCase(guess);
            boolean g = false;
            while(!g) {
                for (char letters : guessedLetters) {
                    if (letters == guess) {
                        System.out.print("You already guessed that!\nguess a letter: ");
                        guess = scan.next().charAt(0);
                        break;
                    }
                }
                g=true;
            }
            guessedLetters.add(guess);
            boolean correct = false;
            for (int i = 0; i < chosenWord.length(); i++) {
                if (Character.toLowerCase(chosenWord.charAt(i)) == Character.toLowerCase(guess)) {
                    guessWord[i] = guess;
                    score++;
                    correct = true;
                }
            }
            if (String.valueOf(guessWord).equals(chosenWord)) {
                System.out.println("You guessed the word correctly.\nthe word was: " + chosenWord);
                break;
            }
            if(!correct) {
                System.out.println("wrong guess");
            }
            attempt--;
            System.out.println("attempts left: "+attempt+"\nscore: "+score);
        }
        if (!String.valueOf(guessWord).equals(chosenWord)) {
            System.out.println("You couldn't guess the word.\nthe word was: " + chosenWord);
        }
    }
    public int getScore(){
        return score;
    }
}
