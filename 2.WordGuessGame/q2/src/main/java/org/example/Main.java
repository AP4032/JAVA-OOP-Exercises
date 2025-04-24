package org.example;

import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();
        boolean addedAPlayer=false;
        int ch = menu(addedAPlayer);
        int numbersOfPLayers=0;
        outerLoop:
        while(true) {
            switch (ch) {
                case 1:
                    addedAPlayer = true;
                    if(numbersOfPLayers<=20) {
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        Player p = new Player(name);
                        players.add(p);
                        numbersOfPLayers++;
                    }else{
                        System.out.println("the number of players must be at most 20.");
                    }
                    break;
                case 2:
                    System.out.println("let's play word guess :D");
                    for (Player player : players) {
                        System.out.println(player.getName() + "'s turn: ");
                        Game game = new Game();
                        game.play();
                        player.setScore(game.getScore());
                    }
                    for(int i=0; i<players.size()-1; i++){
                        for(int j=i+1; j<players.size(); j++){
                            if (players.get(i).getScore() < players.get(j).getScore()){
                                Player temp = players.get(i);
                                players.set(i,players.get(j));
                                players.set(j,temp);

                            }
                        }
                    }
                    System.out.println("Game over!\nthe winners are:");
                    int i=1;
                    for(Player player :players){
                        System.out.println(i+". name:"+player.getName()+" score:"+player.getScore());
                        i++;
                    }
                    System.out.println();
                    addedAPlayer = false;
                    players.clear();
                    break;
                case 3:
                    System.out.println("Goodbye");
                    break outerLoop;
                default:
                    break;
            }
            ch = menu(addedAPlayer);
        }
    }
    public static int menu(boolean addedAPlayer){
        Scanner scInt = new Scanner(System.in);
        int ch;
        while(true) {
            System.out.println("1.add a player\n2.start the game\n3.exit\nChoose: ");
            if (scInt.hasNextInt()) {
                ch = scInt.nextInt();
                if (ch == 2 && !addedAPlayer) {
                    System.out.println("you need to at least add one player.");
                    scInt.nextLine();
                    continue;
                }
                if (ch == 1 || ch == 3 || ch == 2) {
                    break;
                } else {
                    System.out.println("invalid input.");
                    scInt.nextLine();
                }
            }else{
                System.out.println("invalid input.");
                scInt.nextLine();
            }
        }
        return ch;
    }
}