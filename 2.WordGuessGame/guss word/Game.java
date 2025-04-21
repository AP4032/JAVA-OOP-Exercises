import java.util.Random;
import java.util.Scanner;

public class Game {
    public int chance;
    private String [] words;
    private  Scanner input;

    public Game(Scanner input) {
        this.words = new String[]{"SALAH","DARWIN","JOTA","ALISSON","CONORBRADLY","VANDIJK"};
        this.chance = 5;
        this.input=input;

    }


    public void start_game(){
        this.chance = 5;
        Random rand = new Random();
        int random = rand.nextInt(words.length);

        System.out.println("YOU SHOULD GUSS THE PLAYER OF LIVERPOOL!");
        System.out.print("GUSS THIS PLAYER: ");
        int [] mj = new int[words[random].length()];
        while(chance>0){


        for (int i =0; i<words[random].length(); i++){
            if(mj[i]==0) {
                System.out.print("_ ");
            }
            else
                System.out.print(words[random].charAt(i)+" ");
        }

        System.out.println();
        System.out.print("ENTER A LETTER: ");
        char c=input.next().charAt(0);
        c = Character.toUpperCase(c);
        if(check_letter(words[random],c)){
            for (int i =0; i<words[random].length(); i++){
                if(words[random].charAt(i)==c){
                    mj[i]=1;
                }
            }
            System.out.println("GUSS WRIGHT! BUT BE CAREFULL YOU HAVE < "+chance+" >");
        }
        else{
            --chance;
            if (chance == 0){
                System.out.println("THE NAME WAS: "+words[random]+".");
                System.out.println("MAYBE NEXT TIME...");
                break;
            }
            System.out.println("YOU MISS BUT YOU HAVE< "+chance+" >");
        }
            int counter = 0;
        for (int i =0; i<mj.length; i++){

            if(mj[i]==1){
              ++counter;
            }
            if(counter==mj.length){
                System.out.println("CONGRAGULATIONS YOU WON !!!");
                chance=0;
                break;
            }

        }
    }

    }
    public boolean check_letter(String letter,char c){
        for(int i=0;i<letter.length();i++){
            if(letter.charAt(i)==c){
                return true;
            }
        }
        return false;
    }
}
