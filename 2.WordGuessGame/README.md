# Word Guessing Game 🎯

## Overview
This is a simple **Word Guessing Game** implemented in Java, using **OOP principles**. The player has a limited number of attempts to guess a randomly chosen word.

## Features
- Random word selection from a predefined list.
- Player can enter letter guesses.
- The game provides feedback on correct/incorrect guesses.
- The player has a limited number of attempts.

## Classes & Structure
```plaintext
WordGuessGame
 ├── Game
 ├── Player
 ├── Main (Runner)
```

## Implementation

### `Game.java`
```java
import java.util.Random;
import java.util.Scanner;

public class Game {
    private String[] words = {"java", "python", "programming", "developer", "object"};
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
            System.out.println("Word: " + String.valueOf(guessedWord));
            System.out.print("Enter a letter: ");
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
                System.out.println("Incorrect guess! Attempts left: " + attempts);
            }

            if (String.valueOf(guessedWord).equals(chosenWord)) {
                System.out.println("Congratulations! You guessed the word: " + chosenWord);
                return;
            }
        }
        System.out.println("Game Over! The word was: " + chosenWord);
    }
}
```

### `Player.java`
```java
public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```

### `Main.java`
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        Player player = new Player(name);
        
        System.out.println("Welcome, " + player.getName() + "! Let's play Word Guessing Game.");
        Game game = new Game();
        game.play();
    }
}
```

## How to Run
1. If you use new versions of java you can compile and run your code with this command in the terminal that is in your folder path:
   ```bash
   java fileName.java
   ```

## Future Enhancements
- Add a scoring system.
- Allow multiple players.
- Fetch words from an external file or API.

---
🧠 **Test your guessing skills!** 🎯
