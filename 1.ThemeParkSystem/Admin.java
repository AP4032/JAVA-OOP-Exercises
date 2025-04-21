package org.example;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Admin {
    private List<Ride> rides = new ArrayList<>();
    public void addRide(){
        Scanner in = new Scanner(System.in);
        System.out.println("how many rides do you want to add?");
        int ridess = Main.validInput(in,1,100);
        in.nextLine();
        if(ridess == 0 ) return;
        do {
            System.out.println("please enter a name for the ride");
            String name = in.nextLine();

            System.out.println("please enter a capacity for the ride");
            int capacity = in.nextInt();
            System.out.println("please enter a duration for the ride");
            int duration = in.nextInt();
            Ride newRide = new Ride(name, capacity, duration);
            rides.add(newRide);
            ridess--;

        }while (ridess != 0);




    }
    public List getRides () {
        return new ArrayList<>(rides);

    }
    public void removeByIndex (int index) {
        Scanner in = new Scanner(System.in);

        if(index < 0 || index >= rides.size()){
            System.out.println("Please enter a valid index");
        }
        rides.remove(index);
        System.out.println("ride " + index+1 + " removed successfully");
    }
    public int getRidesCount () {
        return rides.size();
    }
    public void showRides(){
        for (int i = 0; i < rides.size(); i++) {
            System.out.println(i+1 + ". " + rides.get(i).getName());
        }

    }
    public void printDetails() {
        if(rides.isEmpty()) {
            System.out.println("No rides found");
            return;
        }
            for(int i = 0; i < rides.size(); i++){
                Ride ride = rides.get(i);
                System.out.println(i + 1 + ". " + rides.get(i).getName()+ "   capacity = " + rides.get(i).getCapacity() + "   duration = " +
                        rides.get(i).getDuration());
                System.out.println("--Regular--");
               Visitor.showRegularVisitors();
                System.out.println("--VIP--");
                Visitor.showVipVisitors();


            }
        }


    }

