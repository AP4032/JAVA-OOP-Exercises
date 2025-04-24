package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class RandomWord {
    public static String getRandomWord(String fileName) {
        ArrayList<String> words = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line.trim());
            }
            if (!words.isEmpty()) {
                Random random = new Random();
                return words.get(random.nextInt(words.size()));
            } else {
                System.out.println("the file is empty!");
                return null;
            }
        } catch (IOException e) {
            System.out.println("Error.");
            return null;
        }
    }
}
