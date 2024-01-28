import java.util.*;
import java.io.*;

class FickleTexasWeather {
    public static void main(String [] args) throws IOException{
        Scanner in = new Scanner(new File ("fickle.in"));

        // code here
        int num = in.nextInt();
        int celc = in.nextInt()-273;
        int count = 0;
        for(int i = 0; i<num; i++){
            int t = in.nextInt();
            if(celc< t){
                System.out.println("It's too warm.");
            }
            else{
                System.out.println("Grateful!");
                count++;
            }
        }
        String s = String.format("%.2f", (1. * count/ num * 100));
        System.out.println("The student is grateful for " + s + "% of the days.");
    }
}