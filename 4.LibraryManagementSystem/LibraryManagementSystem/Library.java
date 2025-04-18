import java.util.Scanner;
public class Library {
     private int time ;

     public Library(){
         System.out.print("Book pickup time(year):");
         Scanner scanner = new Scanner(System.in);
         int time = scanner.nextInt();
         if (time > 2){
             System.out.println("You cannot have the book for "+time+"time");
         }else{
             System.out.println("**We hope you use the book well**");
         }

     }



    public int getTime() {
        return time;
    }


}
