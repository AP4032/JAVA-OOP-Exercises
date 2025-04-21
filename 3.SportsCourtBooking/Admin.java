package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin {
private ArrayList<Court> courts = new ArrayList<>();

    public void addCourt(Scanner input) {
        System.out.println("Enter your choice \n1-Add court\n2-Exit");
        int choice ;
        while (true) {
            choice = Main.validInput(input,1,2);
            switch (choice) {
                case 1:
                    System.out.println("Enter the court name: ");

                    String name = input.nextLine();

                    if (courts.contains(name)) {
                        System.out.println("That court is already in the list");
                    } else {
                        courts.add(new Court(name));
                        System.out.println("Added court successfully : " + name);
                        return;
                    }
                    break;
                case 2:
                    return;
            }
        }
    }
    public void removeCourt(Scanner input) {
        System.out.println("Enter your choice \n1-Remove court\n2-Exit");
        int choice ;
        while (true) {
            choice = Main.validInput(input,1,2);

        switch (choice) {
            case 1:
                if (courts.isEmpty()) {
                    System.out.println("Court list is empty");
                    return;
                }
                System.out.println("Enter the court index you want to remove: ");
                showAllCourts();
                int courtIndex = Main.validInput(input,1,courts.size())-1;
                courts.remove(courtIndex);
                System.out.println(" Court removed successfully  ");
                return;
            case 2:
                return;
        }

        }
    }
    public List<Court> getCourts() {
        return courts;
    }
   public void showAllCourts() {
        if (courts.isEmpty()) {
            System.out.println("Court list is empty");
            return;
        }
        for(int i = 0; i<courts.size();i++) {
            System.out.println(1+i + ". " + courts.get(i).getNameSport());
        }
   }


   }


