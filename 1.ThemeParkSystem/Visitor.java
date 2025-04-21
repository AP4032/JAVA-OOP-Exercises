package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class Visitor {
    private String name ;
    public Visitor(String name) {
        this.name = name;

    }
    public String getName() {
        return name;
    }
    private static List<Visitor> visitors = new ArrayList<Visitor>();
    private static List <VipVisitor> vipVisitors = new ArrayList<VipVisitor>() ;
    public static void AddVisitor (){
        System.out.println("what type of visitor do you want to add? \n1-Visitor\n2-VIP Visitor");
        Scanner scanner = new Scanner(System.in);
        int choice = Main.validInput(scanner,1,2);
        if (choice == 1) {
            System.out.println("enter the name of the visitor");
            String visitorName = scanner.next();
            visitors.add(new Visitor(visitorName));
            System.out.println("visitor added successfully");
        }else{
            System.out.println("enter the name of the  VIP visitor");
            String vipVisitorName = scanner.next();
            vipVisitors.add(new VipVisitor(vipVisitorName));
            System.out.println("vip visitor added successfully");
        }


    }

    public static void showVisitors() {
        System.out.println("regular visitors: ");
        if (visitors.isEmpty()) {
            System.out.println("no visitors found");
        } else {
            for (int i = 0; i < visitors.size(); ++i) {
                System.out.println(i + 1 + ". " + visitors.get(i).getName());
            }
        }
        System.out.println("vip visitors: ");
        if(vipVisitors.isEmpty()){
            System.out.println("no VIP visitors found");
        }else{
            for(int i = 0 ; i < vipVisitors.size(); ++i  ){
                System.out.println(i+1 + ". " + vipVisitors.get(i).getName());
            }
        }
    }

public void addVisitorToRide(Ride ride) {
ride.addVisitorToRide(this);
}
public static List<Visitor> getVisitors() {
        return visitors;
}
public  static List <VipVisitor> getVipVisitors() {
        return vipVisitors;
}
    public static void showRegularVisitors() {
        for(int i = 0; i < visitors.size(); i++) {
            System.out.println((i+1) + ". " + visitors.get(i).getName());
        }
    }

    public static void showVipVisitors() {
        for(int i = 0; i < vipVisitors.size(); i++) {
            System.out.println((i+1) + ". " + vipVisitors.get(i).getName());
        }
    }

}
