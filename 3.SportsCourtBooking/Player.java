package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    Admin admin ;
    private ArrayList<Player>player = new ArrayList<>();
    private String name ;
    public Player(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
   public void addPlayer (Scanner input){
       System.out.println("Enter your choice \n1-Add player\n2-Exit");
       int choice ;
       while(true){
           choice = Main.validInput(input,1,2);
       switch(choice) {
           case 1:
               System.out.println("Enter the name of the player");
               String name = input.nextLine();
               if (player.contains(name)) {
                   System.out.println("Player already exists");

               } else {
                   player.add(new Player(name));
                   System.out.println("Player added successfully : "+name);
                   return;
               }
               break;
           case 2:
               return;
       }
       }

   }
   public void removePlayer (Scanner input){
       System.out.println("Enter your choice \n1-Remove player\n2-Exit");
       int choice ;
       while(true){
           choice = Main.validInput(input,1,2);
           switch(choice) {
               case 1:
                   if (player.isEmpty()) {
                       System.out.println("Player list is empty");
                       return;
                   }
                   System.out.println("Enter the index of the player to remove");
                   displayPlayers();

                   int name = Main.validInput(input,1,player.size())-1;
                   player.remove(name);
                   System.out.println("Player removed successfully !");
                   return;
                   case 2:
                       return;



           }
       }

   }
   public void displayPlayers(){
        if (player.isEmpty()) {
            System.out.println("Player list is empty");
            return;
        }
        for (int i = 0; i < player.size(); i++) {
            System.out.println(1+i + ".  " + player.get(i).getName());
        }
   }
 public ArrayList<Player> getPlayers() {
        return player;
 }

}
