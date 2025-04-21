package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Court {
    private int bookedCourts = 0;
    private String nameSport;
    private Player bookedCourt;
    public Court(String name) {
        this.nameSport = name;
    }
    public String getNameSport() {
        return nameSport;
    }
    public void addPlayerToCourt(Scanner input,Admin admin,Player player) {
        if(admin.getCourts().isEmpty()){
            System.out.println("No court found in system add a court");
            return;


        }else if (player.getPlayers().isEmpty()){
            System.out.println("No player found for court add a player");
            return;
        }
        System.out.println("Enter the index of the court you would like to book");
        admin.showAllCourts();
        int selectedCourt2 = Main.validInput(input,1,admin.getCourts().size())-1;

        Court selectedCourt = admin.getCourts().get(selectedCourt2);
        if(selectedCourt.getBookedCourts()==1){
            System.out.println("That court is already booked");
            return;
        }
        System.out.println("Enter the index of the player you would like to add");
        player.displayPlayers();
        int playerIndex = Main.validInput(input,1,player.getPlayers().size())-1;
        Player selectedPlayer = player.getPlayers().get(playerIndex);
        selectedCourt.setBookedCourts(1);
        selectedCourt.setBookedCourt(selectedPlayer);
        System.out.println("Player : " + selectedPlayer.getName() + " booked courts : "+selectedCourt.getNameSport());
    }
    public void removePlayerFromCourt(Scanner input,Admin admin,Player player) {
        if(admin.getCourts().isEmpty()){
            System.out.println("No court has been found to remove a player of it");
            return;
        }
        if (player.getPlayers().isEmpty()) {
            System.out.println("No player has got court to remove of them ");
          return;
        }
        System.out.println("Enter the Index of the court you would like to remove a player from:");
        admin.showAllCourts();
        int selectedCourt2 = Main.validInput(input,1,player.getPlayers().size())-1;
        Court selectedCourt = admin.getCourts().get(selectedCourt2);

        Player bookedCourt = selectedCourt.getBookedPlayer();
        System.out.println("Player : " + bookedCourt.getName() + " booked court : " +selectedCourt.getNameSport());

        System.out.println("Enter the Index of the player you would like from court : ");
        player.displayPlayers();
        int playerIndex = Main.validInput(input,1,player.getPlayers().size())-1;
        Player selectedPlayer = player.getPlayers().get(playerIndex);
        if(!selectedPlayer.equals(bookedCourt)){
            System.out.println("That player is not in the booked court ");
            return;

        }
        selectedCourt.setBookedCourts(0);
        selectedCourt.setBookedCourt(null);
        System.out.println("Player \"" + selectedPlayer.getName() + "\" has been removed from court \"" + selectedCourt.getNameSport() + "\".");
    }
    public void setBookedCourts(int bookedCourts) {
        this.bookedCourts = bookedCourts;
    }
    public int getBookedCourts() {
        return bookedCourts;
    }
    public void setBookedCourt(Player bookedCourt) {
        this.bookedCourt = bookedCourt;
    }
    public Player getBookedPlayer(){
        return bookedCourt;
    }

}
