package org.example;
public class Admin {
    private Court[] courts = new Court[100];
    private int courtCount = 0;
    public void addCourt(Court court){
        if (courtCount < courts.length){
            courts[courtCount++] = court;
            System.out.println("Added " + court.getSportType() + " court.");
        }else {
            System.out.println("Court limit reached!");
        }
    }
    public boolean removeCourt(String sportType){
        for (int i = 0; i < courtCount; i++){
            if (courts[i].getSportType().equalsIgnoreCase(sportType)){
                for (int j = i; j < courtCount - 1; j++){
                    courts[j] = courts[j + 1];
                }
                courtCount--;
                System.out.println(sportType + " court removed.");
                return true;
            }
        }
        System.out.println("Court not found!");
        return false;
    }
    public Court[] getCourts(){
        Court[] result = new Court[courtCount];
        for (int i =0; i < courtCount; i++){
            result[i] = courts[i];
        }
        return result;
    }
}